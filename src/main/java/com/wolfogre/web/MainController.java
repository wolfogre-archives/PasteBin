package com.wolfogre.web;

import com.wolfogre.dao.PasteRepository;
import com.wolfogre.domain.PasteEntity;
import com.wolfogre.service.LanguageService;
import com.wolfogre.service.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest servletRequest) {
        String ip = servletRequest.getHeader("X-FORWARDED-FOR");
        if (ip == null) {
            ip = servletRequest.getRemoteAddr();
        }
        model.addAttribute("languageList", languageService.getLanguageList());
        model.addAttribute("ip", ip);
        return "index";
    }

    @RequestMapping("/submit")
    public String submit(Model model, String name, String language, String content) {
        int id = pasteService.savePaste(name, new Date(new java.util.Date().getTime()), language, "unknown", content);
        return "redirect:/" + id;
    }

    @RequestMapping("/{id}")
    public String submit(Model model, @PathVariable("id") int id) {
        model.addAttribute("name", id);
        return "content";
    }
}
