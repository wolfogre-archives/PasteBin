package com.wolfogre.web;

import com.wolfogre.domain.PasteEntity;
import com.wolfogre.service.IpService;
import com.wolfogre.service.LanguageService;
import com.wolfogre.service.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

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
    public String index(Model model, HttpServletRequest servletRequest, String id) {
        if(id != null && !id.isEmpty())
            return "redirect:/" + id;
        String ip = ipService.getIpFromForwardedFor(servletRequest.getHeader("X-FORWARDED-FOR"));

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
        String ip = ipService.getIpFromForwardedFor(servletRequest.getHeader("X-FORWARDED-FOR"));
        if (ip == null) {
            ip = servletRequest.getRemoteAddr();
        }
        if(pasteService.getCountInLastHour(ip) > 60)
            return "redirect:/error";
        int id = pasteService.savePaste(name, new Date(new java.util.Date().getTime()), language, content, ip, location);
        return "redirect:/" + id;
    }

    @RequestMapping("/{id:\\d+}")
    public String submit(Model model, HttpServletRequest servletRequest, @PathVariable("id") int id) {
        PasteEntity pasteEntity = pasteService.getPaste(id);
        if(pasteEntity == null)
            return "error";
        model.addAttribute("id", id);
        model.addAttribute("pasteEntity", pasteEntity);
        model.addAttribute("content", pasteEntity.getContent());
        model.addAttribute("url", servletRequest.getRequestURL().toString());
        return "content";
    }
}
