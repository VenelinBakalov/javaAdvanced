package familyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String personToFind = reader.readLine();

        List<String> familyData = new ArrayList<>();
        List<Person> family = new ArrayList<>();

        String info;
        while (!"End".equals(info = reader.readLine())) {
            if (info.contains(" - ")) {
                familyData.add(info);
            } else {
                String[] personInfo = info.split(" ");
                String name = personInfo[0] + " " + personInfo[1];
                String birthDate = personInfo[2];
                Person person = new Person(name, birthDate);
                family.add(person);
            }
        }

        for (String personInfo : familyData) {
            String[] personArgs = personInfo.split(" - ");
            String parentStr = personArgs[0];
            String childStr = personArgs[1];

            Person parent = family.stream()
                    .filter(p -> (parentStr.equals(p.getName()) || parentStr.equals(p.getBirthDate())))
                    .findFirst().get();

            Person child = family.stream()
                    .filter(p -> (childStr.equals(p.getName()) || childStr.equals(p.getBirthDate())))
                    .findFirst().get();

            parent.getChildren().add(child);
            child.getParents().add(parent);
        }

        Person person = family.stream()
                .filter(p -> (personToFind.equals(p.getName()) || personToFind.equals(p.getBirthDate())))
                .findFirst().get();

        System.out.println(person);
    }
}
