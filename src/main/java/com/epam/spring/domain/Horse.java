package com.epam.spring.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Horse {
    private String name;
    private Rider rider;
    private Breed breed;
    private int speed;
    private static List<String> horseNames;

    static {
        horseNames = new ArrayList<>();
        horseNames.add("Elida");
        horseNames.add("Giovanni");
        horseNames.add("Cofone");
        horseNames.add("Diomede");
        horseNames.add("Bavier");
        horseNames.add("Enriquez");
    }


    public void init () {
        this.name = horseNames.remove(new Random().nextInt(horseNames.size()));
        this.speed = 10 + new Random().nextInt(10);
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

    /**
     * Getter for rider.
     *
     * @return com.epam.spring.domain.Rider
     */
    public Rider getRider() {
        return rider;
    }

    /**
     * Setter for rider.
     *
     * @param rider value
     */
    public void setRider(Rider rider) {
        this.rider = rider;
    }

    /**
     * Getter for breed.
     *
     * @return com.epam.spring.domain.Breed
     */
    public Breed getBreed() {
        return breed;
    }

    /**
     * Setter for breed.
     *
     * @param breed value
     */
    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    /**
     * Getter for speed.
     *
     * @return int
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setter for speed.
     *
     * @param speed value
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return speed == horse.speed &&
                Objects.equals(name, horse.name) &&
                Objects.equals(rider, horse.rider) &&
                Objects.equals(breed, horse.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rider, breed, speed);
    }
}
