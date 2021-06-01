package com.unla.app.services;

import java.time.LocalDate;
import java.util.List;
import com.unla.app.entities.PermisoDiario;

public interface IPermisoDiarioService {
	
	public List<PermisoDiario> traerPorPersona(int id);
	
	public void save(PermisoDiario permisoDiario);
	
	public List<PermisoDiario> traerPorFecha(LocalDate fechaInicio, LocalDate fechaFin);
	
	public List<PermisoDiario> traerPorFechaYSalida(LocalDate fechaInicio, LocalDate fechaFin, String salida);
	
	public List<PermisoDiario> traerPorFechaYLugar(LocalDate fechaInicio, LocalDate fechaFin, String lugar);
}
