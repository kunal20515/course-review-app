package com.example.homepage;

public class courseclass {
    String coursename;
    String coursecode;
    String courseinstructor;
    String courseimage;
    String profimg;
    String descript;
    String profQualifications;
    String techtreelink;


    String assignment_link;
    String quiz_link;
    String project_link;
    String midsem_link;
    String endsem_link;
    String coursecontent_link;
    String miscellaneous_link;

    String rating;

    float score;

    public courseclass(String coursename, String coursecode, String courseinstructor, String courseimage,
                       String profimg, String descript, String profQualifications, String techtreelink,float score,
                       String assignment_link,String quiz_link,String project_link,String midsem_link,
                       String endsem_link, String coursecontent_link, String miscellaneous_link,String rating){
        this.coursename = coursename;
        this.coursecode = coursecode;
        this.courseinstructor = courseinstructor;
        this.courseimage = courseimage;
        this.profimg = profimg;
        this.descript = descript;
        this.profQualifications = profQualifications;
        this.techtreelink = techtreelink;
        this.score = score;
        this.assignment_link = assignment_link;
        this.quiz_link = quiz_link;
        this.project_link = project_link;
        this.midsem_link = midsem_link;
        this.endsem_link = endsem_link;
        this.coursecontent_link = coursecontent_link;
        this.miscellaneous_link = miscellaneous_link;
        this.rating = rating;

    }

    public String getCoursename() {
        return coursename;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public String getCourseinstructor() {
        return courseinstructor;
    }

    public String getCourseimage() {
        return courseimage;
    }

    public String getProfimg() {
        return profimg;
    }

    public String getDescript() {
        return descript;
    }

    public String getProfQualifications() {
        return profQualifications;
    }

    public String gettechtreelink() {
        return techtreelink;
    }

    public float getscore() {
        return score;
    }
    public String getrating() {
        return rating;
    }

    public String getAssignment_link() {
        return assignment_link;
    }

    public String getQuiz_link() {
        return quiz_link;
    }

    public String getProject_link() {
        return project_link;
    }

    public String getMidsem_link() {
        return midsem_link;
    }

    public String getEndsem_link() {
        return endsem_link;
    }

    public String getCoursecontent_link() {
        return coursecontent_link;
    }

    public String getMiscellaneous_link() {
        return miscellaneous_link;
    }

}