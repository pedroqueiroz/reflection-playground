package com.demo.genie;

public class Main {

    public static void main(String[] args) {
        Genie genie = new Genie();

        genie.listenWish("I want a red Motorcycle from Yamaha");
        genie.realizarDesejo();

        genie.listenWish("I want an orange Bicycle from Itau");
        genie.realizarDesejo();
    }
}