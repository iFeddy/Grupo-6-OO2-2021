package com.unla.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name="permisos")
@Inheritance( strategy = InheritanceType.JOINED)
public class Permisos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_persona",nullable=false)
	protected Personas persona;
	
	@Column(name = "fecha", nullable=false)
	protected LocalDate  fecha;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToMany
	@JoinTable(name = "permiso_lugar",joinColumns = @JoinColumn(name="idPermiso"), inverseJoinColumns = @JoinColumn(name="idLugar") )
	protected Set<Lugar> desdeHasta;

	
	
	public Permisos() {
		super();
	}
	

	public Permisos( Personas persona, LocalDate fecha, Set<Lugar> desdeHasta) {
		this.persona = persona;
		this.fecha = fecha;
		this.desdeHasta = desdeHasta;
	}


	public int getIdPermiso() {
		return idPermiso;
	}


	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
		public Personas getPersona() {
		return persona;
	}

	public void setPersona(Personas persona) {
		this.persona = persona;
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	@Override
	public String toString() {
		return "Permiso [idPermiso=" + idPermiso + ", persona=" + persona + ", fecha=" + fecha + "]";
	}
}
