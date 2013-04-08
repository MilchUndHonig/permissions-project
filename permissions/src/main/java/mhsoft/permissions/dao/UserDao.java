package mhsoft.permissions.dao;

import mhsoft.permissions.entity.User;

public interface UserDao extends Dao<User> {

  public User getByName(String name);

  public boolean userExists();

}