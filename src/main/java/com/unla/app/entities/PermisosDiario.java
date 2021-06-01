package com.unla.app.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "permisoDiario")
@PrimaryKeyJoinColumn(name = "idPermisoDiario")
public class PermisosDiario extends Permisos {
	
	@Column(name = "motivo",nullable=false, length=60)
	private String motivo;

	

	public PermisosDiario(Personas persona, LocalDate fecha, Set<Lugar> desdeHasta,String motivo) {
		super( persona, fecha,  desdeHasta);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiario [motivo=" + motivo + ", idPermiso=" + idPermiso + ", fecha=" + fecha + "]";
	}
	
	
	
}