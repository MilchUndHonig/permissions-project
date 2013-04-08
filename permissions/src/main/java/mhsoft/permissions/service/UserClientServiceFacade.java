package mhsoft.permissions.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.ClientDao;
import mhsoft.permissions.dao.UserClientDao;
import mhsoft.permissions.dao.UserDao;
import mhsoft.permissions.dto.ClientDto;
import mhsoft.permissions.dto.UserClientDto;
import mhsoft.permissions.dto.UserDto;
import mhsoft.permissions.entity.AbstractEntity;
import mhsoft.permissions.entity.Client;
import mhsoft.permissions.entity.User;
import mhsoft.permissions.entity.UserClient;

import org.apache.log4j.Logger;

@Stateless
public class UserClientServiceFacade {

  private static final Logger LOG = Logger.getLogger(UserClientServiceFacade.class);

  @EJB
  private UserDao userDao;
  @EJB
  private ClientDao clientDao;
  @EJB
  private UserClientDao userClientDao;

  public UserClientDto createRelationship(final UserDto userDto, final ClientDto clientDto) {
    return createRelationship(userDto, clientDto, false, AbstractEntity.SYSTEM_USER);
  }

  public UserClientDto createRelationship(final UserDto userDto, final ClientDto clientDto, final boolean locked) {
    return createRelationship(userDto, clientDto, locked, AbstractEntity.SYSTEM_USER);
  }

  public UserClientDto createRelationship(final UserDto userDto, final ClientDto clientDto, final String createUser) {
    return createRelationship(userDto, clientDto, false, createUser);
  }

  public UserClientDto createRelationship(final UserDto userDto, final ClientDto clientDto, final boolean locked, final String createUser) {
    LOG.info("Creating relation for user: " + userDto.getName() + " and client: " + clientDto.getName());
    final User user = this.userDao.getById(userDto.getId());
    final Client client = this.clientDao.getById(clientDto.getId());
    final UserClient userClient = new UserClient();
    userClient.setUser(user);
    userClient.setClient(client);
    userClient.setLocked(locked);
    userClient.setCreateUser(createUser);
    this.userClientDao.persist(userClient);
    return new UserClientDto(userClient.getId(), userClient.getLocked());
  }

}