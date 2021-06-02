package com.unla.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.app.entities.Permisos;
import com.unla.app.repositories.IPermisoRepository;

@Service("permisoService")
public class PermisoServicesImpl implements IPermisoRepository {

	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository iPermisoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Permisos> findAll() {		
		return (List<Permisos>) iPermisoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Permisos findOne(Long id) {
		return iPermisoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Permisos> findAll(Pageable pageable) {
		return iPermisoRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Permisos permisos) {
		iPermisoRepository.save(permisos);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		iPermisoRepository.deleteById(id);
	}

}
