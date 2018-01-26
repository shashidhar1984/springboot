package com.app.user.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
// automatically get populated @CreatedDate and @LastModifiedDate
// whenever we create or update an entity.
public class UserModel {
	@Id
	@Column(name = "id")
	private String username;

	@NotBlank
	private String email;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "passwordConfirm", nullable = false, length = 60)
	private String passwordConfirm;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "dateofbirth", nullable = false)
	private Date dob;

	@Column(name = "createdtime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdTime;

	@Column(name = "lastModifiedtime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModifiedTime;

	@OneToMany(mappedBy = "user")
	private Set<UserRoleModel> userRole = new HashSet<UserRoleModel>(0);

	public Set<UserRoleModel> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRoleModel> userRole) {
		this.userRole = userRole;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
