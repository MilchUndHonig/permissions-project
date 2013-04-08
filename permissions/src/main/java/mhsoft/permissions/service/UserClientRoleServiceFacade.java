package mhsoft.permissions.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.ClientDao;
import mhsoft.permissions.dao.RoleDao;
import mhsoft.permissions.dao.UserClientDao;
import mhsoft.permissions.dao.UserClientRoleDao;
import mhsoft.permissions.dao.UserDao;
import mhsoft.permissions.dto.ClientDto;
import mhsoft.permissions.dto.RoleDto;
import mhsoft.permissions.dto.UserClientRoleDto;
import mhsoft.permissions.dto.UserDto;
import mhsoft.permissions.entity.AbstractEntity;
import mhsoft.permissions.entity.Client;
import mhsoft.permissions.entity.Role;
import mhsoft.permissions.entity.User;
import mhsoft.permissions.entity.UserClient;
import mhsoft.permissions.entity.UserClientRole;

import org.apache.log4j.Logger;

@Stateless
public class UserClientRoleServiceFacade {

  private static final Logger LOG = Logger.getLogger(UserClientRoleServiceFacade.class);

  @EJB
  private UserDao userDao;
  @EJB
  private ClientDao clientDao;
  @EJB
  private RoleDao roleDao;
  @EJB
  private UserClientDao userClientDao;
  @EJB
  private UserClientRoleDao userClientRoleDao;

  public UserClientRoleDto createRelationship(final UserDto userDto, final ClientDto clientDto, final RoleDto roleDto) {
    return createRelationship(userDto, clientDto, roleDto, false, AbstractEntity.SYSTEM_USER);
  }

  public UserClientRoleDto createRelationship(final UserDto userDto, final ClientDto clientDto, final RoleDto roleDto, final boolean locked) {
    return createRelationship(userDto, clientDto, roleDto, locked, AbstractEntity.SYSTEM_USER);
  }

  public UserClientRoleDto createRelationship(final UserDto userDto, final ClientDto clientDto, final RoleDto roleDto, final String createUser) {
    return createRelationship(userDto, clientDto, roleDto, false, createUser);
  }

  public UserClientRoleDto createRelationship(final UserDto userDto, final ClientDto clientDto, final RoleDto roleDto, final boolean locked, final String createUser) {
    LOG.info("Creating relation for user: " + userDto.getName() + ", client: " + clientDto.getName() + " and role: " + roleDto.getName());
    final User user = this.userDao.getById(userDto.getId());
    final Client client = this.clientDao.getById(clientDto.getId());
    final Role role = this.roleDao.getById(roleDto.getId());
    final UserClient userClient = this.userClientDao.getByUserAndClient(user, client);
    final UserClientRole userClientRole = new UserClientRole();
    userClientRole.setRole(role);
    userClientRole.setUserClient(userClient);
    userClientRole.setLocked(locked);
    userClientRole.setCreateUser(createUser);
    this.userClientRoleDao.persist(userClientRole);
    return new UserClientRoleDto(userClientRole.getId(), userClientRole.getLocked());
  }

}