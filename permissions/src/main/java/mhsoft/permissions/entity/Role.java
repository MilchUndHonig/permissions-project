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

@Entity(name = "pms_role")
public class Role extends AbstractEntity {

  @Column(unique = true, nullable = false)
  private String name;

  @OneToMany(mappedBy = "role")
  private final Set<UserClientRole> userClientRoles = new HashSet<UserClientRole>();

  @OneToMany(mappedBy = "role")
  private final Set<RolePermission> rolePermissions = new HashSet<RolePermission>();

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

  public Set<UserClientRole> getUserClientRoles() {
    return Collections.unmodifiableSet(this.userClientRoles);
  }

  public void addUserClientRole(final UserClientRole userClientRole) {
    userClientRole.setRole(this);
  }

  public void removeUserClientRole(final UserClientRole userClientRole) {
    userClientRole.setRole(null);
  }

  public void internalAddUserClientRole(final UserClientRole userClientRole) {
    this.userClientRoles.add(userClientRole);
  }

  public void internalRemoveUserClientRole(final UserClientRole userClientRole) {
    this.userClientRoles.remove(userClientRole);
  }

  public Set<RolePermission> getRolePermissions() {
    return Collections.unmodifiableSet(this.rolePermissions);
  }

  public void addRolePermission(final RolePermission rolePermission) {
    rolePermission.setRole(this);
  }

  public void removeRolePermission(final RolePermission rolePermission) {
    rolePermission.setRole(null);
  }

  public void internalAddRolePermission(final RolePermission rolePermission) {
    this.rolePermissions.add(rolePermission);
  }

  public void internalRemoveRolePermission(final RolePermission rolePermission) {
    this.rolePermissions.remove(rolePermission);
  }

}