package mhsoft.permissions.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.RoleDao;
import mhsoft.permissions.dto.RoleDto;
import mhsoft.permissions.entity.AbstractEntity;
import mhsoft.permissions.entity.Role;

import org.apache.log4j.Logger;

@Stateless
public class RoleServiceFacade {

  private static final Logger LOG = Logger.getLogger(RoleServiceFacade.class);

  @EJB
  private RoleDao roleDao;

  public RoleDto createRole(final String name) {
    return createRole(name, false, AbstractEntity.SYSTEM_USER);
  }

  public RoleDto createRole(final String name, final boolean locked) {
    return createRole(name, locked, AbstractEntity.SYSTEM_USER);
  }

  public RoleDto createRole(final String name, final String createUser) {
    return createRole(name, false, createUser);
  }

  public RoleDto createRole(final String name, final boolean locked, final String createUser) {
    LOG.info("Creating role with name: " + name);
    final Role role = new Role();
    role.setName(name);
    role.setLocked(locked);
    role.setCreateUser(createUser);
    this.roleDao.persist(role);
    return new RoleDto(role.getId(), name, locked);
  }

}