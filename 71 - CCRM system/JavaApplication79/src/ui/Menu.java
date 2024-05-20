/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import controller.ManagerController;
import utils.ValidationAndNormalizationTextUtil;

/**
 *
 * @author ADMIN
 */
public class Menu {

    public static void menu() {
        ManagerController managerController = new ManagerController();
        String menu = """
                      ========== Task program ==========
                         1. Add Task
                         2. Delete Task
                         3. Display Task
                         4. Exit
                      """;
        while (true) {
            System.out.println(menu);
            int choice = ValidationAndNormalizationTextUtil.getInt("Your choice: ", "[0-9]",
                    "Please enter an integer number from 1 to 4", 1, 4);
            switch (choice) {
                case 1:
                    managerController.addTask();
                    break;
                case 2:
                    managerController.deleteTask();
                    break;
                case 3:
                    managerController.display();
                    break;
                case 4:
                    return;
            }
        }
    }
}
