package com.epam.spring.data;

import com.epam.spring.domain.Horse;

import java.util.List;

public class HorseData {
    private List<Horse> horses;

    /**
     * Getter for horses.
     *
     * @return java.util.List<com.epam.spring.domain.Horse>
     */
    public List<Horse> getHorses() {
        return horses;
    }

    /**
     * Setter for horses.
     *
     * @param horses value
     */
    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }
}
