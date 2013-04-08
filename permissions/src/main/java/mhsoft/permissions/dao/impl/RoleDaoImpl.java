package mhsoft.permissions.dao.impl;

import javax.ejb.Stateless;

import mhsoft.permissions.dao.AbstractDao;
import mhsoft.permissions.dao.RoleDao;
import mhsoft.permissions.entity.Role;

@Stateless
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

  public RoleDaoImpl() {
    super(Role.class);
  }

}