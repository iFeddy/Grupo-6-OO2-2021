package com.unla.app.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.app.converters.PersonaConverter;
import com.unla.app.entities.Personas;
import com.unla.app.models.PersonaModel;
import com.unla.app.repositories.IPersonaRepository;
import com.unla.app.services.IPersonaService;

@Service("personaService")
public class PersonaServices implements IPersonaService {

	@Autowired
	@Qualifier("iPersonaRepository")
	private IPersonaRepository iPersonaRepository;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	@Override
	@Transactional(readOnly = true)
	public List<Personas> findAll() {		
		return (List<Personas>) iPersonaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Personas findOne(Long id) {
		return iPersonaRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Personas findOneByDNI(int dni) {
		return iPersonaRepository.findByDni(dni);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Personas> findAll(Pageable pageable) {
		return iPersonaRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Personas persona) {
		iPersonaRepository.save(persona);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		iPersonaRepository.deleteById(id);
	}

	@Override
	public List<PersonaModel> traerPersonas() {
		List<PersonaModel> aux = new ArrayList<PersonaModel>();
		for (Personas personas : iPersonaRepository.findAll()) {
			aux.add(personaConverter.entityToModel(personas));
		}
		return aux;
	}

	@Override
	public PersonaModel insertOrUpdate(PersonaModel persona) {
		Personas personaEntity = personaConverter.modelToEntity(persona);
		return personaConverter.entityToModel(iPersonaRepository.save(personaEntity));
	}

	@Override
	public PersonaModel traerId(long id) {
		Personas personaExistente = iPersonaRepository.findById(id);
		PersonaModel model = null;
		if(personaExistente!=null)
		{
			model= personaConverter.entityToModel(personaExistente);
		}
		return model;
	}

	@Override
	public PersonaModel traerDni(int dni) {
		Personas personaExistente = iPersonaRepository.findByDni(dni);
		PersonaModel model = null;
		if(personaExistente!=null)
		{
			model= personaConverter.entityToModel(personaExistente);
		}
		return model;
	}

}
