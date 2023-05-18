package com.example.TypingSpeedTestWebsite.controllers;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import com.example.TypingSpeedTestWebsite.services.ParagraphService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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

    @Operation(summary = "View paragraphs", description = "Heads to paragraphs page and maps them with Paragraph Service.")
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("paragraphs", paragraphService.findAll());
        return "paragraph";
    }

    @Operation(summary = "Add paragraph", description = "Heads to adding paragraph page.")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        Paragraph paragraph = new Paragraph();
        modelMap.put("paragraph", paragraph);
        return "add_paragraph";
    }

    @Operation(summary = "Add paragraph", description = "Adds new paragraph to the database. Then redirects to paragraphs viewing page.")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@RequestBody @Parameter(description = "New paragraph.", required = true) @ModelAttribute("paragraph") Paragraph paragraph){
        paragraphService.save(paragraph);
        return "redirect:/paragraph";
    }

}
