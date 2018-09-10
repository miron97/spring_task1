package com.epam.spring.domain;

import java.util.Random;

public class Race {
    private int distance;

    public void init() {
        distance = 200 + new Random().nextInt(1000);
    }

    /**
     * Getter for distance.
     *
     * @return int
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Setter for distance.
     *
     * @param distance value
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }
}
