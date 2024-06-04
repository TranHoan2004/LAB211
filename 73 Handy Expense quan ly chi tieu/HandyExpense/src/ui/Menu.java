/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Menu {

    private int choice = 0;

    public void menu() {
        String menu = """
                      ======== Handy Expense Program ========
                      1. Add an expense
                      2. Display all expenses
                      3. Delete an expense
                      4. Quit
                      """;
        System.out.println(menu);
        choice = Validation.getInt("Your choice: ", "Only Number!", "Out of range!", 1, 4);
    }

    public int getInt() {
        return choice;
    }
}