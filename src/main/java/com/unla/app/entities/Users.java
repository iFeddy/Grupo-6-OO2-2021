package com.unla.app.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="users")
public class Users implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=4 , max=30)
	@Column(name="firstName")
	private String firstName;
	
	@NotEmpty
	@Column(name="lastName")
	private String lastName;
	
	@NotEmpty
	@Email
	@Column(name="email")
	private String email;
	
	@NotEmpty
	@Column(name="typeDni")
	private String typeDni;
	
	@NotEmpty
	@Size(min=7 , max=8)
	@Column(name="dni")
	private String dni;
	
	@NotEmpty
	@Column(name="userName")
	private String userName;
	
	@NotEmpty
	@Column(name="password")
	private String password;
	
	@Column(name="activo")
	private boolean activo;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDate createdat;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDate updatedat;

	
	public Users() {}

		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTypeDni() {
		return typeDni;
	}

	public void setTypeDni(String typeDni) {
		this.typeDni = typeDni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

}
