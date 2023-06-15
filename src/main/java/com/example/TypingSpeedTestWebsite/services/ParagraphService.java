package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.Paragraph;

public interface ParagraphService {

    Iterable<Paragraph> findAll();

    Paragraph save(Paragraph paragraph);

}
