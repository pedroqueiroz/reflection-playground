package com.demo.vehicle;

import com.demo.vehicle.annotation.AlternativeName;

@AlternativeName("Chopper")
public class Motorcycle extends Vehicle {
    public Motorcycle(String color, String maker) {
        super(color, maker);

        System.out.println(String.format("I just built the %s Motorcycle from %s!", color, maker));
    }

    private Motorcycle() {
        System.err.println("Thank god this constructor is private, don't want this to be invoked.");
    }

    @Override
    public void speedUp() {
        System.out.println("Yay, it's speeding up!");
    }

    @Override
    public void slowDown() {
        System.out.println("Awwn, I need to slow down");
    }

    @Override
    public void fullStop() {
        System.out.println("Oh shoot, it's gonna crash!");
    }

    private void drift() {
        System.err.println("The law does not allow me to do drifts, it could be danger.");
    }
}
