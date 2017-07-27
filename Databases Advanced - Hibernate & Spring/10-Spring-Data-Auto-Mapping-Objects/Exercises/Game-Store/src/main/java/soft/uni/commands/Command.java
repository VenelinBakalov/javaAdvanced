package soft.uni.commands;

import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public abstract class Command implements Executable {

    private final UserService userService;
    private final GameService gameService;

    protected Command(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    protected UserService getUserService() {
        return userService;
    }

    protected GameService getGameService() {
        return gameService;
    }
}
