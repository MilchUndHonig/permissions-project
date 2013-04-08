package mhsoft.permissions.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.UserDao;
import mhsoft.permissions.dto.UserDto;
import mhsoft.permissions.entity.AbstractEntity;
import mhsoft.permissions.entity.User;

import org.apache.log4j.Logger;

@Stateless
public class UserServiceFacade {

  private static final Logger LOG = Logger.getLogger(UserServiceFacade.class);

  @EJB
  private UserDao userDao;

  public UserDto createUser(final String name, final boolean locked) {
    return createUser(name, locked, AbstractEntity.SYSTEM_USER);
  }

  public UserDto createUser(final String name, final String createUser) {
    return createUser(name, false, createUser);
  }

  public UserDto createUser(final String name, final boolean locked, final String createUser) {
    LOG.info("Creating user with name: " + name);
    final User user = new User();
    user.setName(name);
    user.setLocked(locked);
    user.setCreateUser(createUser);
    this.userDao.persist(user);
    return new UserDto(user.getId(), name, locked);
  }

}