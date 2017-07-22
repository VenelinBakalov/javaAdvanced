package softuni.users.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.users.entities.User;
import softuni.users.services.api.UserService;

/**
 * Created by Venelin on 22.7.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public Terminal(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("Vader");
        user.setPassword("paS123?");
        user.setEmail("vader@abv.bg");

        userService.persist(user);
    }
}
