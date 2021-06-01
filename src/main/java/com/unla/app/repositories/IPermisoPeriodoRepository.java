package com.unla.app.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.app.entities.PermisoPeriodo;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Serializable> {
	
	@Query(nativeQuery=true,value="Select p.*, pp.* from permiso p, permiso_periodo pp where p.id_permiso=pp.id_permiso and p.pedido_id=(:id)")
	public List<PermisoPeriodo> traerPorPersona(int id);
	
	@Query(nativeQuery=true,value="Select p.*, pp.* from permiso p, permiso_periodo pp where p.id_permiso=pp.id_permiso and pp.rodado_id=(:id)")
	public List<PermisoPeriodo> traerPorRodado(int id);
	
	@Query("from PermisoPeriodo p")
	public List<PermisoPeriodo> findAll();
}
