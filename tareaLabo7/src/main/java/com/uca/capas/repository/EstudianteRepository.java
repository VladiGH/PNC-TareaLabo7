package com.uca.capas.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
	
	public List<Estudiante> findByNombre(String cadena) throws DataAccessException;
	
	public List<Estudiante> findByApellidoStartingWith(String cadena) throws DataAccessException;
	
	public Estudiante findByCodigoEstudiante(Integer codigoEstudiante);
	
	@Query(nativeQuery = true, value="select * from public.estudiante")
	public List<Estudiante> mostrarTodos() throws DataAccessException;
	

	//por posicion de params
	//@Query(nativeQuery = true, value="select * from public.estudiante where nombre = ?1")
	@Query(nativeQuery = true, value="select * from public.estudiante where nombre = :cadena")
	public List<Estudiante> mostrarPorNombre(String cadena) throws DataAccessException;
	
}
