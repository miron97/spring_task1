package com.epam.spring.service;

import com.epam.spring.domain.Horse;
import com.epam.spring.domain.Race;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RaceService {

    private Race race;
    private HorseService horseService;
    private List<Horse> horsesForRace;

    /**
     * Getter for race.
     *
     * @return com.epam.spring.domain.Race
     */
    public Race getRace() {
        return race;
    }

    /**
     * Setter for race.
     *
     * @param race value
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     * Getter for horsesForRace.
     *
     * @return java.util.List<com.epam.spring.domain.Horse>
     */
    public List<Horse> getHorsesForRace() {
        return horsesForRace;
    }

    /**
     * Setter for horsesForRace.
     *
     * @param horsesForRace value
     */
    public void setHorsesForRace(List<Horse> horsesForRace) {
        this.horsesForRace = horsesForRace;
    }

    /**
     * Getter for horseService.
     *
     * @return com.epam.spring.service.HorseService
     */
    public HorseService getHorseService() {
        return horseService;
    }

    /**
     * Setter for horseService.
     *
     * @param horseService value
     */
    public void setHorseService(HorseService horseService) {
        this.horseService = horseService;
    }

    public String getRaceInfo() {
        while (horsesForRace == null || horsesForRace.size() < 2) {
            horsesForRace = horseService.getHorseData().getHorses().stream()
                    .filter(horse -> new Random().nextBoolean())
                    .collect(Collectors.toList());
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Race info: \nDistance: " + race.getDistance() + "\nHorses:\n");
        horsesForRace.forEach(horse -> sb.append("Name: " + horse.getName()
                + ", Breed: " + horse.getBreed() + ", Rider: " + horse.getRider() + "\n"));
        return sb.toString();
    }

}
