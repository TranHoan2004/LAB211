/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.Manager;
import entity.Worker;
import utils.ValidationAndNormalizationTextUtil;

/**
 *
 * @author ADMIN
 */
public class ManagerController {

    private Manager manager;
    private Worker worker;

    public ManagerController() {
        manager = new Manager();
        worker = new Worker();
    }

    public void addWorker() {
        manager.addWorker();
    }

    public void upSalary() {
        manager.changeSalary("up");
    }

    public void downSalary() {
        manager.changeSalary("down");
    }
    public void getInformation() {
        manager.getInformationSalary();
    }
}
