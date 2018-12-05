package myCity;

public class TaskConfirm {

    private Citizen author;
    private boolean confirm;

    public TaskConfirm(Citizen author, boolean confirm) {
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
