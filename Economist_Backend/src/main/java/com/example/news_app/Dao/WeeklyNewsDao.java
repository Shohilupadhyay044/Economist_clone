package com.example.news_app.Dao;


import com.example.news_app.Entity.WeeklyNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeeklyNewsDao extends JpaRepository<WeeklyNewsEntity,Long> {
    @Override
    List<WeeklyNewsEntity> findAll();
}
