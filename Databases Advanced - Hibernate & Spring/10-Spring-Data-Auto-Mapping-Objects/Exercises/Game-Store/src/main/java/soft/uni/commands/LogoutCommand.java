package soft.uni.commands;

import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.Session;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class LogoutCommand extends Command {

    public LogoutCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if (Session.getLoggedInUser() == null) {
            return "Cannot log out. No user was logged in.";
        }

        LoggedInUser loggedInUser = Session.getLoggedInUser();
        Session.setLoggedInUser(null);

        return String.format("User %s successfully logged out", loggedInUser.getFullName());
    }
}
