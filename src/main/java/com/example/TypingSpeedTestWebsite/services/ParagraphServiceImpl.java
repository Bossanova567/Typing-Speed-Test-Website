package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import com.example.TypingSpeedTestWebsite.repositories.ParagraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Paragraph save(Paragraph paragraph) {
        return paragraphRepository.save(paragraph);
    }

}
