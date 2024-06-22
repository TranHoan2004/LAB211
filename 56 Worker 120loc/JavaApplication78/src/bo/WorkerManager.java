/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.History;
import entity.History.Status;
import entity.Worker;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class WorkerManager {

    private final ArrayList<Worker> listOfWorker;
    private final Stack<History> listOfHistory;

    public WorkerManager() {
        this.listOfWorker = new ArrayList<>();
        this.listOfHistory = new Stack<>();
    }

    public ArrayList<Worker> getList() {
        return listOfWorker;
    }

    public Stack<History> getHistory() {
        return listOfHistory;
    }

    public void addWorker(Worker work) throws Exception {
        if (isExist(work.getId())) {
            throw new Exception("Id is existed");
        }
        listOfWorker.add(work);
    }

    public void increaseSalary(double amount, String code) throws Exception {
        Worker worker = findByID(code);
        worker.setSalary(worker.getSalary() + amount);
        addToList(Status.UP, worker);
    }

    public void decreaseSalary(double amount, String code) throws Exception {
        Worker worker = findByID(code);
        if (amount > worker.getSalary()) {
            throw new Exception("Amount is larger than salary");
        }
        worker.setSalary(worker.getSalary() - amount);
        addToList(Status.DOWN, worker);
    }

    private void addToList(Status status, Worker worker) {
        Worker w = new Worker(worker.getId(), worker.getName(), worker.getWorkLocation(), worker.getAge(), worker.getSalary());
        History history = new History(status, w);
        listOfHistory.push(history);
    }

    private Worker findByID(String id) throws Exception {
        for (Worker person : listOfWorker) {
            if (id.equalsIgnoreCase(person.getId())) {
                return person;
            }
        }
        throw new Exception("Worker has this id is not existed");
    }

    public boolean isExist(String id) {
        for (Worker person : listOfWorker) {
            if (person.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
}
