package com.uca.capas.TareaLaboratorio5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.TareaLaboratorio5.Dao.EstudianteDAO;
import com.uca.capas.TareaLaboratorio5.Domain.Estudiante;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@RequestMapping("/inicio")
	public ModelAndView init() {
		ModelAndView model = new ModelAndView();
		model.addObject("estudiante",new Estudiante());
		model.setViewName("index");		
		return model;
	}
	
	@RequestMapping("/agregarEstudiante")
	public ModelAndView agregar (Estudiante estudiante) {
		ModelAndView model=new ModelAndView();
		estudianteDAO.insertarEstudiante(estudiante);
		model.addObject("estudiante",new Estudiante());
		model.setViewName("index");
		return model;
	}
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView model=new ModelAndView();
		List<Estudiante> estudiantes=null;
		try {
			estudiantes=estudianteDAO.findAll();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		model.addObject("estudiantes",estudiantes);
		model.setViewName("listado");
		return model;
	}
	
}
