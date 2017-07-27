package soft.uni.commands;

import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class CommandFactory {

    private static final String COMMAND_SUFFIX = "Command";

    private final UserService userService;
    private final GameService gameService;

    public CommandFactory(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @SuppressWarnings("unchecked")
    public Executable getCommand(String command) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        String commandQualifiedName = Command.class.getName();
        String simpleName = Command.class.getSimpleName();
        commandQualifiedName = commandQualifiedName.replace("." + simpleName, "." + command + COMMAND_SUFFIX);

        Class<Executable> commandClass = (Class<Executable>) Class.forName(commandQualifiedName);
        Constructor<Executable> declaredConstructor = commandClass.getDeclaredConstructor(UserService.class, GameService.class);

        return declaredConstructor.newInstance(userService, gameService);
    }
}
