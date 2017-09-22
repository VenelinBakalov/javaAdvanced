package mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dani on 16.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] charArgs = reader.readLine().split(" \\| ");
        String characterType = charArgs[1];
        GameObject gameObject = null;

        switch (characterType) {
            case "Demon":
                gameObject = new Demon(charArgs[0], Integer.parseInt(charArgs[3]), Double.parseDouble(charArgs[2]));
                break;
            case "Archangel":
                gameObject = new Archangel(charArgs[0], Integer.parseInt(charArgs[3]), Integer.parseInt(charArgs[2]));
                break;
        }
        System.out.println(gameObject);
    }
}
