package soft.uni.utils;

import soft.uni.models.bindingModels.user.LoggedInUser;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public class Session {

    private static LoggedInUser loggedInUser;

    public static LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(LoggedInUser loggedInUser) {
        Session.loggedInUser = loggedInUser;
    }
}
