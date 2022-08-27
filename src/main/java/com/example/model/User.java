package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	@NotEmpty(message = "Name can't be empty or null")
	private String name;
	
	@Column(name = "email")
	@NotEmpty(message = "email can't be empty or null")
	@Email(message = "please enter a valid email", regexp = ".+@.+\\..+")
	private String email;
	
	@Column(name = "password")
	@NotEmpty(message = "password can't be empty or null")
	private String password;
	
	@CreationTimestamp
	@Column(name = "createAt")
	private Date createAt;

	@CreationTimestamp
	@Column(name = "lastLogin")
	private Date lastLogin;
	
	@Column(name = "token")
	private String token;
	
	@CreationTimestamp
	@Column(name = "updateAt")
	private Date updateAt;
	
	@Column(name = "isActive")
	private Boolean isActive;
	
	@OneToMany(mappedBy="id")
	private List<Phones> phones;
	
	

	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	public List<Phones> getPhones() {
		return phones;
	}

	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}
}
