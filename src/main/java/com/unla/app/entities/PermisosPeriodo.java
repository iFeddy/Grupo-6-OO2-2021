package com.unla.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="permisosPeriodo")
@PrimaryKeyJoinColumn(referencedColumnName ="idPermiso")
public class PermisosPeriodo extends Permisos {
	
	@Column(name="cantDias", nullable = false)
	private int cantDias;
	
	@Column(name="vacaciones", nullable = false)
	private boolean vacaciones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="rodado_id", nullable=false)
	private Rodados rodado;

	public PermisosPeriodo() {
		super();
	}
	
	public PermisosPeriodo(int idPermiso, Personas pedido, LocalDate fecha, Lugares lugarSalida, Lugares lugarLlegada,
			int cantDias, boolean vacaciones, Rodados rodado) {
		super(idPermiso, pedido, fecha, lugarSalida, lugarLlegada);
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public Rodados getRodado() {
		return rodado;
	}

	public void setRodado(Rodados rodado) {
		this.rodado = rodado;
	}
	
	
}
