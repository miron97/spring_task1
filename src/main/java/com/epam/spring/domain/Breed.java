package com.epam.spring.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Breed {
    private String name;

    private static List<String> breeds;

    static {
        breeds = new ArrayList<>();
        breeds.add("Abyssinian");
        breeds.add("Brandenburger");
        breeds.add("Borana");
        breeds.add("Kafa");
        breeds.add("Oldenburger");
        breeds.add("Tsushima");
    }

    public void init() {
        this.name = breeds.remove(new Random().nextInt(breeds.size()));
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
