package com.unla.app.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "permisosPeriodo")
@PrimaryKeyJoinColumn(name = "idPermisoPeriodo")
public class PermisosPeriodo extends Permisos {
	@Column(name = "cantDias")
	private int cantDias;
	
	@Column(name = "vacacion",nullable=false, length=60)
	private boolean vacacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_rodado",nullable=false)
	private Rodados rodado;
	
	
	public PermisosPeriodo(Personas persona, LocalDate fecha, Set<Lugar> desdeHasta,int cantDias, boolean vacacion, Rodados rodado) {
		super( persona,  fecha, desdeHasta);
		this.cantDias = cantDias;
		this.vacacion = vacacion;
		this.rodado = rodado;
	}

	public PermisosPeriodo() {
		super();
	}
		
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	public boolean isVacacion() {
		return vacacion;
	}
	public void setVacacion(boolean vacacion) {
		this.vacacion = vacacion;
	}
	
	public Rodados getRodado() {
		return rodado;
	}
	public void setRodado(Rodados rodado) {
		this.rodado = rodado;
	}

	@Override
	public String toString() {
		return "PermisoPeriodo [cantDias=" + cantDias + ", vacacion=" + vacacion + ", rodado=" + rodado + "]";
	}
	
		
}