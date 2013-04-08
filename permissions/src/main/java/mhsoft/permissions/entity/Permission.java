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

@Entity(name = "pms_permission")
public class Permission extends AbstractEntity {

  @Column(unique = true, nullable = false)
  private String name;
  @Column(nullable = false)
  private Boolean admin = false;

  @OneToMany(mappedBy = "permission")
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

  public void setAdmin(final Boolean admin) {
    this.admin = admin;
  }

  public Boolean getAdmin() {
    return this.admin;
  }

  public Set<RolePermission> getRolePermissions() {
    return Collections.unmodifiableSet(this.rolePermissions);
  }

  public void addRolePermission(final RolePermission rolePermission) {
    rolePermission.setPermission(this);
  }

  public void removeRolePermission(final RolePermission rolePermission) {
    rolePermission.setPermission(null);
  }

  public void internalAddRolePermission(final RolePermission rolePermission) {
    this.rolePermissions.add(rolePermission);
  }

  public void internalRemoveRolePermission(final RolePermission rolePermission) {
    this.rolePermissions.remove(rolePermission);
  }

}