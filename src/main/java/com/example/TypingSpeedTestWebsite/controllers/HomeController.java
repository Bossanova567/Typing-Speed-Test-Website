package com.example.TypingSpeedTestWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/", "home"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        Quote quote = new Quote();
        modelMap.put("quote", quote.generateQuote());
        return "home";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about(){
        return "about";
    }
}
