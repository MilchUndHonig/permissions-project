package mhsoft.permissions.dao.impl;

import javax.ejb.Stateless;

import mhsoft.permissions.dao.AbstractDao;
import mhsoft.permissions.dao.PermissionDao;
import mhsoft.permissions.entity.Permission;

@Stateless
public class PermissionDaoImpl extends AbstractDao<Permission> implements PermissionDao {

  public PermissionDaoImpl() {
    super(Permission.class);
  }

}