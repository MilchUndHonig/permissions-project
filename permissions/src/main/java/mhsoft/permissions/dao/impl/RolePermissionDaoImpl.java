package mhsoft.permissions.dao.impl;

import javax.ejb.Stateless;

import mhsoft.permissions.dao.AbstractDao;
import mhsoft.permissions.dao.RolePermissionDao;
import mhsoft.permissions.entity.RolePermission;

@Stateless
public class RolePermissionDaoImpl extends AbstractDao<RolePermission> implements RolePermissionDao {

  public RolePermissionDaoImpl() {
    super(RolePermission.class);
  }

}