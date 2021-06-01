package com.unla.app.services;

import java.time.LocalDate;
import java.util.List;
import com.unla.app.entities.PermisoPeriodo;


public interface IPermisoPeriodoService {
	
	public List<PermisoPeriodo> traerPorPersona(int id);
	
	public List<PermisoPeriodo> traerPorRodado(int id);
	
	public void save(PermisoPeriodo permisoPeriodo);
	
	public List<PermisoPeriodo> traerPorFecha(LocalDate fechaInicio, LocalDate fechaFin);
	
	public List<PermisoPeriodo> traerPorFechaYLugar(LocalDate fechaInicio, LocalDate fechaFin, String lugar);
	
}
