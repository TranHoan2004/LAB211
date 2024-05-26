/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Task;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Inputer {

    private Task task;

    public Inputer() {
        task = new Task();
    }

    public Task getInformation() {
        return task;
    }

    public boolean inputTaskInformation() throws UnsupportedOperationException {
        task.setRequirementName(Validation.getStringByRegex("Requirement Name: ", "^([A-Z][a-z]+\\\s)*[A-Z][a-z]+$",
                "Each word in name of task must begin with an upper case letter and following by lower case letters"));
        task.setTaskTypeID(Validation.getInt("Task Type: ", "Must be a positive number greater than 0",
                "Out of range", 1, 4));
        task.setDate(Validation.checkInputDate());
        task.setPlanFrom(Validation.getDouble("From: ", "Must be a number greater than 0", 1, 24));
        double time = Validation.getDouble("To: ", "Must be a number greater than 0", 1, 24);
        if (time <= task.getPlanFrom()) {
            return false;
        }
        task.setPlanTo(time);
        task.setAssignee(Validation.getStringByRegex("Assignee: ", "^[A-Z][a-z]+$", "Please enter a word"));
        task.setReviewer(Validation.getStringByRegex("Reviewer: ", "^([A-Z][a-z]+\\\s)*[A-Z][a-z]+$",
                "Each word in name of task must begin with an upper case letter and following by lower case letters"));
        task.setID();
        return true;
    }

}
