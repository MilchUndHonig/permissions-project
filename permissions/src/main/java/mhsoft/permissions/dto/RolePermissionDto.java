package mhsoft.permissions.dto;

import java.io.Serializable;

public class RolePermissionDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private final long id;
  private final boolean locked;
  private boolean createPermission;
  private boolean editPermission;
  private boolean deletePermission;
  private boolean readPermission;

  public RolePermissionDto(final long id, final boolean locked, final boolean createPermission, final boolean editPermission, final boolean deletePermission,
      final boolean readPermission) {
    super();
    this.id = id;
    this.locked = locked;
    this.createPermission = createPermission;
    this.editPermission = editPermission;
    this.deletePermission = deletePermission;
    this.readPermission = readPermission;
  }

  public Long getId() {
    return this.id;
  }

  public boolean getLocked() {
    return this.locked;
  }

  public boolean getCreatePermission() {
    return this.createPermission;
  }

  public void setCreatePermission(final boolean createPermission) {
    this.createPermission = createPermission;
  }

  public boolean getEditPermission() {
    return this.editPermission;
  }

  public void setEditPermission(final boolean editPermission) {
    this.editPermission = editPermission;
  }

  public boolean getDeletePermission() {
    return this.deletePermission;
  }

  public void setDeletePermission(final boolean deletePermission) {
    this.deletePermission = deletePermission;
  }

  public boolean getReadPermission() {
    return this.readPermission;
  }

  public void setReadPermission(final boolean readPermission) {
    this.readPermission = readPermission;
  }

}