package com.unla.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.unla.app.entities.Lugares;
import com.unla.app.repositories.ILugarRepository;



@Service("lugarService")
public class LugaresServicesImpl implements ILugarService {

	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository iLugarRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Lugares> findAll() {
		return (List<Lugares>) iLugarRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Lugares> findAll(Pageable pageable) {
		return iLugarRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Lugares lugares) {
		iLugarRepository.save(lugares);
	}

	@Override
	@Transactional(readOnly = true)
	public Lugares findByCodigoPostal(String codigoPostal) {
		return iLugarRepository.findByCodigoPostal(codigoPostal).orElse(null);
	}

}
