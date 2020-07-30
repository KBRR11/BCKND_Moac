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

import pe.edu.upeu.entity.Convocatoria;
import pe.edu.upeu.service.ConvocatoriaService;

@RestController
@RequestMapping("/api")
public class ConvocatoriaController {
	@Autowired
	private ConvocatoriaService convocatoriaService;
	
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@PostMapping("/convocatoria/add")
	public int create(@RequestBody Convocatoria conv) {
		System.out.println(conv.toString());
		return convocatoriaService.create(conv);

	}
	@Secured({"ROLE_DIRECTOR","ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/convocatoria/{tipo}")
	public Map<String, Object> readAll(@PathVariable int tipo) {
		return convocatoriaService.readAll(tipo);

	}
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@PutMapping("/convocatoria/upd/{id}")
	public int update(@RequestBody Convocatoria conv, @PathVariable int id ) {
		conv.setIdconvocatoria(id);
		System.out.println(conv.toString());
		return convocatoriaService.update(conv);
	}
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@DeleteMapping("/convocatoria/del/{id}")
	public int delete(@PathVariable int id) {
		return convocatoriaService.delete(id);
	}
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@GetMapping("/convocatorias/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return convocatoriaService.read(id);
	}
}
