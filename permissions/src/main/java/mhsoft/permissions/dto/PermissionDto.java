package mhsoft.permissions.dto;

import java.io.Serializable;

public class PermissionDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private final long id;
  private String name;
  private final boolean locked;
  private final boolean admin;

  public PermissionDto(final long id, final String name, final boolean locked, final boolean admin) {
    super();
    this.id = id;
    this.name = name;
    this.locked = locked;
    this.admin = admin;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public boolean getLocked() {
    return this.locked;
  }

  public boolean getAdmin() {
    return this.admin;
  }

}