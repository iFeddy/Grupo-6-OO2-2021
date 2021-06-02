package com.unla.app.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity(name="personas")

public class Personas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersona;
	
	@Column(name="nombre", nullable=false, length=45)
	private String nombre;

	@Column(name="apellido", nullable=false, length=45)
	private String apellido;
	
	@Column(name="dni", nullable=false, unique = true)
	private long dni;
	
	/*@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="persona")
	private Set<Users> users;*/
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	public Personas() {}
	
	
	public Personas( long idPersona,String nombre, String apellido, long dni) {
		this.idPersona=idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}


	public long getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public long getDni() {
		return dni;
	}
	
	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
	
}