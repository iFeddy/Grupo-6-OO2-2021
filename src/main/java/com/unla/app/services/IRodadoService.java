package com.unla.app.services;

import java.util.List;

import com.unla.app.entities.Rodado;

public interface IRodadoService {
	
	public List<Rodado> getAll();
	
	public Rodado insertOrUpdate(Rodado rodado);
	
	public int cantidad(String dominio);
	
}
