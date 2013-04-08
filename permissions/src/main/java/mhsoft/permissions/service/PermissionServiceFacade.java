package mhsoft.permissions.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.PermissionDao;
import mhsoft.permissions.dto.PermissionDto;
import mhsoft.permissions.entity.AbstractEntity;
import mhsoft.permissions.entity.Permission;

import org.apache.log4j.Logger;

@Stateless
public class PermissionServiceFacade {

  private static final Logger LOG = Logger.getLogger(PermissionServiceFacade.class);

  @EJB
  private PermissionDao permissionDao;

  public PermissionDto createPermission(final String name) {
    return createPermission(name, false, AbstractEntity.SYSTEM_USER, false);
  }

  public PermissionDto createPermission(final String name, final boolean locked) {
    return createPermission(name, locked, AbstractEntity.SYSTEM_USER, false);
  }

  public PermissionDto createPermission(final String name, final boolean locked, final boolean admin) {
    return createPermission(name, locked, AbstractEntity.SYSTEM_USER, admin);
  }

  public PermissionDto createPermission(final String name, final String createUser) {
    return createPermission(name, false, createUser, false);
  }

  public PermissionDto createPermission(final String name, final boolean locked, final String createUser) {
    return createPermission(name, locked, createUser, false);
  }

  public PermissionDto createPermission(final String name, final String createUser, final boolean admin) {
    return createPermission(name, false, createUser, admin);
  }

  public PermissionDto createPermission(final String name, final boolean locked, final String createUser, final boolean admin) {
    LOG.info("Creating permission with name: " + name);
    final Permission permission = new Permission();
    permission.setName(name);
    permission.setAdmin(admin);
    permission.setLocked(locked);
    permission.setCreateUser(createUser);
    this.permissionDao.persist(permission);
    return new PermissionDto(permission.getId(), name, locked, admin);
  }

}