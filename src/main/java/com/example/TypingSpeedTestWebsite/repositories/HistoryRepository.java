package com.example.TypingSpeedTestWebsite.repositories;

import com.example.TypingSpeedTestWebsite.models.History;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("historyRepository")
public interface HistoryRepository extends CrudRepository<History, Integer> {

    @Query("from History where userId = :userId order by id desc")
    List<History> findAllWithOrder(@Param("userId") int userId);

}
