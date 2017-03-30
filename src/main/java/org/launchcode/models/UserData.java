package org.launchcode.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 3/27/17.
 */
public class UserData {

    private static List<User> users = new ArrayList<>();

    public static List<User> getUsers() { return users; }

    public static void addUser(User user) {
        users.add(user);
    }
}
