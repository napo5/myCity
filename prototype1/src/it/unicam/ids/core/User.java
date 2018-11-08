package it.unicam.ids.core;

/**
 * Generic user
 */

public class User {

    private static int current_id = 1000;
    private int ID;
    private String name;
    private String surname;
    private String birtday;
    private String email;

    public User(String name, String surname, String birtday, String email) {
        this.ID = current_id;
        this.name = name;
        this.surname = surname;
        this.birtday = birtday;
        this.email = email;
        current_id += 1;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }
}
