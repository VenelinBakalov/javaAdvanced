package soft.uni.commands;

import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.models.viewModels.game.GameDetailsView;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.Session;

/**
 * Created by Venelin on 28.7.2017 г..
 */
public class GameDetailsCommand extends Command {

    public GameDetailsCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in";
        }

        String title = params[0];
        GameDetailsView gameDetailsView = super.getGameService().findByTitle(title, GameDetailsView.class);

        if (gameDetailsView == null) {
            return String.format("No game exists in the database with title: %s", title);
        }

        return gameDetailsView.toString();
    }
}
