package zerodha_buyandsell;

import java.util.HashMap;

public class UserSystem {
    private static UserSystem instance;
    HashMap<String,User> userData;
    private UserSystem() {
        userData = new HashMap<>();
    }
    public static UserSystem getInstance() {
        if (instance == null) {
            synchronized (UserSystem.class) {
                if (instance == null) {
                    instance = new UserSystem();
                }
            }
        }
        return instance;
    }

    public User getUser(String userName) {
        return userData.get(userName);
    }

    public void addUser(String userName, User user) {
        userData.put(userName, user);
    }
}
