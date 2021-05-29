package com.unla.app.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="roles", uniqueConstraints=@UniqueConstraint(columnNames={"name","users_id"}))
public class UsersRole implements Serializable {

	private static final long serialVersionUID = -7043414479526661974L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="users_id", nullable=false)
	private Users users;
	
	@NotEmpty
	@Size(min=4 , max=30)
	@Column(name="name", nullable=false,length=60)
	private String name;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDate createdat;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private LocalDate updatedat;
	
	
    public UsersRole() {
    }

	public UsersRole(Long id, Users users,String name, LocalDate createdat,
			LocalDate updatedat) {
		this.id = id;
		this.users = users;
		this.name = name;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "UsersRole [id=" + id + ", users=" + users + ", name=" + name + ", createdat=" + createdat
				+ ", updatedat=" + updatedat + "]";
	}

		
}