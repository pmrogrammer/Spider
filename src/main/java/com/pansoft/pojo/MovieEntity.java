package com.pansoft.pojo;

import java.util.List;

public class MovieEntity {
    private String title ;
    private String rate ;
    private List<String> directors ;
    private List<String> casts ;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    
    public List<String> getDirectors() {
        return directors;
    }
    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }
    public List<String> getCasts() {
        return casts;
    }
    public void setCasts(List<String> casts) {
        this.casts = casts;
    }
    @Override
    public String toString() {
        return title + "," + rate + "," + directors + "," + casts;
    }
   
    
}
