package soft.uni.commands;

import soft.uni.enums.Role;
import soft.uni.models.bindingModels.game.AddGame;
import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.DataValidator;
import soft.uni.utils.Session;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class AddGameCommand extends Command {

    public AddGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in";
        }

        if (loggedInUser.getRole() != Role.ADMIN) {
            return "Only admins can add games";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        AddGame addGame = null;
        try {
            addGame = new AddGame(params[0],
                    new BigDecimal(params[1]),
                    Double.parseDouble(params[2]),
                    params[3],
                    params[4],
                    params[5],
                    simpleDateFormat.parse(params[6]));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (! DataValidator.checkIsValid(addGame)) {
            return DataValidator.getInvalidParameterMessage(addGame);
        }

        super.getGameService().persist(addGame);
        return String.format("Added %s", params[0]);
    }
}
