package soft.uni.commands;

import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.models.viewModels.game.OwnedGameView;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.Session;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 28.7.2017 г..
 */
public class OwnedGamesCommand extends Command {

    public OwnedGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        LoggedInUser loggedInUser = Session.getLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in";
        }

        List<OwnedGameView> ownedGames = super.getGameService().findOwnedByUser(loggedInUser.getId());
        return ownedGames.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }
}
