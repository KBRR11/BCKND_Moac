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

import pe.edu.upeu.entity.Personas;
import pe.edu.upeu.service.PersonasService;


@RestController
@RequestMapping("/api")
public class PersonasController {
	@Autowired
	private PersonasService personasService;
	
	@PostMapping("personas/add")
	public int create(@RequestBody Personas per) {
		return personasService.create(per);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_STUDENT","ROLE_DIGETTI"})
		@GetMapping("personas/")
		public Map<String, Object> readAll() {
			return personasService.readAll();

    }
		
	@Secured({"ROLE_STUDENT","ROLE_TEACHER","ROLE_ADMIN","ROLE_SECRETARY","ROLE_DIGETTI"})
	@PutMapping("personas/upd/{id}")
	public int update(@RequestBody Personas per, @PathVariable int id ) {
		per.setIdpersona(id);
		return personasService.update(per);
	}
	@Secured({"ROLE_ADMIN","ROLE_STUDENT","ROLE_DIGETTI"})
	@DeleteMapping("personas/del/{id}")
	public int delete(@PathVariable int id) {
		return personasService.delete(id);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_STUDENT","ROLE_DIGETTI"})
	@GetMapping("personas/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return personasService.read(id);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_DIGETTI"})
 	@GetMapping("/fdoc/{doc}")
 	public Map<String,Object> findDocumento(@PathVariable String documento) {		
 		return personasService.findDocumento(documento);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_DIGETTI"})
 	@GetMapping("/fapellido/{doc}")
 	public Map<String,Object> findAPELLIDOS(@PathVariable String apellido) {		
 		return personasService.findAPELLIDOS(apellido);
	}
}
