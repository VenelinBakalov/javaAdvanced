package catLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> cats = new HashMap<>();
        String catInfo;

        while (!"End".equals(catInfo = reader.readLine())) {
            String[] catArgs = catInfo.split(" ");
            Cat cat = null;
            String type = catArgs[0];
            String name = catArgs[1];

            switch (type){
                case "Siamese":
                    int earSize = Integer.parseInt(catArgs[2]);
                    cat = new Siamese(name, earSize);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(catArgs[2]);
                    cat = new Cymric(name, furLength);
                    break;
                case "StreetExtraordinaire":
                    int decibels = Integer.parseInt(catArgs[2]);
                    cat = new StreetExtraordinaire(name, decibels);
                    break;
            }

            cats.put(name, cat);
        }

        String catName = reader.readLine();
        System.out.println(cats.get(catName));
    }
}
