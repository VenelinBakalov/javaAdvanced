package soft.uni.commands;

import soft.uni.models.bindingModels.user.RegisterUser;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.DataValidator;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class RegisterCommand extends Command {

    public RegisterCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        RegisterUser registerUser = new RegisterUser();

        registerUser.setEmail(params[0]);
        registerUser.setPassword(params[1]);
        registerUser.setConfirmPassword(params[2]);
        registerUser.setFullName(params[3]);

        if (!DataValidator.checkIsValid(registerUser)) {
            return DataValidator.getInvalidParameterMessage(registerUser);
        }

        try {
            super.getUserService().persist(registerUser);
        } catch (Exception e) {
            return e.getMessage();
        }


        return String.format("%s was registered", params[3]);
    }
}
