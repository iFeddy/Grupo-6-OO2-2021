package com.unla.app.entities;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name="roles")
public class UsersRole implements Serializable {

	private static final long serialVersionUID = -7043414479526661974L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=4 , max=30)
	@Column(name="name", nullable=false,length=60)
	private String name;
	
	@Column
	private String description;

	@Column(name = "createdat")
	@CreationTimestamp
	private LocalDate createdat;

	@Column(name = "updatedat")
	@UpdateTimestamp
	private LocalDate updatedat;
	
	
    public UsersRole() {
    }

	public UsersRole(Long id,String name, String description, LocalDate createdat,
			LocalDate updatedat) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "UsersRole [id=" + id + ", name=" + name + ", description=" + description + ", createdat=" + createdat
				+ ", updatedat=" + updatedat + "]";
	}

		
}