package com.epam.spring;

import com.epam.spring.service.BetService;
import com.epam.spring.service.EmulationService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        EmulationService emulationService = (EmulationService) context.getBean("emulationService");
        BetService betService = (BetService) context.getBean("betService");
        System.out.println(emulationService.getRaceService().getRaceInfo());

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter name of horse for bet, you can write name of horse or name of rider\n");
            if (betService.placeBet(sc.nextLine())) break;
        }

        System.out.println("Press S for start");
        if (sc.nextLine().toLowerCase().contains("s")) {
            emulationService.startEmulation();
        }

        betService.checkBet(emulationService.getWinners());

    }
}
