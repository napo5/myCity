package myCity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;


public class CityAdmin {

    private static AtomicInteger count = new AtomicInteger(0);
    private int cityadminID;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;


    public CityAdmin(String name, String surname, LocalDate birthday, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.cityadminID = count.incrementAndGet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void wipTask(Report report) {
        if (report.getState().equals(ReportState.REGULAR)) {
            report.setState(ReportState.WORK_IN_PROGRESS);
        }
    }

    public void closeWIPReport(Report report) {
        if (report.getState().equals(ReportState.WORK_IN_PROGRESS)) {
            report.setState(ReportState.CLOSED);
        }
    }

    public void closeReport(Report report) {
        if (report.getState().equals(ReportState.REGULAR) || report.getState().equals(ReportState.SUSPENDED)) {
            report.setState(ReportState.CLOSED);
        }

    }

    public void createTask(Task task, Report report) {
        report.setTask(task);
        report.setState(ReportState.TASK_AVAILABLE);
    }

    public int getCityadminID() {
        return cityadminID;
    }

    public void setCityadminID(int cityadminID) {
        this.cityadminID = cityadminID;
    }

    /**
     * Let the CityAdmin choose for a preferred Worker
     *
     * @param workersList HashMap of Worker ordered by DaysToComplete
     * @return The ID of the Worker chosen
     * @throws IOException
     */
    public int chooseWorkerForTask(HashMap<Worker, ApplyRequest> workersList) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        workersList.forEach((k, v) -> {
            System.out.println("Choose one worker: ");
            System.out.println(k.getCitizenID() + " - " + k.getName() + "(" + v.getDaysToComplete() + ")");
        });
        int opt = Integer.parseInt(in.readLine());
        return opt;
    }

    public void addPrize(Prize prize, Board hisboard) {
        hisboard.addPrize(prize);
    }

}
	