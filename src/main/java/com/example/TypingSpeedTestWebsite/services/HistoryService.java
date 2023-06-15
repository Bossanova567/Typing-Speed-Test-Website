package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.History;

import java.util.List;

public interface HistoryService {

    History save(History history);

    List<History> findAllWithOrder(int userId);

}
