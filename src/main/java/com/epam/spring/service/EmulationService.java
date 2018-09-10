package com.epam.spring.service;

import com.epam.spring.domain.Horse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmulationService {
    private RaceService raceService;
    private List<Horse> winners;

    private Map<Horse, Integer> positions;


    /**
     * Getter for winners.
     *
     * @return java.util.List<com.epam.spring.domain.Horse>
     */
    public List<Horse> getWinners() {
        return winners;
    }

    /**
     * Getter for raceService.
     *
     * @return com.epam.spring.service.RaceService
     */
    public RaceService getRaceService() {
        return raceService;
    }

    /**
     * Setter for raceService.
     *
     * @param raceService value
     */
    public void setRaceService(RaceService raceService) {
        this.raceService = raceService;
    }

    public void startEmulation() {
        positions = fillStartGrid(raceService);
        boolean isRaceFinished = false;
        boolean isFirstFinished = false;

        while (!isRaceFinished) {
            positions.entrySet().stream()
                    .filter(entry -> entry.getValue() < raceService.getRace().getDistance())
                    .forEach(entry -> {
                        int newPosition = 0;
                        if (entry.getValue() + entry.getKey().getSpeed() >= raceService.getRace().getDistance()) {
                            newPosition = raceService.getRace().getDistance();
                        } else {
                            newPosition = entry.getValue() + entry.getKey().getSpeed();
                        }
                        entry.setValue(newPosition);
                    });

            positions.entrySet().stream()
                    .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                    .forEach(entry -> System.out.println(entry.getValue() + " - " + entry.getKey() + "\n"));

            System.out.println("\n");

            if (!isFirstFinished && positions.entrySet().stream()
                    .anyMatch(entry -> entry.getValue() >= raceService.getRace().getDistance())) {
                isFirstFinished = true;
                winners = positions.entrySet().stream()
                        .filter(entry -> entry.getValue() >= raceService.getRace().getDistance())
                        .map(entry -> entry.getKey())
                        .collect(Collectors.toList());
            }

            if (positions.entrySet().stream()
                    .allMatch(entry -> entry.getValue() >= raceService.getRace().getDistance())) {
                isRaceFinished = true;

                if (winners.size() == 1) {
                    System.out.println("Winner is " + winners.get(0).getName());
                } else {
                    System.out.println("Winners are ");
                    winners.forEach(winner -> System.out.println(winner.getName() + " "));
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<Horse, Integer> fillStartGrid(RaceService raceService) {
        Map<Horse, Integer> grid = new HashMap<>();
        raceService.getHorsesForRace().forEach(horse -> grid.put(horse, 0));
        return grid;
    }
}
