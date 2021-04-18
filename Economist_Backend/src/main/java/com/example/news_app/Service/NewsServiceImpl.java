package com.example.news_app.Service;

import com.example.news_app.Dao.WeeklyNewsDao;
import com.example.news_app.Entity.WeeklyNewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private WeeklyNewsDao weeklyNewsDao;
    @Override
    public List<WeeklyNewsEntity> getList() {
        return weeklyNewsDao.findAll();
    }
}
