package com.epam.spring.config;

import com.epam.spring.data.HorseData;
import com.epam.spring.domain.Breed;
import com.epam.spring.domain.Horse;
import com.epam.spring.domain.Race;
import com.epam.spring.domain.Rider;
import com.epam.spring.service.BetService;
import com.epam.spring.service.EmulationService;
import com.epam.spring.service.HorseService;
import com.epam.spring.service.RaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

@Configuration
public class AppContext {

    @Bean(initMethod = "init")
    @Scope("prototype")
    public Rider rider() {
        Rider rider = new Rider();
        return rider;
    }

    @Bean(initMethod = "init")
    @Scope("prototype")
    public Breed breed() {
        Breed breed = new Breed();
        return breed;
    }

    @Bean(initMethod = "init")
    @Scope("prototype")
    public Horse horse() {
        Horse horse = new Horse();
        horse.setBreed(breed());
        horse.setRider(rider());
        return horse;
    }

    @Bean(initMethod = "init")
    public Race race() {
        Race race = new Race();
        return race;
    }

    @Bean
    public HorseService horseService() {
        HorseService horseService = new HorseService();
        horseService.setHorseData(horseData());
        return horseService;
    }

    @Bean
    public RaceService raceService() {
        RaceService raceService = new RaceService();
        raceService.setHorseService(horseService());
        raceService.setRace(race());
        return raceService;
    }

    @Bean
    public EmulationService emulationService() {
        EmulationService emulationService = new EmulationService();
        emulationService.setRaceService(raceService());
        return emulationService;
    }

    @Bean
    public BetService betService() {
        BetService betService = new BetService();
        betService.setRaceService(raceService());
        return betService;
    }

    @Bean
    public HorseData horseData() {
        HorseData horseData = new HorseData();
        horseData.setHorses(Arrays.asList(horse(), horse(), horse(), horse(), horse(), horse()));
        return horseData;
    }
}
