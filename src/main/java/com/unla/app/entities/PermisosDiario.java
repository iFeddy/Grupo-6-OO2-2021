package com.unla.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="permisosDiario")
@PrimaryKeyJoinColumn(referencedColumnName ="idPermiso")
public class PermisosDiario extends Permisos {
	
	@Column(name="motivo", nullable = false)
	private String motivo;

	public PermisosDiario() {
		super();
	}

	public PermisosDiario(int idPermiso, Personas pedido, LocalDate fecha, Lugares lugarSalida, Lugares lugarLlegada,
			String motivo) {
		super(idPermiso, pedido, fecha, lugarSalida, lugarLlegada);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
