package mhsoft.permissions.entity;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity(name = "pms_client")
public class Client extends AbstractEntity {

  @Column(unique = true, nullable = false)
  private String name;
  @Column(name = "default_client", nullable = false)
  private Boolean defaultClient = false;

  @OneToMany(mappedBy = "client")
  private final Set<UserClient> userClients = new HashSet<UserClient>();

  @PrePersist
  private void prePersist() {
    setCreateDate(new Date());
  }

  @PreUpdate
  private void preUpdate() {
    setChangeDate(new Date());
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Boolean getDefaultClient() {
    return this.defaultClient;
  }

  public void setDefaultClient(final Boolean defaultClient) {
    this.defaultClient = defaultClient;
  }

  public Set<UserClient> getUserClients() {
    return Collections.unmodifiableSet(this.userClients);
  }

  public void addUserClient(final UserClient userClient) {
    userClient.setClient(this);
  }

  public void removeUserClient(final UserClient userClient) {
    userClient.setClient(null);
  }

  public void internalAddUserClient(final UserClient userClient) {
    this.userClients.add(userClient);
  }

  public void internalRemoveUserClient(final UserClient userClient) {
    this.userClients.remove(userClient);
  }

}