package com.example.homepage;

public class userclass {
    String username;
    String password;
    float sgpa;
    int[] ls;
    String c1;
    String c2;
    String c3;
    String c4;
    String c5;

    String branch;

    String semester;

    String rollno;
    boolean reviewgiven = false;

    public userclass(String username, String password, String l1, String l2, String l3, String l4, String l5,int[] ls, float sgpa,String branch,String semester,String rollno){
        this.username = username;
        this.password = password;
        this.sgpa = sgpa;
        this.ls = ls;
        this.c1 = l1;
        this.c2 = l2;
        this.c3 = l3;
        this.c4 = l4;
        this.c5 = l5;
        this.branch = branch;
        this.semester = semester;
        this.rollno = rollno;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public float getSgpa() {
        return sgpa;
    }

    public int[] getLs() {
        return ls;
    }

    public String getC1() {
        return c1;
    }

    public String getC2() {
        return c2;
    }

    public String getC3() {
        return c3;
    }

    public String getC4() {
        return c4;
    }

    public String getC5() {
        return c5;
    }

    public String getbranch() {
        return branch;}

    public String getsemester() {
        return semester;}

    public String getrollno() {
        return rollno;}

    public boolean isReviewgiven() {
        return reviewgiven;
    }
}
