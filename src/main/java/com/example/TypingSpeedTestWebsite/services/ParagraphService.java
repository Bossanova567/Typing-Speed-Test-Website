package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParagraphService {

    public Iterable<Paragraph> findAll();

    public Paragraph findById(int id);

    public Paragraph save(Paragraph paragraph);

    public List<Paragraph> findParagraphsByDifficulty(@Param("difficulty") int difficulty);

}
