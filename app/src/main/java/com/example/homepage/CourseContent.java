package com.example.homepage;

public class CourseContent {
    private String contentName;
    private String linkText;
    public CourseContent(String contentName, String linkText){
        this.contentName=contentName;
        this.linkText=linkText;
    }

    public String getContentName() {
        return contentName;
    }

    public String getLinkText() {
        return linkText;
    }
}
