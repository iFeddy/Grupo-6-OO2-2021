package com.unla.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(min = 4, max = 30)
	@Column(name = "firstName")
	private String firstName;

	@NotEmpty
	@Column(name = "lastName")
	private String lastName;

	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;

	@NotEmpty
	@Column(name = "typeDni")
	private String typeDni;

	@NotEmpty
	@Size(min = 7, max = 8)
	@Column(name = "dni")
	private String dni;

	@NotEmpty
	@Column(name = "userName" , unique=true, nullable=false , length=45)
	private String userName;

	@NotEmpty
	@Column(name = "password", nullable=false , length=50 )
	private String password;

	@Column(name = "activo")
	private boolean activo;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDate createdat;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private LocalDate updatedat;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="users_id")
		,inverseJoinColumns=@JoinColumn(name="usersrole_id"))
	private Set<UsersRole> usersRole = new HashSet<UsersRole>();
	
	/*@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
	private Set<UsersRole> usersRole = new HashSet<UsersRole>();*/

	public Users() {
	}
	
	public Users(Long id,String firstName, String lastName,String email,String typeDni, String dni,
			String userName,String password, boolean activo, LocalDate createdat,
			LocalDate updatedat, Set<UsersRole> usersRole) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.typeDni = typeDni;
		this.dni = dni;
		this.userName = userName;
		this.password = password;
		this.activo = activo;
		this.createdat = createdat;
		this.updatedat = updatedat;
		this.usersRole = usersRole;
	}

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

	public LocalDate getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDate createdat) {
		this.createdat = createdat;
	}

	public LocalDate getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(LocalDate updatedat) {
		this.updatedat = updatedat;
	}

	public Set<UsersRole> getUsersRole() {
		return usersRole;
	}

	public void setUsersRole(Set<UsersRole> usersRole) {
		this.usersRole = usersRole;
	}

	@Override
	public String toString() {
		return "{" + " id='" + getId() + "'" + ", firstName='" + getFirstName() + "'" + ", lastName='" + getLastName()
				+ "'" + ", email='" + getEmail() + "'" + ", typeDni='" + getTypeDni() + "'" + ", dni='" + getDni() + "'"
				+ ", userName='" + getUserName() + "'" + ", password='" + getPassword() + "'" + ", activo='"
				+ isActivo() + "'" +  getUsersRole() + "'" +"}";
	}

	private static final long serialVersionUID = 1L;

}