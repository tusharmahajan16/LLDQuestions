package swiggy_zomato_design;

import java.util.HashMap;

public class UserMgr {
    private static UserMgr instance;
    HashMap<String, User> userMap;

    private UserMgr() {
        userMap = new HashMap<>();
    }

    public static UserMgr getInstance() {
        if (instance == null) {
            synchronized (UserMgr.class) {
                if (instance == null) {
                    instance = new UserMgr();
                }
            }
        }
        return instance;
    }

    public void addUser(String userName, User user) {
        userMap.put(userName, user);
    }

    public User getUser(String userName) {
        return userMap.get(userName);
    }
}
