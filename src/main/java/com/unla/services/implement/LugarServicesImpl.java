package com.unla.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unla.app.entities.Lugar;
import com.unla.app.repositories.ILugarRepository;
import com.unla.app.services.ILugarService;


@Service("lugarService")
public class LugarServicesImpl implements ILugarService  {

	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarReopository;
	
	@Override
	public int cantidad(String lugar) {
		return lugarReopository.repetido(lugar);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Lugar> findAll() {
		return (List<Lugar>) lugarReopository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Lugar> findAll(Pageable pageable) {
		return lugarReopository.findAll(pageable);
	}

	@Override
	@Transactional
	public void save(Lugar lugar) {
		lugarReopository.save(lugar);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Lugar findOne(Long id) {
		return lugarReopository.findById(id).orElse(null);
	}

}
