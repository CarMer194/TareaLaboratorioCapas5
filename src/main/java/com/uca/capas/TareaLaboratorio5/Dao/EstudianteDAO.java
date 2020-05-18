package com.uca.capas.TareaLaboratorio5.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import com.uca.capas.TareaLaboratorio5.Domain.Estudiante;

public interface EstudianteDAO {
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer codigo) throws DataAccessException;
	
	@Transactional
	public void insertarEstudiante(Estudiante estudiante) throws DataAccessException;
}
