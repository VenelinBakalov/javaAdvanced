import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> legendaryMaterials = new TreeMap<>();
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("fragments", 0);
        legendaryMaterials.put("motes", 0);

        String legendaryItem = "";

        while (true) {
            String[] materialsInfo = scanner.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < materialsInfo.length; i += 2) {
                int count = Integer.parseInt(materialsInfo[i]);
                String material = materialsInfo[i + 1];

                if (isLegendary(material)) {
                    insertMaterial(legendaryMaterials, material, count);

                    int currentCount = legendaryMaterials.get(material);

                    if (currentCount >= 250) {
                        legendaryMaterials.put(material, currentCount - 250);
                        legendaryItem = getItemObtained(material);
                        break;
                    }

                } else {
                    insertMaterial(junkMaterials, material, count);
                }
            }

            if (legendaryItem != "") {
                break;
            }
        }

        System.out.println(legendaryItem);
        legendaryMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        for (String item : junkMaterials.keySet()) {
            System.out.println(item + ": " + junkMaterials.get(item));
        }
    }

    private static String getItemObtained(String material) {
        String item = "";
        switch (material) {
            case "shards":
                item = "Shadowmourne obtained!";
                break;
            case "fragments":
                item = "Valanyr obtained!";
                break;
            case "motes":
                item = "Dragonwrath obtained!";
                break;
        }
        return item;
    }

    private static void insertMaterial(TreeMap<String, Integer> materials, String material, int count) {
        if (!materials.containsKey(material)) {
            materials.put(material, 0);
        }
        materials.put(material, materials.get(material) + count);
    }

    private static boolean isLegendary(String material) {
        return "shards".equals(material) || "fragments".equals(material) || "motes".equals(material);
    }
}
