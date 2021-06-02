package com.unla.app.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unla.app.entities.PermisosDiario;


@Repository("permisoDiarioRepository")
public interface IPermisoDiarioRepository extends JpaRepository<PermisosDiario, Serializable> {
	
	@Query(nativeQuery=true,value="Select p.*, pd.* from permiso p, permiso_diario pd where p.id_permiso=pd.id_permiso and p.pedido_id=(:id)")
	public List<PermisosDiario> traerPorPersona(int id);
	
	
	@Query(nativeQuery=true,value="Select p.*, pd.* from permiso p, permiso_diario pd where p.id_permiso=pd.id_permiso and p.fecha between (:fechaInicio) and (:fechaFin)")
	public List<PermisosDiario> traerPorFecha(LocalDate fechaInicio, LocalDate fechaFin);
}
