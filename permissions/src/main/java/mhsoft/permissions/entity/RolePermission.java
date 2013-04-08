package mhsoft.permissions.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity(name = "pms_role_permission")
public class RolePermission extends AbstractEntity {

  @Column(name = "create_permission", nullable = false)
  private Boolean createPermission = false;
  @Column(name = "edit_permission", nullable = false)
  private Boolean editPermission = false;
  @Column(name = "delete_permission", nullable = false)
  private Boolean deletePermission = false;
  @Column(name = "read_permission", nullable = false)
  private Boolean readPermission = false;

  @ManyToOne
  private Role role;

  @ManyToOne
  private Permission permission;

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
    setRole(null);
    setPermission(null);
  }

  public Boolean getCreatePermission() {
    return this.createPermission;
  }

  public void setCreatePermission(final Boolean createPermission) {
    this.createPermission = createPermission;
  }

  public Boolean getEditPermission() {
    return this.editPermission;
  }

  public void setEditPermission(final Boolean editPermission) {
    this.editPermission = editPermission;
  }

  public Boolean getDeletePermission() {
    return this.deletePermission;
  }

  public void setDeletePermission(final Boolean deletePermission) {
    this.deletePermission = deletePermission;
  }

  public Boolean getReadPermission() {
    return this.readPermission;
  }

  public void setReadPermission(final Boolean readPermission) {
    this.readPermission = readPermission;
  }

  public Role getRole() {
    return this.role;
  }

  public void setRole(final Role role) {
    if (this.role != null) {
      this.role.internalRemoveRolePermission(this);
    }
    this.role = role;
    if (role != null) {
      role.internalAddRolePermission(this);
    }
  }

  public Permission getPermission() {
    return this.permission;
  }

  public void setPermission(final Permission permission) {
    if (this.permission != null) {
      this.permission.internalRemoveRolePermission(this);
    }
    this.permission = permission;
    if (permission != null) {
      permission.internalAddRolePermission(this);
    }
  }

}