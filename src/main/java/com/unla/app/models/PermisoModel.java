package com.unla.app.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

public class PermisoModel {

	protected int idPermiso;

	@NotNull
	protected PersonaModel persona;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	protected Date fecha;

	protected List<LugarModel> desdeHasta = new ArrayList<LugarModel>();

	@NotEmpty
	private String fechaString;

	public PermisoModel() {
		fechaString = Date.valueOf(LocalDate.now()).toString();
	}

	public PermisoModel(int idPermiso, PersonaModel persona, Date fecha, List<LugarModel> desdeHasta) {
		super();
		this.idPermiso = idPermiso;
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

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<LugarModel> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(List<LugarModel> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	@Override
	public String toString() {
		return "{" + " idPermiso='" + getIdPermiso() + "'" + ", persona='" + getPersona() + "'" + ", fecha='"
				+ getFecha() + "'" + ", desdeHasta='" + getDesdeHasta() + "'" + ", fechaString='" + getFechaString()
				+ "'" + "}";
	}

}