package mhsoft.permissions.integration;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.UserDao;
import mhsoft.permissions.dto.ClientDto;
import mhsoft.permissions.dto.PermissionDto;
import mhsoft.permissions.dto.RoleDto;
import mhsoft.permissions.dto.UserDto;
import mhsoft.permissions.service.ClientServiceFacade;
import mhsoft.permissions.service.PermissionServiceFacade;
import mhsoft.permissions.service.RolePermissionServiceFacade;
import mhsoft.permissions.service.RoleServiceFacade;
import mhsoft.permissions.service.UserClientRoleServiceFacade;
import mhsoft.permissions.service.UserClientServiceFacade;
import mhsoft.permissions.service.UserServiceFacade;

import org.apache.log4j.Logger;

@Stateless
public class PermissionsDefaultEntriesIntegration {

  private static final Logger LOG = Logger.getLogger(PermissionsDefaultEntriesIntegration.class);

  @EJB
  private UserDao userDao;

  @EJB
  private ClientServiceFacade clientServiceFacade;
  @EJB
  private PermissionServiceFacade permissionServiceFacade;
  @EJB
  private RolePermissionServiceFacade rolePermissionServiceFacade;
  @EJB
  private RoleServiceFacade roleServiceFacade;
  @EJB
  private UserServiceFacade userService;
  @EJB
  private UserClientServiceFacade userClientService;
  @EJB
  private UserClientRoleServiceFacade userClientRoleServiceFacade;

  public void run() {
    if (this.userDao.userExists()) {
      LOG.info("No permissions default entries will be integrated. Reason: a user has been found.");
    } else {
      LOG.info("No user found. Integrating permissions default entries...");
      insertDefaultEntries();
    }
  }

  private void insertDefaultEntries() {
    final PermissionDto adminPermission = this.permissionServiceFacade.createPermission("admin", true, true);
    final RoleDto adminRole = this.roleServiceFacade.createRole("admin", true);
    final ClientDto defaultClient = this.clientServiceFacade.createClient("default", true, true);
    final UserDto adminUser = this.userService.createUser("admin", true);
    this.userClientService.createRelationship(adminUser, defaultClient, true);
    this.userClientRoleServiceFacade.createRelationship(adminUser, defaultClient, adminRole, true);
    this.rolePermissionServiceFacade.createRelationship(adminRole, adminPermission, true, true, true, true, true);
  }

}