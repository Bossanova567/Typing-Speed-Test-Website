package com.example.TypingSpeedTestWebsite.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Paragraph {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "difficulty")
    private int difficulty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph1 = (Paragraph) o;
        return id == paragraph1.id && difficulty == paragraph1.difficulty && Objects.equals(text, paragraph1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, difficulty);
    }
}
