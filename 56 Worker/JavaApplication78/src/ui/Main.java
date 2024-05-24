/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.ManagerController;
import entity.Worker;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        ManagerController managerController = new ManagerController();
        String menu = """
                      ========================== Worker Managerment ==========================
                          1. Add Worker
                          2. Up salary
                          3. Down salary
                          4. Display Information salary
                          5. Exit                      
                      """;
        while (true) {
            System.out.print(menu);
            int choice = Validation.checkInputInRange("Your choice: ", "Please enter an integer number from 1 to 5", 1, 5);
            switch (choice) {
                case 1 -> {
                    do {
                        try {
                            managerController.addWorker();
                        } catch (Exception e) {
                            System.out.println("ID is existed, worker will not be added");
                        }
                    } while (Validation.checkYN());
                    System.out.printf("""
                                            -------------------- Display Worker Information -----------------------
                                            %-15s%-15s%-15s%-15s%-15s
                                            """, "Code", "Name", "Age", "Salary", "Work Location");
                    managerController.show();
                    System.out.println("Added successfully!");
                }
                case 2 -> {
                    System.out.println("--------------------------- INCREASE SALARY ---------------------------");                    
                    try {
                        managerController.increaseSalary();
                    } catch (Exception e) {
                        System.out.println("List is null, cannot change salary");
                    }
                }
                case 3 -> {
                    System.out.println("--------------------------- DECREASE SALARY ---------------------------");
                    Worker list = managerController.getList();
                    if (list == null) {
                        System.out.println("Cannot change salary because there is no workers in the list");
                        return;
                    }
                    try {
                        managerController.decreareSalary(list);
                    } catch (Exception e) {
                        System.out.println("Amount is greater than salary, cannot be decreased");
                    }
                }
                case 4 -> {
                    System.out.printf("""
                                            -------------------- Display Information Salary -----------------------
                                            %-15s%-15s%-15s%-15s%-15s%-15s
                                            """, "Code", "Name", "Age", "Salary", "Status", "Date");
                    managerController.display();
                }
                case 5 -> {
                    return;
                }
            }
        }
    }
}
