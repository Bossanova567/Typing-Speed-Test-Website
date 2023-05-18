package com.example.TypingSpeedTestWebsite.controllers;

import com.example.TypingSpeedTestWebsite.feature.Quote;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/", "home"})
public class HomeController {

    @Operation(summary = "View home page", description = "Generates new quote and heads to home page.")
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        Quote quote = new Quote();
        modelMap.put("quote", quote.generateQuote());
        return "home";
    }

    @Operation(summary = "View about page", description = "Heads to about page.")
    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about(){
        return "about";
    }
}
