
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

import pe.edu.upeu.entity.Facultades;
import pe.edu.upeu.service.FacultadesService;

@RestController
@RequestMapping("/api")
public class FacultadesController {
	@Autowired
	private FacultadesService facultadesServices;
	
	@Secured({"ROLE_SECRETARY","ROLE_ADMIN"})
	@PostMapping("/facultades/add")
	public int create(@RequestBody Facultades fac) {
		System.out.println(fac.toString());
		return facultadesServices.create(fac);

	}
	
	@GetMapping("/facultades")
	public Map<String, Object> readAll() {
		return facultadesServices.readAll();

	}
	@Secured({"ROLE_SECRETARY","ROLE_ADMIN"})
	@PutMapping("facultades/upd/{id}")
	public int update(@RequestBody Facultades fac, @PathVariable int id ) {
		fac.setIdfacultad(id);
		return facultadesServices.update(fac);
	}
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@DeleteMapping("facultades/del/{id}")
	public int delete(@PathVariable int id) {
		return facultadesServices.delete(id);
	}
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_STUDENT"})
	@GetMapping("facultades/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return facultadesServices.read(id);
	}
}

