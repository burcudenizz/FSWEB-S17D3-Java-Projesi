package com.workintech.s17g3.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Kangaroo extends Animal {
    private boolean isAggressive;
    private double height;
    public Kangaroo(int id, String name, int weight, String gender, boolean isAggressive, double height) {
        super(id, name, weight, gender);
        this.isAggressive = isAggressive;
        this.height=height;
    }
}
