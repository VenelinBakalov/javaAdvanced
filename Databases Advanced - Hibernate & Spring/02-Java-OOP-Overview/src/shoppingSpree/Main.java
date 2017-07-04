package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();
        String[] peopleArgs = reader.readLine().split(";");
        for (String personInfo : peopleArgs) {
            String[] personArgs = personInfo.split("=");
            String name = personArgs[0];
            double money = Double.parseDouble(personArgs[1]);

            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException ias) {
                System.out.println(ias.getMessage());
                return;
            }

        }

        Map<String, Product> products = new HashMap<>();
        String[] productsArgs = reader.readLine().split(";");
        for (String productInfo : productsArgs) {
            String[] productArgs = productInfo.split("=");
            String name = productArgs[0];
            double cost = Double.parseDouble(productArgs[1]);

            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        while (true) {
            String[] purchase = reader.readLine().split(" ");
            if ("END".equals(purchase[0])) break;

            String personName = purchase[0];
            String productName = purchase[1];

            try {
                people.get(personName).buyProduct(products.get(productName));
                System.out.println(personName + " bought " + productName);
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
        }

        people.values().forEach(System.out::println);
    }
}
