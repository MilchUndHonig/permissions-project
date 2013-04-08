package mhsoft.permissions.dao.impl;

import javax.ejb.Stateless;

import mhsoft.permissions.dao.AbstractDao;
import mhsoft.permissions.dao.UserDao;
import mhsoft.permissions.entity.User;
import mhsoft.permissions.entity.metamodel.QUser;

import com.mysema.query.jpa.impl.JPAQuery;

@Stateless
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

  public UserDaoImpl() {
    super(User.class);
  }

  @Override
  public User getByName(final String name) {
    return new JPAQuery(this.entityManager).from(QUser.user).where(QUser.user.name.eq(name)).uniqueResult(QUser.user);
  }

  @Override
  public boolean userExists() {
    return !new JPAQuery(this.entityManager).from(QUser.user).limit(1).list(QUser.user).isEmpty();
  }

}