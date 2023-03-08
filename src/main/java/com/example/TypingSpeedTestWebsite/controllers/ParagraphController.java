package com.example.TypingSpeedTestWebsite.controllers;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import com.example.TypingSpeedTestWebsite.services.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/paragraph")
public class ParagraphController {

    @Autowired
    ParagraphService paragraphService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("paragraphs", paragraphService.findAll());
        return "paragraph";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        Paragraph paragraph = new Paragraph();
        modelMap.put("paragraph", paragraph);
        return "add_paragraph";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("paragraph") Paragraph paragraph){
        paragraphService.save(paragraph);
        return "redirect:/paragraph";
    }

}
