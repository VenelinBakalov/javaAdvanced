import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));

        HashSet<String> vip = new HashSet<>();
        TreeSet<String> regular = new TreeSet<>();

        while (true) {
            String guest = scanner.nextLine();

            if ("PARTY".equals(guest)) {
                break;
            }

            String symbol = Character.toString(guest.charAt(0));
            if (numbers.contains(symbol)) {
                vip.add(guest);
            } else {
                regular.add(guest);
            }
        }

        while (true) {
            String guest = scanner.nextLine();

            if ("END".equals(guest)) {
                break;
            }

            String symbol = Character.toString(guest.charAt(0));
            if (numbers.contains(symbol)) {
                vip.remove(guest);
            } else {
                regular.remove(guest);
            }
        }

        regular.addAll(vip);

        System.out.println(regular.size());
        for (String guest : regular) {
            System.out.println(guest);
        }
    }
}
