import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        while (true) {
            String[] phonebookEntry = scanner.nextLine().split("-");

            if ("search".equals(phonebookEntry[0])) {
                break;
            }

            String name = phonebookEntry[0];
            String number = phonebookEntry[1];

            phonebook.put(name, number);
        }

        while (true) {
            String searchName = scanner.nextLine();

            if ("stop".equals(searchName)) {
                break;
            }

            if (phonebook.containsKey(searchName)) {
                System.out.println(searchName + " -> " + phonebook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }
        }
    }
}
