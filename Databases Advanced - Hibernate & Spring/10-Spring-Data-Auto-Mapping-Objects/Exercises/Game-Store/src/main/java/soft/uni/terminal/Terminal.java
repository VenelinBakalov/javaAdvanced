package soft.uni.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import soft.uni.commands.CommandFactory;
import soft.uni.commands.Executable;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public Terminal(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... strings) throws Exception {
        CommandFactory commandFactory = new CommandFactory(this.userService, this.gameService);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();
            if ("end".equalsIgnoreCase(line)) break;

            String[] params = line.split("\\|");
            String command = params[0];
            String[] newParams = new String[params.length - 1];
            if (params.length > 1) {
                newParams = Arrays.copyOfRange(params, 1, params.length);
            }

            Executable executable = commandFactory.getCommand(command);
            String result = executable.execute(newParams);
            System.out.println(result);
        }
    }
}
