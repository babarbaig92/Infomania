package com.example.babarbaig.infomania;

import android.widget.Button;

/**
 * Created by Babar Baig on 2/8/2016.
 */
public class StudentResult {

    private String courseName;
    private String assessmentName;
    private String marksObtained;
    private String totalMarks;
    private String commentsName;

    Button editButton;

    public StudentResult(){
        editButton = null;
    }

    public StudentResult(String courseName, String assessmentName, String marksObtained, String totalMarks, String commentsName) {
        this.courseName = courseName;
        this.assessmentName = assessmentName;
        this.marksObtained = marksObtained;
        this.totalMarks = totalMarks;
        this.commentsName = commentsName;
        //this.editButton = editButton;
        editButton = null;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(String marksObtained) {
        this.marksObtained = marksObtained;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getCommentsName() {
        return commentsName;
    }

    public void setCommentsName(String commentsName) {
        this.commentsName = commentsName;
    }

    public Button getEditButton() {
        return editButton;
    }

    public void setEditButton(Button editButton) {
        this.editButton = editButton;
    }
}


