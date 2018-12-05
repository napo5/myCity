package myCity;

public class TaskDone {

    private Citizen author;
    private boolean confirm;


    public TaskDone(Citizen author, boolean confirm) {
        this.author = author;
        this.confirm = confirm;
    }

    public Citizen getAuthor() {
        return author;
    }

    public void setAuthor(Citizen author) {
        this.author = author;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

}
