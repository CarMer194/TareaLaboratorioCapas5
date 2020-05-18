package com.uca.capas.TareaLaboratorio5.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.TareaLaboratorio5.Domain.Estudiante;

@Repository
public class EstudianteDAOImp implements EstudianteDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		
		StringBuffer sb=new StringBuffer();
		sb.append("select * from ESTUDIANTE");
		Query query= entityManager.createNativeQuery(sb.toString(),Estudiante.class);
		List<Estudiante> estudiantes=query.getResultList();
		return estudiantes;
	}

	@Override
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		
		return null;
	}

	@Override
	@Transactional
	public void insertarEstudiante(Estudiante estudiante) throws DataAccessException {
		entityManager.persist(estudiante);	
	}
	
}
