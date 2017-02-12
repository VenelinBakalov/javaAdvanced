import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> masters = new ArrayDeque<>();
        Deque<String> knights = new ArrayDeque<>();
        Deque<String> padawans = new ArrayDeque<>();

        boolean isYodaWatchingBitches = false;

        Deque<String> toshkoSlav = new ArrayDeque<>();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] jedis = reader.readLine().split(" ");

            for (String jedi : jedis) {
                char jediType = jedi.charAt(0);

                switch (jediType){
                    case 'm':
                        masters.add(jedi);
                        break;
                    case 'k':
                        knights.add(jedi);
                        break;
                    case 'p':
                        padawans.add(jedi);
                        break;
                    case 'y':
                        isYodaWatchingBitches = true;
                        break;
                    case 's':
                    case 't':
                        toshkoSlav.add(jedi);
                }
            }
        }

        if (!isYodaWatchingBitches) {
            while (!toshkoSlav.isEmpty()) {
                System.out.print(toshkoSlav.poll() + " ");
            }
            while (!masters.isEmpty()) {
                System.out.print(masters.poll() + " ");
            }
            while (!knights.isEmpty()) {
                System.out.print(knights.poll() + " ");
            }
            while (!padawans.isEmpty()) {
                System.out.print(padawans.poll() + " ");
            }
        } else {
            while (!masters.isEmpty()) {
                System.out.print(masters.poll() + " ");
            }
            while (!knights.isEmpty()) {
                System.out.print(knights.poll() + " ");
            }
            while (!toshkoSlav.isEmpty()) {
                System.out.print(toshkoSlav.poll() + " ");
            }
            while (!padawans.isEmpty()) {
                System.out.print(padawans.poll() + " ");
            }
        }
    }
}
