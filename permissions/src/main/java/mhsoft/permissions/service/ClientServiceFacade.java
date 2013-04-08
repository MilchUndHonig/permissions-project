package mhsoft.permissions.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mhsoft.permissions.dao.ClientDao;
import mhsoft.permissions.dto.ClientDto;
import mhsoft.permissions.entity.AbstractEntity;
import mhsoft.permissions.entity.Client;

import org.apache.log4j.Logger;

@Stateless
public class ClientServiceFacade {

  private static final Logger LOG = Logger.getLogger(ClientServiceFacade.class);

  @EJB
  private ClientDao clientDao;

  public ClientDto createClient(final String name) {
    return createClient(name, false, AbstractEntity.SYSTEM_USER, false);
  }

  public ClientDto createClient(final String name, final boolean locked) {
    return createClient(name, locked, AbstractEntity.SYSTEM_USER, false);
  }

  public ClientDto createClient(final String name, final boolean locked, final boolean defaultClient) {
    return createClient(name, locked, AbstractEntity.SYSTEM_USER, defaultClient);
  }

  public ClientDto createClient(final String name, final String createUser) {
    return createClient(name, false, createUser, false);
  }

  public ClientDto createClient(final String name, final String createUser, final boolean defaultClient) {
    return createClient(name, false, createUser, defaultClient);
  }

  public ClientDto createClient(final String name, final boolean locked, final String createUser, final boolean defaultClient) {
    LOG.info("Creating client with name: " + name);
    final Client client = new Client();
    client.setName("default");
    client.setLocked(locked);
    client.setDefaultClient(defaultClient);
    client.setCreateUser(createUser);
    this.clientDao.persist(client);
    return new ClientDto(client.getId(), name, locked, defaultClient);
  }

}