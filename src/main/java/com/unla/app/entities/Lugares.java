package com.unla.app.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name="lugares")
public class Lugares {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLugar;
	
	@Column(name="lugar",nullable = false,length = 45)
	private String lugar;
	
	@Column(name="codigoPostal",nullable = false,length = 45)
	private String codigoPostal;
	
	/*@ManyToMany
	@JoinTable(name = "permiso_lugar",joinColumns = @JoinColumn(name="idLugar"), inverseJoinColumns = @JoinColumn(name="idPermiso") )
	private Set<Permisos> permisos;*/
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
	public Lugares() {}


	public Lugares(long idLugar, String lugar, String codigoPostal, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.idLugar = idLugar;
		this.lugar = lugar;
		this.codigoPostal = codigoPostal;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public long getIdLugar() {
		return idLugar;
	}


	public void setIdLugar(long idLugar) {
		this.idLugar = idLugar;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "Lugar [idLugar=" + idLugar + ", lugar=" + lugar + ", codigoPostal=" + codigoPostal + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}


}
