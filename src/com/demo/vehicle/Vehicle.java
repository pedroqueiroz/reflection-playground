package com.demo.vehicle;

public abstract class Vehicle {

    protected String color;
    protected String maker;

    public Vehicle(String color, String maker) {
        this.color = color;
        this.maker = maker;
    }

    public Vehicle() {}

    abstract void speedUp();

    abstract void slowDown();

    abstract void fullStop();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
