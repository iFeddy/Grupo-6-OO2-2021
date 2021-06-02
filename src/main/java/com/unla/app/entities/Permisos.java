package com.unla.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="permisos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Permisos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pedido_id", nullable=false)
	protected Personas pedido;
	
	@Column(name="fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	protected LocalDate fecha;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lugar_salida_id", nullable=false)
	protected Lugares lugarSalida;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lugar_llegada_id", nullable=false)
	protected Lugares lugarLlegada;

	public Permisos() {
		super();
	}

	public Permisos(int idPermiso, Personas pedido, LocalDate fecha, Lugares lugarSalida, Lugares lugarLlegada) {
		super();
		this.idPermiso = idPermiso;
		this.pedido = pedido;
		this.fecha = fecha;
		this.lugarSalida = lugarSalida;
		this.lugarLlegada = lugarLlegada;
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public Personas getPedido() {
		return pedido;
	}

	public void setPedido(Personas pedido) {
		this.pedido = pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Lugares getLugarSalida() {
		return lugarSalida;
	}

	public void setLugarSalida(Lugares lugarSalida) {
		this.lugarSalida = lugarSalida;
	}

	public Lugares getLugarLlegada() {
		return lugarLlegada;
	}

	public void setLugarLlegada(Lugares lugarLlegada) {
		this.lugarLlegada = lugarLlegada;
	}
}

