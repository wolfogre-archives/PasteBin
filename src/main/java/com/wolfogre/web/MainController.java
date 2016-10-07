package com.wolfogre.web;

import com.wolfogre.dao.PasteRepository;
import com.wolfogre.domain.PasteEntity;
import com.wolfogre.service.IpService;
import com.wolfogre.service.LanguageService;
import com.wolfogre.service.PasteService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * Created by wolfogre on 10/3/16.
 */
@Controller
public class MainController {

    @Autowired
    PasteService pasteService;

    @Autowired
    LanguageService languageService;

    @Autowired
    IpService ipService;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest servletRequest) {
        String ip = servletRequest.getHeader("X-FORWARDED-FOR");
        // TODO: X-FORWARDED-FOR 可能拥有多个IP，因为可能有多层代理
        // TODO: 如果服务器不存在 Nginx 代理，客户端可能伪装 X-FORWARDED-FOR，这时得不到真的IP
        // TODO: 想采用控制IP的方式限制机器人行为这一点有点麻烦
        if (ip == null) {
            ip = servletRequest.getRemoteAddr();
        }
        String location = "unknown";
        model.addAttribute("languageList", languageService.getLanguageList());
        model.addAttribute("ip", ip);
        model.addAttribute("location", location);
        model.addAttribute("countInLastHour", pasteService.getCountInLastHour(ip));
        return "index";
    }

    @RequestMapping("/submit")
    public String submit(HttpServletRequest servletRequest, String location, String name, String language, String content) {
        String ip = servletRequest.getHeader("X-FORWARDED-FOR");
        // TODO: X-FORWARDED-FOR 可能拥有多个IP，因为可能有多层代理
        // TODO: 如果服务器不存在 Nginx 代理，客户端可能伪装 X-FORWARDED-FOR，这时得不到真的IP
        // TODO: 想采用控制IP的方式限制机器人行为这一点有点麻烦
        if (ip == null) {
            ip = servletRequest.getRemoteAddr();
        }
        int id = pasteService.savePaste(name, new Date(new java.util.Date().getTime()), language, content, ip, location);
        return "redirect:/" + id;
    }

    @RequestMapping("/{id:\\d+}")
    public String submit(Model model, @PathVariable("id") int id) {
        PasteEntity pasteEntity = pasteService.getPaste(id);
        if(pasteEntity == null)
            return "error";
        model.addAttribute("pasteEntity", pasteEntity);
        String content = pasteEntity.getContent();
        model.addAttribute("content", pasteEntity.getContent());
        return "content";
    }
}
