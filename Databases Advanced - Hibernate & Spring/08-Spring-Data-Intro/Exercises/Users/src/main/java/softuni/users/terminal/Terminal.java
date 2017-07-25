package softuni.users.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.users.entities.User;
import softuni.users.services.impl.UserServiceImpl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 22.7.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {

    private final UserServiceImpl userService;

    @Autowired
    public Terminal(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {

//        seedDatabase();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Problem 16.	Get Users by Email Provider
//        String emailProvider = reader.readLine();
//        List<Object[]> usernamesByEmailProvider = this.userService.findUsersByEmailProvider(emailProvider);
//        if (usernamesByEmailProvider.isEmpty()) {
//            System.out.println("No users found with email domain " + emailProvider);
//        } else {
//            usernamesByEmailProvider.forEach(u -> {
//                System.out.println(u[0] + " " + u[1]);
//            });
//        }

        // Problem 17.	Count Users with Bigger Pictures
//        Integer width = Integer.parseInt(reader.readLine());
//        Integer usersCount = this.userService.countByProfilePictureGreaterThan(new byte[width]);
//        if (usersCount == 0) {
//            System.out.println("No users have profile picture wider than " + width + " pixels");
//        } else {
//            System.out.printf("%d user%s profile pictures wider than %d pixels\n",
//                    usersCount,
//                    usersCount == 1 ? " has" : "s have",
//                    width);

        // ALTERNATIVE solution with BufferedImage width!!! I suppose this is more correct but it doesn't read all image formats
        Integer width = Integer.parseInt(reader.readLine());
        List<User> users = userService.findAll().stream()
                .filter(u -> {
                    if (u.getProfilePicture() == null) {
                        return false;
                    }

                    // convert byte array to BufferedImage
                    InputStream inputStream = new ByteArrayInputStream(u.getProfilePicture());
                    try {
                        BufferedImage bufferedImage = ImageIO.read(inputStream);
                        int imageWidth = bufferedImage.getWidth();

                        if (imageWidth > width) {
                            return true;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return false;
                }).collect(Collectors.toList());

        int usersCount = users.size();

        if (usersCount == 0) {
            System.out.println("No users have profile picture wider than " + width + " pixels");
        } else {
            System.out.printf("%d user%s profile pictures wider than %d pixels\n",
                    usersCount,
                    usersCount == 1 ? " has" : "s have",
                    width);
        }

        // Problem 18.	Remove Inactive Users
//        String dateStr = reader.readLine();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = sdf.parse(dateStr);
//        Integer usersDeleted = this.userService.prepareInactiveUsersForRemoval(date);
//        if (usersDeleted == 0) {
//            System.out.println("No users have been deleted");
//        } else {
//            System.out.printf("%d user%s been deleted\n",
//                    usersDeleted,
//                    usersDeleted == 1 ? " has" : "s have");
//
//            this.userService.deleteInactiveUsers();
//        }
    }

    private void seedDatabase() {
        User user = new User();
        user.setUsername("Vader");
        user.setPassword("paS123?");
        user.setEmail("vader@abv.bg");

        userService.persist(user);

        User user2 = new User();
        user2.setUsername("Ivan");
        user2.setPassword("paS123?121s");
        user2.setEmail("vankata@abv.bg");

        userService.persist(user2);

        User user3 = new User();
        user3.setUsername("LardaX");
        user3.setPassword("extrapaS123?");
        user3.setEmail("lardax@gmail.com");

        userService.persist(user3);

        User user4 = new User();
        user4.setUsername("Pokemon");
        user4.setPassword("passS123?");
        user4.setEmail("pokemon@poke.bg");

        userService.persist(user4);
    }
}
