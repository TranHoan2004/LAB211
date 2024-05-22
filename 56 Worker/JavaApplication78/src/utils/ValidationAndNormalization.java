/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entity.Worker;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ValidationAndNormalization {

    public static String removeUnneccessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+", "");
    }

    public static int checkInputInRange(String msg, String error, int min, int max) {
        while (true) {
            int input = Integer.parseInt(getStringByRegex(msg, "[0-9]+", error));
            if (input < min || input > max) {
                System.err.println("Out of range!");
            } else {
                return input;
            }
        }
    }

    public static double getDouble(String msg, String error, double min, double max) {
        while (true) {
            double input = Double.parseDouble(getStringByRegex(msg, "[0-9]*\\.?[0-9]+", error));
            if (input < min || input > max) {
                System.err.println("Out of range!");
            } else {
                return input;
            }
        }
    }

    public static String getStringByRegex(String msg, String regex, String err) {
        Scanner sc = new Scanner(System.in);
        String string = null;
        while (true) {
            System.out.print(msg);
            string = sc.nextLine();
            if (string.matches(regex)) {
                return string;
            } else {
                System.err.println(err);
            }
        }
    }

    public static boolean checkItemExist(String id, ArrayList<Worker> listWorker) {
        for (Worker person : listWorker) {
            if (person.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkYN() {
        String input = getStringByRegex("Do you want to continue (Y/N): ", "[YNyn]", "[YNyn]");
        return input.toLowerCase().equalsIgnoreCase("y");
    }
    public static Worker findWorkerByID(String id, ArrayList<Worker> worker) {
        for (Worker person : worker) {
            if (id.equalsIgnoreCase(person.getId())) {
                return person;
            }
        }
        return null;
    }
}