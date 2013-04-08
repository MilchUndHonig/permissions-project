package mhsoft.permissions;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.UserDao;
import mhsoft.permissions.entity.User;

@Stateless
public class TestEjb {

  @EJB
  private UserDao userDao;

  public void test() {
    final User user = this.userDao.getByName("admin");
    this.userDao.remove(user);
  }

}