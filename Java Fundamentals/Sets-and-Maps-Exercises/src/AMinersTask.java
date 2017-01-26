import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinersTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Long> resources = new LinkedHashMap<>();

        while (true) {
            String resource = scanner.nextLine();

            if ("stop".equals(resource)) {
                break;
            }

            long quantity = Long.parseLong(scanner.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, Long.valueOf(0));
            }
            resources.put(resource, resources.get(resource) + quantity);
        }

        for (String resource : resources.keySet()) {
            System.out.println(resource + " -> " + resources.get(resource));
        }
    }
}
