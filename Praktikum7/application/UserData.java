package application;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private static final Map<String, String> users = new HashMap<>();

    static{
        users.put("raihan", "rai123");
        users.put("aufa", "aufa123");
        users.put("naufal", "naufal123");
        users.put("ibnu", "ibnu123");
    }
    
    public static boolean validateUser(String username, String password){
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
