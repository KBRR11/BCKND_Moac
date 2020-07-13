package pe.edu.upeu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.upeu.dao.RecurosoDao;
import pe.edu.upeu.service.RecursoService;
import pe.edu.upeu.serviceImp.RecursoServiceImp;

@Controller
public class RecursosController {
	@Autowired
	private RecursoServiceImp recursoService;
	@PostMapping("recuso")
	private void publi() {
		// TODO Auto-generated method stub
	}
}
