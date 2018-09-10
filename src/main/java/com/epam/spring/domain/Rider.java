package com.epam.spring.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rider {
    private String name;

    private List<String> riders;

    public void init() {
        riders = new ArrayList<>();
        riders.add("John");
        riders.add("Matthew");
        riders.add("Benedikt");
        riders.add("Thomas");
        riders.add("Josef");
        riders.add("Rio");

        this.name = riders.get(new Random().nextInt(riders.size()));
    }

    /**
     * Getter for name.
     *
     * @return java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name value
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
