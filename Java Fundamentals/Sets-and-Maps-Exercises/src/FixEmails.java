import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> mailList = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();

            if ("stop".equals(name)) {
                break;
            }

            String email = scanner.nextLine();

            mailList.put(name, email);
        }

        LinkedHashMap<String, String> fixedMailList = new LinkedHashMap<>();

        for (String user : mailList.keySet()) {
            String mail = mailList.get(user);
            String[] mailSplit = mail.split("\\.");
            String domain = mailSplit[mailSplit.length - 1];

            if (!"us".equals(domain) && !"uk".equals(domain) && !"com".equals(domain)) {
                fixedMailList.put(user, mail);
            }
        }

        for (String user : fixedMailList.keySet()) {
            System.out.println(user + " -> " + fixedMailList.get(user));
        }
    }
}
