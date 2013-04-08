package mhsoft.permissions.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity(name = "pms_user_client_role")
public class UserClientRole extends AbstractEntity {

  @ManyToOne
  @JoinColumn(name = "user_client_id")
  private UserClient userClient;

  @ManyToOne
  private Role role;

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
    setUserClient(null);
    setRole(null);
  }

  public UserClient getUserClient() {
    return this.userClient;
  }

  public void setUserClient(final UserClient userClient) {
    if (this.userClient != null) {
      this.userClient.internalRemoveUserClientRole(this);
    }
    this.userClient = userClient;
    if (userClient != null) {
      userClient.internalAddUserClientRole(this);
    }
  }

  public Role getRole() {
    return this.role;
  }

  public void setRole(final Role role) {
    if (this.role != null) {
      this.role.internalRemoveUserClientRole(this);
    }
    this.role = role;
    if (role != null) {
      role.internalAddUserClientRole(this);
    }
  }

}