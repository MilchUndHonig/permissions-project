package mhsoft.permissions.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.PermissionDao;
import mhsoft.permissions.dao.RoleDao;
import mhsoft.permissions.dao.RolePermissionDao;
import mhsoft.permissions.dto.PermissionDto;
import mhsoft.permissions.dto.RoleDto;
import mhsoft.permissions.dto.RolePermissionDto;
import mhsoft.permissions.entity.AbstractEntity;
import mhsoft.permissions.entity.Permission;
import mhsoft.permissions.entity.Role;
import mhsoft.permissions.entity.RolePermission;

import org.apache.log4j.Logger;

@Stateless
public class RolePermissionServiceFacade {

  private static final Logger LOG = Logger.getLogger(RolePermissionServiceFacade.class);

  @EJB
  private RoleDao roleDao;
  @EJB
  private PermissionDao permissionDao;
  @EJB
  private RolePermissionDao rolePermissionDao;

  public RolePermissionDto createRelationship(final RoleDto roleDto, final PermissionDto permissionDto, final boolean createPermission, final boolean editPermission,
      final boolean deletePermission, final boolean readPermission) {
    return createRelationship(roleDto, permissionDto, false, AbstractEntity.SYSTEM_USER, createPermission, editPermission, deletePermission, readPermission);
  }

  public RolePermissionDto createRelationship(final RoleDto roleDto, final PermissionDto permissionDto, final boolean locked, final boolean createPermission,
      final boolean editPermission, final boolean deletePermission, final boolean readPermission) {
    return createRelationship(roleDto, permissionDto, locked, AbstractEntity.SYSTEM_USER, createPermission, editPermission, deletePermission, readPermission);
  }

  public RolePermissionDto createRelationship(final RoleDto roleDto, final PermissionDto permissionDto, final String createUser, final boolean createPermission,
      final boolean editPermission, final boolean deletePermission, final boolean readPermission) {
    return createRelationship(roleDto, permissionDto, false, createUser, createPermission, editPermission, deletePermission, readPermission);
  }

  public RolePermissionDto createRelationship(final RoleDto roleDto, final PermissionDto permissionDto, final boolean locked, final String createUser,
      final boolean createPermission, final boolean editPermission, final boolean deletePermission, final boolean readPermission) {
    LOG.info("Creating relation for role: " + roleDto.getName() + " and permission: " + permissionDto.getName());
    final Role role = this.roleDao.getById(roleDto.getId());
    final Permission permission = this.permissionDao.getById(permissionDto.getId());
    final RolePermission rolePermission = new RolePermission();
    rolePermission.setRole(role);
    rolePermission.setPermission(permission);
    rolePermission.setLocked(locked);
    rolePermission.setCreatePermission(createPermission);
    rolePermission.setEditPermission(editPermission);
    rolePermission.setDeletePermission(deletePermission);
    rolePermission.setReadPermission(readPermission);
    rolePermission.setCreateUser(createUser);
    this.rolePermissionDao.persist(rolePermission);
    return new RolePermissionDto(rolePermission.getId(), locked, createPermission, editPermission, deletePermission, readPermission);
  }

}