package mhsoft.permissions.dao;

import mhsoft.permissions.entity.Client;
import mhsoft.permissions.entity.User;
import mhsoft.permissions.entity.UserClient;

public interface UserClientDao extends Dao<UserClient> {

  public UserClient getByUserAndClient(User user, Client client);

}