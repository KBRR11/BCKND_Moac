package pe.edu.upeu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.entity.EscuelasProfesionales;
import pe.edu.upeu.service.EscuelasProfesionalesService;

@RestController
@RequestMapping("/api")
public class EscuelasProfesionalesController {
	@Autowired
	private EscuelasProfesionalesService escuelasService;
	
	@Secured({"ROLE_STUDENT"})
	@PostMapping("/escuela/add")
	public int create(@RequestBody EscuelasProfesionales escuelas) {
		return escuelasService.create(escuelas);
	}
	
	@Secured({"ROLE_STUDENT"})
	@PutMapping("/escuela/{id}")
	public int update(@RequestBody EscuelasProfesionales escuelas, @PathVariable int id ) {
		escuelas.setIdep(id);
		return escuelasService.update(escuelas);
	}
	
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("/escuela/{id}")
	public int delete(@PathVariable int id) {
		return escuelasService.delete(id);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY",})
	@GetMapping("/escuela/")
	public Map<String, Object> readAll() {
		return escuelasService.readAll();

    }
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/escuela/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return escuelasService.read(id);
	}
	
	@GetMapping("/fac_ep/{id}")
	public Map<String,Object> readEp_fac(@PathVariable int id) {
		return escuelasService.readEpForFAC(id);
	}
}

