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

import pe.edu.upeu.entity.Rol_Opciones;
import pe.edu.upeu.service.Rol_OpcionesService;

@RestController
@RequestMapping("/api")
public class Rol_OpcionesController {
	@Autowired
	private Rol_OpcionesService opcionesService;
	
	@Secured({"ROLE_STUDENT"})
	@PostMapping("/rol_opciones/add")
	public int create(@RequestBody Rol_Opciones req) {
		System.out.println(req.toString());
		return opcionesService.create(req);

	}
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/rol_opciones")
	public Map<String, Object> readAll() {
		return opcionesService.readAll();

	}
	@Secured({"ROLE_STUDENT"})
	@PutMapping("/rol_opciones/upd/{id}")
	public int update(@RequestBody Rol_Opciones req, @PathVariable int id ) {
		req.setIdrol_opcion(id);
		return opcionesService.update(req);
	}
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("/rol_opciones/del/{id}")
	public int delete(@PathVariable int id) {
		return opcionesService.delete(id);
	}
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/rol_opciones/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return opcionesService.readByRol(id);
	}
}
