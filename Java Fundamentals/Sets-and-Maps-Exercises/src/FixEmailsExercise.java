import java.util.*;

public class FixEmailsExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> personsEmail = new LinkedHashMap<>();

        String name = "";

        while (!"stop".equals((name = scanner.nextLine()))) {
            String email = scanner.nextLine();
            int dotIndex = email.lastIndexOf('.');
            String domain = email.substring(dotIndex + 1);

            switch (domain.toLowerCase()) {
                case "uk":
                case "us":
                case "com":
                    continue;
            }

            if (!personsEmail.containsKey(name)) {
                personsEmail.put(name, new ArrayList<>());
            }

            personsEmail.get(name).add(email);
        }

        personsEmail.entrySet().forEach(pair ->
                System.out.println(pair.getKey() + " -> " + String.join(", ",
                        pair.getValue())));

//   for (Map.Entry<String, List<String>> entry : personsEmail.entrySet()) {
//       System.out.println(entry.getKey() + " -> " + String.join(", ", entry.getValue()));
//   }
    }
}
