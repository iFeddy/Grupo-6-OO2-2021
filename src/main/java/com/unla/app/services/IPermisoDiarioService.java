package com.unla.app.services;

import java.time.LocalDate;
import java.util.List;
import com.unla.app.entities.Permisos;
import com.unla.app.entities.PermisosDiario;


public interface IPermisoDiarioService {
	
	public List<Permisos> traerPorPersona(int id);
	
	public PermisosDiario insertOrUpdate(PermisosDiario permisoDiarios);
	
	public List<Permisos> traerPorFecha(LocalDate fechaInicio, LocalDate fechaFin);
	
	public List<Permisos> traerPorFechaYSalida(LocalDate fechaInicio, LocalDate fechaFin, String salida);
	
	public List<Permisos> traerPorFechaYLugar(LocalDate fechaInicio, LocalDate fechaFin, String lugar);
}
