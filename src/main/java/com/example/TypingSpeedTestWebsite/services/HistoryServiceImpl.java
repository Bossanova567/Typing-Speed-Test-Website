package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.History;
import com.example.TypingSpeedTestWebsite.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("historyService")
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public History save(History history) {
        return historyRepository.save(history);
    }

    @Override
    public List<History> findAllWithOrder(int userId) {
        return historyRepository.findAllWithOrder(userId);
    }
}
