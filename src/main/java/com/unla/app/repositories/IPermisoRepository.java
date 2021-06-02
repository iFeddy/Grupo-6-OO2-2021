package com.unla.app.repositories;

import com.unla.app.entities.Permisos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository("permisoRepository")
public interface IPermisoRepository extends PagingAndSortingRepository<Permisos, Long>{
	    
}