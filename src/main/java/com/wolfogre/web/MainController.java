package com.wolfogre.web;

import com.wolfogre.dao.PasteRepository;
import com.wolfogre.domain.PasteEntity;
import com.wolfogre.service.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", pasteService.getMaxId());
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
