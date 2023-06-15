package com.example.TypingSpeedTestWebsite.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class History {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "wpm")
    private int wpm;
    @Basic
    @Column(name = "cpm")
    private int cpm;
    @Basic
    @Column(name = "mistakes")
    private int mistakes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWpm() {
        return wpm;
    }

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }

    public int getCpm() {
        return cpm;
    }

    public void setCpm(int cpm) {
        this.cpm = cpm;
    }

    public int getMistakes() {
        return mistakes;
    }

    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return id == history.id && userId == history.userId && wpm == history.wpm && cpm == history.cpm && mistakes == history.mistakes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, wpm, cpm, mistakes);
    }

}
