package com.example.TypingSpeedTestWebsite.controllers;

import com.example.TypingSpeedTestWebsite.models.History;
import com.example.TypingSpeedTestWebsite.models.Paragraph;
import com.example.TypingSpeedTestWebsite.services.AccountService;
import com.example.TypingSpeedTestWebsite.services.HistoryService;
import com.example.TypingSpeedTestWebsite.services.ParagraphService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TypingTestController {

    @Autowired
    ParagraphService paragraphService;

    @Autowired
    AccountService accountService;

    @Autowired
    HistoryService historyService;

    @Operation(summary = "View Typing Speed Testing page", description = "Heads to Typing Speed Test page, passes paragraph values from database to page, using ParagraphService.")
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String typingTest(ModelMap modelMap) {
        List<Paragraph> paragraphs = (List<Paragraph>) paragraphService.findAll();
        String[] textArray = paragraphs.stream().map(Paragraph::getText).toArray(String[]::new);
        modelMap.addAttribute("textArray", textArray);
        return "typing_test";
    }

    @Operation(summary = "Save test result", description = "Saves the result of the test.")
    @RequestMapping(value = "save_result", method = RequestMethod.POST)
    public String saveResult(Authentication authentication, @Parameter(description = "Result of the test.", required = true) @RequestBody History result) {
        if (authentication == null) {
            return "redirect:/user-panel";
        }
        else {
            System.out.println(accountService.findByUsername(authentication.getName()).getId());
            result.setUserId(accountService.findByUsername(authentication.getName()).getId());
            historyService.save(result);
        }
        return "typing_test";
    }
}
