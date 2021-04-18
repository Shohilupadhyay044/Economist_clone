package com.example.news_app.Service;

import com.example.news_app.Entity.WeeklyNewsEntity;

import java.util.List;

public interface NewsService {

    public List<WeeklyNewsEntity> getList();
}
