package com.workintech.s17g3.entity;

import lombok.Data;

@Data
public class Koala extends Animal {
    private int sleepHour;

    public Koala(int id, String name, int weight, String gender, int sleepHour) {
        super(id, name, weight, gender);
        this.sleepHour = sleepHour;
    }
}
