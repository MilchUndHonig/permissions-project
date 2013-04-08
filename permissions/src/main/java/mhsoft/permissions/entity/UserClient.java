package mhsoft.permissions.entity;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity(name = "pms_user_client")
public class UserClient extends AbstractEntity {

  @ManyToOne
  private User user;

  @ManyToOne
  private Client client;

  @OneToMany(mappedBy = "userClient")
  private final Set<UserClientRole> userClientRoles = new HashSet<UserClientRole>();

  @PrePersist
  private void prePersist() {
    setCreateDate(new Date());
  }

  @PreUpdate
  private void preUpdate() {
    setChangeDate(new Date());
  }

  @PreRemove
  private void preRemove() {
    setUser(null);
    setClient(null);
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(final User user) {
    if (this.user != null) {
      this.user.internalRemoveUserClient(this);
    }
    this.user = user;
    if (user != null) {
      user.internalAddUserClient(this);
    }
  }

  public Client getClient() {
    return this.client;
  }

  public void setClient(final Client client) {
    if (this.client != null) {
      this.client.internalRemoveUserClient(this);
    }
    this.client = client;
    if (client != null) {
      client.internalAddUserClient(this);
    }
  }

  public Set<UserClientRole> getUserClientRoles() {
    return Collections.unmodifiableSet(this.userClientRoles);
  }

  public void addUserClientRole(final UserClientRole userClientRole) {
    userClientRole.setUserClient(this);
  }

  public void removeUserClientRole(final UserClientRole userClientRole) {
    userClientRole.setUserClient(null);
  }

  public void internalAddUserClientRole(final UserClientRole userClientRole) {
    this.userClientRoles.add(userClientRole);
  }

  public void internalRemoveUserClientRole(final UserClientRole userClientRole) {
    this.userClientRoles.remove(userClientRole);
  }

}