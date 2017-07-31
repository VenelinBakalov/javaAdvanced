package soft.uni.commands;

import soft.uni.models.bindingModels.game.ShoppingCartGame;
import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.models.bindingModels.user.ShoppingCartUser;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.Session;

public class RemoveFromShoppingCartCommand extends Command {

    public RemoveFromShoppingCartCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        LoggedInUser loggedInUser = Session.getLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in";
        }

        String gameTitle = params[0];

        ShoppingCartGame shoppingCartGame = super.getGameService().findByTitle(gameTitle, ShoppingCartGame.class);
        if (shoppingCartGame == null) {
            return String.format("No game exists in the database with title: %s", gameTitle);
        }

        ShoppingCartUser shoppingCartUser = super.getUserService().findById(loggedInUser.getId(), ShoppingCartUser.class);

        String result = shoppingCartUser.removeGame(shoppingCartGame);

        super.getUserService().persist(shoppingCartUser);

        return result;
    }
}
