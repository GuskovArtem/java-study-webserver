package accounts;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Guskov Artem
 *         on 08.01.2016.
 */
public class AccountService {
    private final Map<String, UserProfile> loginToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

}
