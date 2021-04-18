package com.example.news_app.Controller;

import com.example.news_app.Entity.WeeklyNewsEntity;
import com.example.news_app.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class ApiRestClient {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<WeeklyNewsEntity> getAll(){
        return newsService.getList();
    }
}
