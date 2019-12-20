package com.pansoft.pojo;

import java.io.Serializable;

public class ResultEntity implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String title ;
    private String url ;
    private String fromDate ;
    private String insertDate ;
    public ResultEntity() {
        // TODO Auto-generated constructor stub
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFromDate() {
        return fromDate;
    }
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
    public String getInsertDate() {
        return insertDate;
    }
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }
    
    @Override
    public String toString() {
        return title + "," + url + "," + fromDate + "," + insertDate;
    }
}
