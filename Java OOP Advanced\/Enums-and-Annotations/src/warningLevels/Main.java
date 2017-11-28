package warningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String loggerLevel = reader.readLine();
        Logger logger = new Logger(Importance.valueOf(loggerLevel));
        String command;

        while (!"END".equals(command = reader.readLine())) {
            int colonIndex = command.indexOf(":");
            String messageLevel = command.substring(0, colonIndex);
            String content = command.substring(colonIndex + 2);

            logger.record(new Message(Importance.valueOf(messageLevel), content));
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
