package soft.uni.commands;

import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.Session;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class LoginCommand extends Command {

    public LoginCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        String username = params[0];
        String password = params[1];

        if (Session.getLoggedInUser() != null) {
            return "User already logged in";
        }

        LoggedInUser loggedInUser = super.getUserService().findByEmailAndPassword(username, password);
        if (loggedInUser == null) {
            return "Incorrect email / password";
        }

        Session.setLoggedInUser(loggedInUser);
        return String.format("Successfully logged in %s", loggedInUser.getFullName());
    }
}
