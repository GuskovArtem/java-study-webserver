package accounts;

import dbservice.DbService;
import entity.UserEntity;

/**
 * @author Guskov Artem
 *         on 08.01.2016.
 */
public class AccountService {

  private DbService dbService = new DbService();


  public void addNewUser(UserProfile userProfile) {
    dbService.addUser(userProfile.getLogin(), userProfile.getPass());
  }

  public UserProfile getUserByLogin(String login) {
    UserEntity userEntity = dbService.getUser(login);
    return new UserProfile(userEntity.getName(), userEntity.getPassword());
  }

}
