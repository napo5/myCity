package myCity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Citizen {

    protected static AtomicInteger count = new AtomicInteger(0);
    protected int citizenID;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;
    private int points;
    private int exp;
    private ArrayList<Prize> claimedPrizes = new ArrayList<>();


    public Citizen(String name, String surname, LocalDate birthday, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.citizenID = count.incrementAndGet();
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

    public int getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
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

    void sendReport(Report report, Board hisCity) {
        if (hisCity.isACitizen(this)) {
            hisCity.addReport(report);
        }
    }

    public void checkTaskDone(Task task, TaskDone confirm) {
        //TaskDone should be created now.
        if (task.getState() == TaskState.WAITING_FOR_CONFIRMS) {
            task.addCitizenCheck(this, confirm);
        }
    }

    public void claimPrize(Board hisboard) {
        hisboard.printPrizes();
        // TODO scan selected prize
        Prize selectedPrize = new Prize(0, "example description", 5); // example prize
        this.claimedPrizes.add(selectedPrize);
        this.setPoints(this.points - selectedPrize.getCost());
        hisboard.removePrize(selectedPrize);
    }

    void writeComment(Comment comment, Report report) {
        report.addComment(comment);
    }

    public String toString() {
        return getName() + " " + getSurname();
    }

}


