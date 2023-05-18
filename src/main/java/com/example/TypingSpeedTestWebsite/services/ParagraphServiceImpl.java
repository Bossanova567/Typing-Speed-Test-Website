package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import com.example.TypingSpeedTestWebsite.repositories.ParagraphRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
@Service("paragraphService")
public class ParagraphServiceImpl implements ParagraphService{

    @Autowired
    private ParagraphRepository paragraphRepository;

    @Operation(summary = "Find all paragraphs", description = "Returns iterable of all paragraphs using CrudRepository")
    @Override
    public Iterable<Paragraph> findAll() {
        return paragraphRepository.findAll();
    }

    @Operation(summary = "Find paragraph by id", description = "Returns paragraph with matched id")
    @Override
    public Paragraph findById(@Parameter(description = "Id to find by", required = true) int id) {
        return paragraphRepository.findById(id).get();
    }

    @Operation(summary = "Save paragraph", description = "Is used to save a paragraph, returns saved paragraph using CrudRepository.")
    @Override
    public Paragraph save(@Parameter(description = "Paragraph to save.", required = true) Paragraph paragraph) {
        return paragraphRepository.save(paragraph);
    }

    @Operation(summary = "Find paragraphs by difficulty Implementation", description = "Returns list of paragraphs with matched difficulty using ParagraphRepository.")
    @Override
    public List<Paragraph> findParagraphsByDifficulty(@Parameter(description = "Difficulty to find by.", required = true) int difficulty) {
        return paragraphRepository.findParagraphsByDifficulty(difficulty);
    }
}
