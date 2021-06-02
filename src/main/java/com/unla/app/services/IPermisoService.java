package com.unla.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unla.app.entities.Permisos;

public interface IPermisoService {
	
	public List<Permisos> findAll();

	public Page<Permisos> findAll(Pageable pageable);

	public void save(Permisos permiso);

	public Permisos findOne(Long id);

	public void delete(Long id);

}
