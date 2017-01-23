package main;

import models.Chicken;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Field> fields = Arrays.asList(Chicken.class.getDeclaredFields());
        List<Method> methods = Arrays.asList(Chicken.class.getDeclaredMethods());
        assert fields.stream().filter(field -> Modifier.isPrivate(field.getModifiers())).count() == 4;
        assert methods.stream().filter(method -> Modifier.isPrivate(method.getModifiers())).count() == 1;

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.valueOf(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);

            System.out.printf("Chicken %s (age %d) can produce %.0f eggs per day.",
                    chicken.getName(),
                    chicken.getAge(),
                    chicken.getProductPerDay());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
