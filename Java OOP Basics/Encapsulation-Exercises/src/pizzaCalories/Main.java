package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] pizzaArgs = reader.readLine().split(" ");
        while (!"END".equals(pizzaArgs[0])) {
            String product = pizzaArgs[0].toLowerCase();
            switch (product) {
                case "pizza": {
                    String name = pizzaArgs[1];
                    int toppingCount = Integer.parseInt(pizzaArgs[2]);

                    if (toppingCount > 10) {
                        System.out.println("Number of toppings should be in range [0..10].");
                        return;
                    }

                    Pizza pizza = null;
                    try {
                        pizza = new Pizza(name);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        return;
                    }

                    String[] doughArgs = reader.readLine().split(" ");
                    Dough dough = getDough(doughArgs);
                    if (dough == null) return;
                    pizza.setDough(dough);

                    for (int i = 0; i < toppingCount; i++) {
                        String[] toppingArgs = reader.readLine().split(" ");
                        String toppingType = toppingArgs[1];
                        Double toppingWeight = Double.parseDouble(toppingArgs[2]);
                        try {
                            Topping topping = new Topping(toppingType, toppingWeight);
                            pizza.addTopping(topping);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            return;
                        }
                    }

                    pizza.getNumberOfToppings();

                    System.out.println(pizza);
                    return;
                }

                case "dough":
                    Dough dough = getDough(pizzaArgs);
                    if (dough == null) return;
                    System.out.println(String.format("%.2f", dough.getCalories()));
                    break;

                case "topping":
                        String toppingType = pizzaArgs[1];
                        Double toppingWeight = Double.parseDouble(pizzaArgs[2]);
                        try {
                            Topping topping = new Topping(toppingType, toppingWeight);
                            System.out.println(String.format("%.2f", topping.getCalories()));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            return;
                        }
                    break;
            }
            pizzaArgs = reader.readLine().split(" ");
        }
    }

    private static Dough getDough(String[] doughArgs) {
        String type = doughArgs[1];
        String technique = doughArgs[2];
        Double weight = Double.parseDouble(doughArgs[3]);
        Dough dough = null;
        try {
            dough = new Dough(type, technique, weight);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return dough;
    }


}
