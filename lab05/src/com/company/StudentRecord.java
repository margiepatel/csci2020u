package com.company;

public class StudentRecord {
    private String sid;
    private double assignments;
    private double midterm;
    private double finalExam;
    private double finalMark;
    private String letterGrade;

    public StudentRecord(String sid, double assignments, double midterm, double finalExam) {
        this.sid = sid;
        this.assignments = assignments;
        this.midterm = midterm;
        this.finalExam = finalExam;



        // Calculate mark
        finalMark = assignments * 0.2f + midterm * 0.3f + finalExam * 0.5f;

        // Calculate letter grade
        if (finalMark < 50.0f) {
            letterGrade = "F";
        } else if (finalMark < 60) {
            letterGrade = "D";
        } else if (finalMark < 70) {
            letterGrade = "C";
        } else if (finalMark < 80) {
            letterGrade = "B";
        } else {
            letterGrade = "A";
        }

    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public double getAssignments() {
        return assignments;
    }

    public void setAssignments(double assignments) {
        this.assignments = assignments;
    }

    public double getMidterm() {
        return midterm;
    }

    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

}