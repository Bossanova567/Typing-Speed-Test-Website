package com.example.TypingSpeedTestWebsite.repositories;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("paragraphRepository")
public interface ParagraphRepository extends CrudRepository<Paragraph, Integer> {

    @Query("from Paragraph where difficulty = :difficulty")
    public List<Paragraph> findParagraphsWithDifficulty(@Param("difficulty") int difficulty);

}
