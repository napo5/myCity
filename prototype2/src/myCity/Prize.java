package myCity;

import java.util.concurrent.atomic.AtomicInteger;

public class Prize {

    private static AtomicInteger count = new AtomicInteger(0);
    private int prizeID;
    private String description;
    private int cost;


    public Prize(int prizeID, String description, int cost) {
        this.prizeID = prizeID;
        this.description = description;
        this.cost = cost;
        this.prizeID = count.incrementAndGet();

    }

    public int getPrizeID() {
        return prizeID;
    }

    public int getCost() {
        return cost;
    }
}

