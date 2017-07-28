package soft.uni.commands;

import soft.uni.enums.Role;
import soft.uni.models.bindingModels.game.DeleteGame;
import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.Session;

/**
 * Created by Venelin on 28.7.2017 г..
 */
public class DeleteGameCommand extends Command {

    public DeleteGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in";
        }

        if (loggedInUser.getRole() != Role.ADMIN) {
            return "Only admins can edit games";
        }

        Long id = Long.parseLong(params[0]);

        DeleteGame deleteGame = this.getGameService().findById(id, DeleteGame.class);

        if (deleteGame == null) {
            return "Invalid game id";
        }

        super.getGameService().delete(deleteGame);

        return String.format("Deleted %s", deleteGame.getTitle());
    }
}
