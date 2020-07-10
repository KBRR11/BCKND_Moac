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

import pe.edu.upeu.entity.Rol_Usuario;
import pe.edu.upeu.service.Rol_UsuarioService;

@RestController
@RequestMapping("/api")
public class Rol_UsuarioController {
	@Autowired
	private Rol_UsuarioService roluserService;
	
	@Secured({"ROLE_STUDENT"})
	@PostMapping("/roluser/add")
	public int create(@RequestBody Rol_Usuario ru) {
		return roluserService.create(ru);
	}
	
	@Secured({"ROLE_STUDENT"})
	@PutMapping("/roluser/{id}")
	public int update(@RequestBody Rol_Usuario ru, @PathVariable int id ) {
		ru.setIdrol_us(id);
		return roluserService.update(ru);
	}
	
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("/roluser/{id}")
	public int delete(@PathVariable int id) {
		return roluserService.delete(id);
	}
	
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/roluser/")
	public Map<String, Object> readAll() {
		return roluserService.readAll();

    }
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/roluser/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return roluserService.read(id);
	}
}
