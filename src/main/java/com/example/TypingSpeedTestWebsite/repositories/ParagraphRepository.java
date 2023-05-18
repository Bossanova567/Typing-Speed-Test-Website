package com.example.TypingSpeedTestWebsite.repositories;

import com.example.TypingSpeedTestWebsite.models.Paragraph;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("paragraphRepository")
public interface ParagraphRepository extends CrudRepository<Paragraph, Integer> {

    @Operation(summary = "Find paragraphs by difficulty", description = "Returns list of paragraphs with matched difficulty.")
    @Query("from Paragraph where difficulty = :difficulty")
    public List<Paragraph> findParagraphsByDifficulty(@Parameter(description = "Difficulty to find by.", required = true) @Param("difficulty") int difficulty);

}
