/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Task {

    private String requirementName,
            assignee,
            reviewer,
            date;
    private double planFrom,
            planTo;
    private int taskTypeID,
            ID = 0;

    public Task() {

    }

    public Task(String requirementName, String assignee, String reviewer, String date, double planFrom, double planTo, int taskTypeID, int ID) {
        this.requirementName = requirementName;
        this.assignee = assignee;
        this.reviewer = reviewer;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.taskTypeID = taskTypeID;
        this.ID = ID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public int getID() {
        return ID;
    }

    public void setID() {
        this.ID += 1;
    }

    public double getTime() {
        return getPlanTo() - getPlanFrom();
    }

    public String getType(int type) {
        switch (type) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
        }
        return null;
    }

    public void display() {
        System.out.println();
        System.out.printf("%-15d%-15s%-15s%-15s%-15.2f%-15s%s",
                this.getID(),
                this.getRequirementName(),
                this.getType(this.getTaskTypeID()),
                this.getDate(),
                this.getTime(),
                this.getAssignee(),
                this.getReviewer());
    }

}