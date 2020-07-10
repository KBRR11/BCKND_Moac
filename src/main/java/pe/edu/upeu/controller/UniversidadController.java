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

import pe.edu.upeu.entity.Universidad;
import pe.edu.upeu.service.UniversidadService;

@RestController
@RequestMapping("/api")
public class UniversidadController {
	@Autowired
	private UniversidadService universidadService;
	

	@Secured({"ROLE_STUDENT"})
	@PostMapping("/univercity/add")
	public int create(@RequestBody Universidad uni) {
		return universidadService.create(uni);
	}
	
	@Secured({"ROLE_STUDENT"})
	@PutMapping("/univercity/{id}")
	public int update(@RequestBody Universidad uni, @PathVariable int id ) {
		uni.setIduniversidad(id);
		return universidadService.update(uni);
	}
	
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("/univercity/{id}")
	public int delete(@PathVariable int id) {
		return universidadService.delete(id);
	}
	
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/univercity/")
	public Map<String, Object> readAll() {
		return universidadService.readAll();

    }
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/univercity/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return universidadService.read(id);
	}
	
}
