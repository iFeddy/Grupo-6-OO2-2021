package com.unla.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unla.app.entities.Personas;
import com.unla.app.models.PersonaModel;

public interface IPersonaService {

	public List<Personas> findAll();

	public Page<Personas> findAll(Pageable pageable);

	public void save(Personas persona);

	public Personas findOne(Long id);

	public void delete(Long id);

	public Personas findOneByDNI(int dni);

	public List<PersonaModel> traerPersonas();
	
	public PersonaModel insertOrUpdate(PersonaModel persona);

	public PersonaModel traerId(long id);
	
	public PersonaModel traerDni(int dni);

}
