package it.unicam.ids.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Report
 */

public class Report {

    private int ID;
    private String title;
    private String description;
    private Citizen owner;
    private HashMap<Citizen, ArrayList<String>> comments;
    private ReportState state;

    public Report(Citizen citizen, String title, String description) {
        this.title = title;
        this.description = description;
        this.owner = citizen;
        this.state = ReportState.OPEN;
        this.comments = new HashMap<>();
    }

    /**
     * Add comment inside a specific report
     * create a new arraylist if it's a new comment
     * @param citizen user that write the comment
     * @param comment comment of the user
     */
    public void addComment(Citizen citizen, String comment) {
        // Check if user has already written a comment
        if (comments.get(citizen) != null) {
            ArrayList<String> updated_comments = comments.get(citizen);
            // update comments list of user
            updated_comments.add(comment);
            this.comments.put(citizen, updated_comments);
        } else {
            ArrayList<String> citizen_comments = new ArrayList<>();
            citizen_comments.add(comment);
            this.comments.put(citizen, citizen_comments);
        }
    }

    /**
     * Change the report state
     * Only the city admin can change it
     * @param new_state the new state of the report
     */
    public void changeState(ReportState new_state) {
        //TODO Check if user is qualified to change the state
        this.state = new_state;
    }

    public void showComments() {
        System.out.print(this.comments);
    }

    public void showCommentsOfUser(Citizen citizen) {
        ArrayList<String> comments_list = comments.get(citizen);
        System.out.println("Comments of " + citizen.getName() + " " + citizen.getSurname());
        for (String comment:
             comments_list) {
            System.out.println("-" + comment);
        }
    }

    public void showReportContent() {
        System.out.println("[" + this.title + "]");
        System.out.println(this.description + "\n");
        for(Map.Entry<Citizen, ArrayList<String>> entry : this.comments.entrySet()) {
            Citizen citizen = entry.getKey();
            ArrayList<String> citizen_comments = entry.getValue();
            System.out.println(citizen.getName() + " " + citizen.getSurname());
            for(String comment:
                citizen_comments) {
                System.out.println("-" + comment);
            }
            System.out.println();
        }
    }

    //TODO add reply to comment
}
