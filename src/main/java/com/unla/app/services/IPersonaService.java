package com.unla.app.services;

import java.util.List;
import com.unla.app.entities.Persona;


public interface IPersonaService {
	
	public List<Persona> getAll();
	
	public void save(Persona persona);
	
	public int cantidad (long dni);
	
	public Persona listarId(int id);
}
