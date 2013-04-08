package mhsoft.permissions.dao.impl;

import javax.ejb.Stateless;

import mhsoft.permissions.dao.AbstractDao;
import mhsoft.permissions.dao.UserClientDao;
import mhsoft.permissions.entity.Client;
import mhsoft.permissions.entity.User;
import mhsoft.permissions.entity.UserClient;
import mhsoft.permissions.entity.metamodel.QUserClient;

import com.mysema.query.jpa.impl.JPAQuery;

@Stateless
public class UserClientDaoImpl extends AbstractDao<UserClient> implements UserClientDao {

  public UserClientDaoImpl() {
    super(UserClient.class);
  }

  @Override
  public UserClient getByUserAndClient(final User user, final Client client) {
    return new JPAQuery(this.entityManager).from(QUserClient.userClient).where(QUserClient.userClient.user.eq(user).and(QUserClient.userClient.client.eq(client)))
        .uniqueResult(QUserClient.userClient);
  }

}