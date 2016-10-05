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
    PasteRepository pasteRepository;

    @Autowired
    PasteService pasteService;

    @Autowired
    LanguageService languageService;

    @Autowired
    IpService ipService;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest servletRequest) {
        String ip = servletRequest.getHeader("X-FORWARDED-FOR");
        if (ip == null) {
            ip = servletRequest.getRemoteAddr();
        }
        String location = "unknown";
//        try {
//            location = ipService.getIpLocation(ip);
//        } catch (IOException | JSONException e) {
//            location = "unknown";
//        }
        servletRequest.getSession().setAttribute("location", location);
        servletRequest.getSession().setAttribute("ip", ip);
        model.addAttribute("languageList", languageService.getLanguageList());
        model.addAttribute("ip", ip);
        model.addAttribute("location", location);
        return "index";
    }

    @RequestMapping("/submit")
    public String submit(HttpServletRequest servletRequest, String name, String language, String content) {
        HttpSession session = servletRequest.getSession();
        int id = pasteService.savePaste(name, new Date(new java.util.Date().getTime()), language, content, servletRequest.getSession().getAttribute("ip").toString(), servletRequest.getSession().getAttribute("location").toString());
        return "redirect:/" + id;
    }

    @RequestMapping("/{id}")
    public String submit(Model model, @PathVariable("id") int id) {
        model.addAttribute("name", id);
        return "content";
    }
}
