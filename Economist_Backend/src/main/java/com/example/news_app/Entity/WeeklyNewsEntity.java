package com.example.news_app.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "weekly_news")
public class WeeklyNewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "header")
    private String header;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "h_id",referencedColumnName = "id")
    private List<Details>details=new ArrayList<>();

    public WeeklyNewsEntity(){

    }
    public WeeklyNewsEntity(String header) {
        this.header = header;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }
}
