package com.epam.spring.service;

import com.epam.spring.data.HorseData;

public class HorseService {
    private HorseData horseData;

    /**
     * Getter for horseData.
     *
     * @return com.epam.spring.data.HorseData
     */
    public HorseData getHorseData() {
        return horseData;
    }

    /**
     * Setter for horseData.
     *
     * @param horseData value
     */
    public void setHorseData(HorseData horseData) {
        this.horseData = horseData;
    }
}
