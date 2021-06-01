package com.unla.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.unla.app.entities.Lugar;



public interface ILugarService {
	
	public int cantidad(String lugar);
	
	public List<Lugar> findAll();

	public Page<Lugar> findAll(Pageable pageable);

	public void save(Lugar lugar);

	public Lugar findOne(Long id);

}
