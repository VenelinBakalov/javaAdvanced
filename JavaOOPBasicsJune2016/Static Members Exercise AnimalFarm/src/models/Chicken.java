package models;

public class Chicken {
    final int MIN_AGE = 0;
    public int MAX_AGE = 15;

    public String name;
    protected int age;

    Chicken(String name, int age) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }

        this.name = name;
        this.age = age;
    }

    private String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    private double getProductPerDay() {
        return this.calculateProductPerDay();
    }

    public double calculateProductPerDay() {
        switch (this.age) {
            case 0:
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
            case 7:
                return 3;
            case 8:
            case 9:
            case 10:
            case 11:
                return 2;
            default:
                return 1;
        }
    }
}
