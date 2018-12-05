package myCity;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Task {

    private static AtomicInteger count = new AtomicInteger(0);
    private int taskID;
    private Report report;
    private String description;
    private int points;
    private int exp;
    public final static int pointsToConfirm = 3; //To be decided.
    private TaskState state = TaskState.WAITING_FOR_WORKER;
    private HashMap<Citizen, TaskDone> positiveCheck = new HashMap<Citizen, TaskDone>();
    private HashMap<Citizen, TaskDone> negativeCheck = new HashMap<Citizen, TaskDone>();
    private int neededCheck;
    private Worker personInCharge; // the worker who has been choose to solve the task;
    private HashMap<Worker, ApplyRequest> applyList = new HashMap<Worker, ApplyRequest>();

    public Task(String description, int points, int exp, int neededCheck, Report report) {
        this.description = description;
        this.points = points;
        this.exp = exp;
        this.taskID = count.incrementAndGet();
        this.neededCheck = neededCheck;
        this.report = report;
    }

    /* let city admin create task from console */
    public Task() {

        System.out.println("Insert description of the task : ");
        Scanner inputDescription = new Scanner(System.in);
        this.description = inputDescription.nextLine();

        System.out.println("Insert points of the task : ");
        Scanner inputPoints = new Scanner(System.in);
        this.points = inputPoints.nextInt();

        System.out.println("Insert exp of the task : ");
        Scanner inputExp = new Scanner(System.in);
        this.points = inputPoints.nextInt();

        this.state = TaskState.WAITING_FOR_WORKER;

    }


    public Report getReport() {
        return report;
    }


    public String getDescription() {
        return description;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getTaskID() {
        return this.taskID;
    }

    public HashMap<Citizen, TaskDone> getPositiveCheck() {
        return this.positiveCheck;
    }

    public HashMap<Citizen, TaskDone> getNegativeCheck() {
        return this.negativeCheck;
    }

    public int getNeededCheck() {
        return this.neededCheck;
    }

    public HashMap<Worker, ApplyRequest> getApplyList() {
        return this.applyList;
    }

    public void setPersonInCharge(Worker personInCharge) {
        this.personInCharge = personInCharge;
    }

    public Worker getPersonInCharge() {
        return this.personInCharge;
    }


    public void printApplyList() {
        for (HashMap.Entry<Worker, ApplyRequest> entry : applyList.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getKey().getSurname() + " : " + entry.getValue().getDaysToComplete());
        }
    }

    public void addApply(Worker applicant, ApplyRequest request) {
        this.applyList.put(applicant, request);
    }

    public void addCitizenCheck(Citizen citizen, TaskDone confirm) {
        if (confirm.isConfirm()) {
            positiveCheck.put(citizen, confirm);
        } else negativeCheck.put(citizen, confirm);
    }


}
