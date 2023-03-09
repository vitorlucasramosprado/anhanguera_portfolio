package com.anhanguera.pw.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	public UUID id;
	public String name;
	public String email;
	public String telephone;
	public String password;
	
	public User() {
		super();
	}

	public User(UUID id, String name, String email, String telephone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UUID getId() {
		return id;
	}
	
	
	
}
