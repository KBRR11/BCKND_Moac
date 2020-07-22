package pe.edu.upeu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.entity.Opcion;
import pe.edu.upeu.service.OpcionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/opcion")
public class OpcionController {
	@Autowired
	private OpcionService opcionService;
	
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/")
	public Map<String, Object> readAll(){
		return opcionService.readAll();
	}
	
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/{idopcion}")
	public Map<String, Object> read(@PathVariable int idopcion){
		return opcionService.read(idopcion);
	}
	
	@Secured({"ROLE_STUDENT"})
	@PostMapping("/add")
	public int create(@RequestBody Opcion o ) {
		return opcionService.create(o);
				
	}
	
	@Secured({"ROLE_STUDENT"})
	@PutMapping("/update/{id}")
	public int update(@RequestBody Opcion opcion ,@PathVariable int id) {
		opcion.setIdopcion(id);
		return opcionService.update(opcion);
	}
	
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable int id) {
		return opcionService.delete(id);
	}
}
