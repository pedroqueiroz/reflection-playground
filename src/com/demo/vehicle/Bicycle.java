package com.demo.vehicle;

import com.demo.vehicle.annotation.AlternativeName;

@AlternativeName("Bike")
public class Bicycle extends Vehicle {

    public Bicycle(String color, String maker) {
        super(color, maker);
    }

    @Override
    void speedUp() {}

    @Override
    void slowDown() {}

    @Override
    void fullStop() {}
}
