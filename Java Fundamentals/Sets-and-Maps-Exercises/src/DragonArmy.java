import java.util.*;


public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dragonCount = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonTypes = new LinkedHashMap<>();

        for (int i = 0; i < dragonCount; i++) {
            String[] dragonInfo = scanner.nextLine().split(" ");

            String type = dragonInfo[0];
            String name = dragonInfo[1];

            ArrayList<Integer> stats = new ArrayList<>();

            for (int j = 2; j < dragonInfo.length; j++) {
                stats.add(getValue(dragonInfo[j], j));
            }

            insertDragonType(dragonTypes, type);
            insertDragon(dragonTypes, type, name, stats);

        }

        LinkedHashMap<String, ArrayList<String>> typeAverageStats = new LinkedHashMap<>();

        for (String type : dragonTypes.keySet()) {
            double averageDamage = 0.0;
            double averageHealth = 0.0;
            double averageArmor = 0.0;

            for (ArrayList<Integer> stats : dragonTypes.get(type).values()) {
                averageDamage += stats.get(0);
                averageHealth += stats.get(1);
                averageArmor += stats.get(2);
            }

            averageDamage /= dragonTypes.get(type).values().size();
            averageHealth /= dragonTypes.get(type).values().size();
            averageArmor /= dragonTypes.get(type).values().size();

            ArrayList<String> averageStats = new ArrayList<>();
            averageStats.add(String.format("%.2f", averageDamage));
            averageStats.add(String.format("%.2f", averageHealth));
            averageStats.add(String.format("%.2f", averageArmor));

            typeAverageStats.put(type, averageStats);
        }

        for (String type : typeAverageStats.keySet()) {
            System.out.println(type + "::(" + String.join("/", typeAverageStats.get(type)) + ")");

            for (String dragon : dragonTypes.get(type).keySet()) {
                ArrayList<Integer> stats = dragonTypes.get(type).get(dragon);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon, stats.get(0), stats.get(1), stats.get(2));
            }
        }
    }

    private static void insertDragon(LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonTypes, String type, String name, ArrayList<Integer> stats) {
        if (!dragonTypes.get(type).containsKey(name)) {
            dragonTypes.get(type).put(name, new ArrayList<>());
        }

        dragonTypes.get(type).put(name, stats);
    }

    private static void insertDragonType(LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonTypes, String type) {
        if (!dragonTypes.containsKey(type)) {
            dragonTypes.put(type, new TreeMap<>());
        }
    }

    private static Integer getValue(String typeValue, int typeIndex) {
        int value = 0;

        if (!"null".equals(typeValue)) {
            value = Integer.parseInt(typeValue);

            return value;
        }

        switch (typeIndex) {
            case 2:
                value = 45;
                break;
            case 3:
                value = 250;
                break;
            case 4:
                value = 10;
        }

        return value;
    }

}
