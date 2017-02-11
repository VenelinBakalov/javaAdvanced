import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class CubicArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(reader.readLine());

        Deque<Bunker> bunkers = new ArrayDeque<>();
        Deque<Integer> weapons = new ArrayDeque<>();

        String input = "";

        while (!"Bunker Revision".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");

            for (String token : tokens) {
                if (Character.isDigit(token.charAt(0))) {
                    int weapon = Integer.parseInt(token);
                    weapons.add(weapon);
                } else {
                    String name = token;
                    Bunker bunker = new Bunker(name, capacity);
                    bunkers.add(bunker);
                }
            }
        }

        while (!weapons.isEmpty()) {
            Integer currentWeapon = weapons.poll();
            Bunker currentBunker = bunkers.poll();
            int currentCapacity = currentBunker.getCapacity();
            int difference = currentCapacity - currentWeapon;
            if (difference >= 0) {
                currentBunker.getWeapons().add(currentWeapon);
                currentBunker.setCapacity(difference);
                bunkers.push(currentBunker);
            } else {
                System.out.print(currentBunker.getName() + " -> ");
                StringBuilder sb = new StringBuilder();
                for (Integer integer : currentBunker.getWeapons()) {
                    sb.append(integer).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length());
                System.out.println(sb);

                weapons.push(currentWeapon);
            }
        }


    }
    static class Bunker {
        private String name;
        private List<Integer> weapons;
        private Integer capacity;

        public Bunker(String name, Integer capacity) {
            this.name = name;
            this.weapons = new ArrayList<>();
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getWeapons() {
            return weapons;
        }

        public void setWeapons(List<Integer> weapons) {
            this.weapons = weapons;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }
    }
}
