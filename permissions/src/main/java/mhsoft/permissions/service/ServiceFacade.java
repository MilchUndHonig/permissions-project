package mhsoft.permissions.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dto.ClientDto;
import mhsoft.permissions.dto.PermissionDto;
import mhsoft.permissions.dto.RoleDto;
import mhsoft.permissions.dto.RolePermissionDto;
import mhsoft.permissions.dto.UserClientDto;
import mhsoft.permissions.dto.UserClientRoleDto;
import mhsoft.permissions.dto.UserDto;

@Stateless
public class ServiceFacade {

  @EJB
  private ClientServiceFacade clientServiceFacade;
  @EJB
  private PermissionServiceFacade permissionServiceFacade;
  @EJB
  private RolePermissionServiceFacade rolePermissionServiceFacade;
  @EJB
  private RoleServiceFacade roleServiceFacade;
  @EJB
  private UserServiceFacade userServiceFacade;
  @EJB
  private UserClientServiceFacade userClientServiceFacade;
  @EJB
  private UserClientRoleServiceFacade userClientRoleServiceFacade;

  public ClientDto createClient(final String name, final String createUser) {
    return this.clientServiceFacade.createClient(name, createUser);
  }

  public PermissionDto createPermission(final String name, final String createUser) {
    return this.permissionServiceFacade.createPermission(name, createUser);
  }

  public RolePermissionDto createRolePermission(final RoleDto roleDto, final PermissionDto permissionDto, final String createUser, final boolean createPermission,
      final boolean editPermission, final boolean deletePermission, final boolean readPermission) {
    return this.rolePermissionServiceFacade.createRelationship(roleDto, permissionDto, createUser, createPermission, editPermission, deletePermission, readPermission);
  }

  public RoleDto createRole(final String name, final String createUser) {
    return this.roleServiceFacade.createRole(name, createUser);
  }

  public UserDto createUser(final String name, final String createUser) {
    return this.userServiceFacade.createUser(name, createUser);
  }

  public UserClientDto createUserClient(final UserDto userDto, final ClientDto clientDto, final String createUser) {
    return this.userClientServiceFacade.createRelationship(userDto, clientDto, createUser);
  }

  public UserClientRoleDto createUserClientRole(final UserDto userDto, final ClientDto clientDto, final RoleDto roleDto, final String name, final String createUser) {
    return this.userClientRoleServiceFacade.createRelationship(userDto, clientDto, roleDto, createUser);
  }

}