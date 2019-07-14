package com.demo.genie;

import com.demo.vehicle.annotation.AlternativeName;
import com.demo.vehicle.Vehicle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genie {
    private static final String REGEX = "\\bI want a(n?)\\b\\s(\\w+)\\s(\\w+)\\s\\bfrom\\s\\b(\\w+)";
    private String vehicle;
    private String color;
    private String maker;

    public void listenWish(String wish) {
        Pattern pattern = Pattern.compile(REGEX);

        Matcher matcher = pattern.matcher(wish);
        if (matcher.find()) {
            color = matcher.group(2);
            vehicle = matcher.group(3);
            maker = matcher.group(4);
        }
        else {
            System.out.println("I did not understand your wish.");
        }
    }

    public void realizarDesejo() {
        if (vehicle == null) {
            System.err.println("It would be awesome to listen to your wish first.");

            return;
        }

        try {
            String pathToClass = String.format("com.demo.vehicle.%s", vehicle);

            Class<?> vehicleClass = Class.forName(pathToClass);
            validaVeiculo(vehicleClass);

            Constructor<?> vehicleConstructor = vehicleClass.getDeclaredConstructor(String.class, String.class);
            vehicleConstructor.newInstance(color, maker);

            announceWishWasAccomplished(vehicleClass);
        }
        catch (ClassNotFoundException e) {
            System.err.println("This vehicle does not exist!");
        }
        catch (NoSuchMethodException e) {
            System.err.println("This vehicle constructor does not exist!");
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.err.println("Oh geez, I cannot proceed to build this vehicle!");
        }
    }

    private void validaVeiculo(Class<?> classeDoVeiculo) {
        if (!Vehicle.class.isAssignableFrom(classeDoVeiculo)) {
            throw new RuntimeException("I can build vehicles only!");
        }
    }

    private void announceWishWasAccomplished(Class<?> vehicleClass) {
        AlternativeName alternativeName = vehicleClass.getAnnotation(AlternativeName.class);

        String vehicleName = vehicleClass.getSimpleName();

        if (alternativeName != null) {
            vehicleName = alternativeName.value();
        }

        System.out.println(String.format("Your %s is ready! :)", vehicleName));
    }
}
