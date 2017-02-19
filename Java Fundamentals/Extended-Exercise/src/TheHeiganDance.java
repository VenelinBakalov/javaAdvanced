import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheHeiganDance {
    private static String[][] chamber;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double playerDamage = Double.parseDouble(reader.readLine());
        chamber = new String[15][15];
        int playerRow = 7;
        int playerCol = 7;
        int playerHealth = 18500;
        double heiganHealth = 3000000;

        boolean cloudActive = false;

        resetChamber();

        while (true) {
            String[] spellArgs = reader.readLine().trim().split("\\s+");
            String spell = spellArgs[0];
            int spellRow = Integer.parseInt(spellArgs[1]);
            int spellCol = Integer.parseInt(spellArgs[2]);
            int spellDamage = spell.equals("Cloud") ? 3500 : 6000;

            if (cloudActive) {
                if ("C".equals(chamber[playerRow][playerCol])) {
                    if (playerRow - 1 >= 0 && "M".equals(chamber[playerRow - 1][playerCol])) {
                        playerRow--;
                    } else if (playerCol + 1 < 15 && "M".equals(chamber[playerRow][playerCol + 1])) {
                        playerCol++;
                    } else if (playerRow + 1 < 15 && "M".equals(chamber[playerRow + 1][playerCol])) {
                        playerRow++;
                    } else if (playerCol - 1 >= 0 && "M".equals(chamber[playerRow][playerCol - 1])) {
                        playerCol--;
                    } else {
                        playerHealth -= spellDamage;
                    }
                }
            }
            if (playerHealth <= 0) {
                System.out.println(String.format("Heigan: %.2f", heiganHealth));
                System.out.println("Player: Killed by " + (cloudActive ? "Plague Cloud" : "Eruption"));
                System.out.println(String.format("Final position: %s, %s", playerRow, playerCol));
                return;
            }

            resetChamber();
            cloudActive = false;

            heiganHealth -= playerDamage;

            if (heiganHealth <= 0) {
                System.out.println("Heigan: Defeated!");
                System.out.println("Player: " + playerHealth);
                System.out.println(String.format("Final position: %s, %s", playerRow, playerCol));
                return;
            }

            for (int row = spellRow - 1; row <= spellRow + 1; row++) {
                for (int col = spellCol - 1; col <= spellCol + 1; col++) {
                    try {
                        chamber[row][col] = "C";
                    } catch (IndexOutOfBoundsException e) {}
                }
            }
            if (spell.equals("Cloud")) {
                cloudActive = true;
            }

            if ("C".equals(chamber[playerRow][playerCol])) {
                if (playerRow - 1 >= 0 && "M".equals(chamber[playerRow - 1][playerCol])) {
                    playerRow--;
                } else if (playerCol + 1 < 15 && "M".equals(chamber[playerRow][playerCol + 1])) {
                    playerCol++;
                } else if (playerRow + 1 < 15 && "M".equals(chamber[playerRow + 1][playerCol])) {
                    playerRow++;
                } else if (playerCol - 1 >= 0 && "M".equals(chamber[playerRow][playerCol - 1])) {
                    playerCol--;
                } else {
                    playerHealth -= spellDamage;
                }
            }

            if (playerHealth <= 0) {
                System.out.println(String.format("Heigan: %.2f", heiganHealth));
                System.out.println("Player: Killed by " + (cloudActive ? "Plague Cloud" : "Eruption"));
                System.out.println(String.format("Final position: %s, %s", playerRow, playerCol));
                return;
            }

            if (spell.equals("Eruption")) {
                resetChamber();
            }
        }
    }

    private static void resetChamber() {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                chamber[row][col] = "M";
            }
        }
    }
}
