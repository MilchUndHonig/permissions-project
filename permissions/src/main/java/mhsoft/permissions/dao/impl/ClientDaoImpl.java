package mhsoft.permissions.dao.impl;

import javax.ejb.Stateless;

import mhsoft.permissions.dao.AbstractDao;
import mhsoft.permissions.dao.ClientDao;
import mhsoft.permissions.entity.Client;

@Stateless
public class ClientDaoImpl extends AbstractDao<Client> implements ClientDao {

  public ClientDaoImpl() {
    super(Client.class);
  }

}