package mhsoft.permissions.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AbstractEntity {

  public static final String SYSTEM_USER = "SYSTEM";

  @Id
  @SequenceGenerator(name = "pms_sequence", sequenceName = "pms_sequence", initialValue = 0, allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pms_sequence")
  private Long id;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date", nullable = false)
  private Date createDate;
  @Column(name = "create_user", nullable = false)
  private String createUser;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "change_date")
  private Date changeDate;
  @Column(name = "change_user")
  private String changeUser;
  @Column(nullable = false)
  private Boolean locked = false;

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Date getCreateDate() {
    return this.createDate;
  }

  public void setCreateDate(final Date createDate) {
    this.createDate = createDate;
  }

  public String getCreateUser() {
    return this.createUser;
  }

  public void setCreateUser(final String createUser) {
    this.createUser = createUser;
  }

  public Date getChangeDate() {
    return this.changeDate;
  }

  public void setChangeDate(final Date changeDate) {
    this.changeDate = changeDate;
  }

  public String getChangeUser() {
    return this.changeUser;
  }

  public void setChangeUser(final String changeUser) {
    this.changeUser = changeUser;
  }

  public Boolean getLocked() {
    return this.locked;
  }

  public void setLocked(final Boolean locked) {
    this.locked = locked;
  }

}