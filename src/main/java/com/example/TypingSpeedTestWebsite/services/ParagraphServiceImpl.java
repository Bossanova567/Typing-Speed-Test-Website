package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import com.example.TypingSpeedTestWebsite.repositories.ParagraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
@Service("paragraphService")
public class ParagraphServiceImpl implements ParagraphService{

    @Autowired
    private ParagraphRepository paragraphRepository;

    @Override
    public Iterable<Paragraph> findAll() {
        return paragraphRepository.findAll();
    }

    @Override
    public Paragraph findById(int id) {
        return paragraphRepository.findById(id).get();
    }

    @Override
    public Paragraph save(Paragraph paragraph) {
        return paragraphRepository.save(paragraph);
    }

    @Override
    public List<Paragraph> findParagraphsWithDifficulty(int difficulty) {
        return paragraphRepository.findParagraphsWithDifficulty(difficulty);
    }
}
