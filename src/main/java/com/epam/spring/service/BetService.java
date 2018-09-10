package com.epam.spring.service;

import com.epam.spring.domain.Horse;

import java.util.List;

public class BetService {

    private RaceService raceService;
    private Horse prediction;

    /**
     * Getter for bet.
     *
     * @return com.epam.spring.domain.Horse
     */
    public Horse getPrediction() {
        return prediction;
    }

    public boolean placeBet(String searchRequest) {

        for (Horse horse : raceService.getHorsesForRace()) {
            if (horse.getName().equalsIgnoreCase(searchRequest)
                    || horse.getRider().getName().equalsIgnoreCase(searchRequest))
                prediction = horse;
        }


        if (prediction == null) {
            System.out.println("Horse not found\n");
            return false;
        }

        return true;
    }

    public void checkBet(List<Horse> winner) {
        if (winner.contains(prediction)) {
            System.out.println("Your bet has win");
        } else {
            System.out.println("Your bet was: " + prediction.getName() + "\nYou lose");
        }
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
}
