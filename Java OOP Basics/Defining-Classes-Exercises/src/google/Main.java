package google;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        Map<String, Person> people = new HashMap<>();

        while (!"End".equals(command = reader.readLine())) {
            String[] commandArgs = command.split(" ");
            String name = commandArgs[0];

            people.putIfAbsent(name, new Person(name));
            Person person = people.get(name);
            String informationType = commandArgs[1];

            switch (informationType) {
                case "company":
                    setCompany(commandArgs, person);
                    break;

                case "pokemon":
                    addPokemon(commandArgs, person);
                    break;

                case "parents":
                    addParent(commandArgs, person);
                    break;

                case "children":
                    addChildren(commandArgs, person);
                    break;

                case "car":
                    setCar(commandArgs, person);
                    break;
                default:
                    break;
            }
        }

        String personName = reader.readLine();
        System.out.println(people.get(personName));
    }

    private static void setCar(String[] commandArgs, Person person) {
        String carModel = commandArgs[2];
        int carSpeed = Integer.parseInt(commandArgs[3]);
        Car car = new Car(carModel, carSpeed);
        person.setCar(car);
        return;
    }

    private static void addChildren(String[] commandArgs, Person person) {
        String childName = commandArgs[2];
        String childBirthday = commandArgs[3];
        Child child = new Child(childName, childBirthday);
        person.getChildren().add(child);
    }

    private static void addParent(String[] commandArgs, Person person) {
        String parentName = commandArgs[2];
        String parentBirthday = commandArgs[3];
        Parent parent = new Parent(parentName, parentBirthday);
        person.getParents().add(parent);
    }

    private static void addPokemon(String[] commandArgs, Person person) {
        String pokemonName = commandArgs[2];
        String pokemonType = commandArgs[3];
        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        person.getPokemons().add(pokemon);
    }

    private static void setCompany(String[] commandArgs, Person person) {
        String companyName = commandArgs[2];
        String department = commandArgs[3];
        double salary = Double.parseDouble(commandArgs[4]);
        Company company = new Company(companyName, department, salary);
        person.setCompany(company);
    }
}
