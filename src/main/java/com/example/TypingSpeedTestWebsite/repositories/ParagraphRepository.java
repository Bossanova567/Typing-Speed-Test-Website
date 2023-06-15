package com.example.TypingSpeedTestWebsite.repositories;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("paragraphRepository")
public interface ParagraphRepository extends CrudRepository<Paragraph, Integer> {

}
