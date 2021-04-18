package com.example.news_app.Dao;

import com.example.news_app.Entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsDao extends JpaRepository<Details,Long> {
}
