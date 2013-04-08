package mhsoft.permissions.dao.impl;

import javax.ejb.Stateless;

import mhsoft.permissions.dao.AbstractDao;
import mhsoft.permissions.dao.UserClientRoleDao;
import mhsoft.permissions.entity.UserClientRole;

@Stateless
public class UserClientRoleDaoImpl extends AbstractDao<UserClientRole> implements UserClientRoleDao {

  public UserClientRoleDaoImpl() {
    super(UserClientRole.class);
  }

}