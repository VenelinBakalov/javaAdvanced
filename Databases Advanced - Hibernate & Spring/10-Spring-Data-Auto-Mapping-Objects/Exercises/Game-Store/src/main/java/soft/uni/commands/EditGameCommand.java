package soft.uni.commands;

import soft.uni.enums.Role;
import soft.uni.models.bindingModels.game.EditGame;
import soft.uni.models.bindingModels.user.LoggedInUser;
import soft.uni.services.api.GameService;
import soft.uni.services.api.UserService;
import soft.uni.utils.DataValidator;
import soft.uni.utils.Session;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 28.7.2017 г..
 */
public class EditGameCommand extends Command {

    private final Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
        put(boolean.class, Boolean.class);
    }};

    public EditGameCommand(UserService userService, GameService gameService) {
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

        EditGame editGame = this.getGameService().findById(id, EditGame.class);
        if (editGame == null) {
            return "Invalid game id";
        }

        for (int i = 1; i < params.length; i++) {
            String[] paramArgs = params[i].split("=");
            String fieldName = paramArgs[0];
            String value = paramArgs[1];

            try {
                Field field = editGame.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                fieldType = fieldType.isPrimitive() ?
                        this.mapper.get(fieldType) :
                        fieldType;

                Constructor<?> fieldConstructor = fieldType.getConstructor(String.class);
                field.set(editGame, fieldConstructor.newInstance(value));
            } catch (NoSuchFieldException e) {
                return e.getMessage();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }

        if (!DataValidator.checkIsValid(editGame)) {
            return DataValidator.getInvalidParameterMessage(editGame);
        }

        super.getGameService().persist(editGame);
        return String.format("Edited %s", editGame.getTitle());
    }
}
