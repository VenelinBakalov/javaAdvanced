package soft.uni.commands;

import soft.uni.models.bindingModels.user.BuyingUser;
import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.Session;

public class BuyGamesCommand extends Command {

    public BuyGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in";
        }

        BuyingUser buyingUser = super.getUserService().findById(loggedInUser.getId(), BuyingUser.class);

        String result = buyingUser.buyGames();

        super.getUserService().persist(buyingUser);

        return result;
    }
}
