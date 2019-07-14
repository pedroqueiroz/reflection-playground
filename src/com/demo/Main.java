package com.demo;

import com.demo.vehicle.Motorcycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Motorcycle.class;

        System.out.println("Fields");
        Arrays.stream(clazz.getSuperclass().getDeclaredFields()).forEach(
            field -> System.out.println(field.toString())
        );

        System.out.println("Constructors");
        Arrays.stream(clazz.getDeclaredConstructors()).forEach(
            (constructor -> System.out.println(constructor.toString()))
        );

        System.out.println("Methods");
        Arrays.stream(clazz.getDeclaredMethods()).forEach(
            method -> System.out.println(method.toString())
        );

        Method doDrift = clazz.getDeclaredMethod("drift");
        doDrift.setAccessible(true);

        Constructor<?> MotorcycleConstructor = clazz.getDeclaredConstructor();
        MotorcycleConstructor.setAccessible(true);

        Object instance = MotorcycleConstructor.newInstance();

        doDrift.invoke(instance);
    }
}
