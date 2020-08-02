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

import pe.edu.upeu.entity.Ganador;
import pe.edu.upeu.service.GanadorService;

@RestController
@RequestMapping("/api")
public class GanadoresController {
	@Autowired
	private GanadorService ganadorService;
	
	@Secured({"ROLE_SECRETARY","ROLE_DIRECTOR"})
	@PostMapping("/ganador/add")
	public int create(@RequestBody Ganador win) {
		return ganadorService.create(win);
	}
	
	@Secured({"ROLE_SECRETARY","ROLE_DIRECTOR"})
	@PutMapping("/ganador/{id}")
	public int update(@RequestBody Ganador win, @PathVariable int id ) {
		win.setIdganador(id);
		return ganadorService.update(win);
	}
	
	@Secured({"ROLE_SECRETARY","ROLE_DIRECTOR"})
	@DeleteMapping("/ganador/{id}")
	public int delete(@PathVariable int id) {
		return ganadorService.delete(id);
	}
	
	@Secured({"ROLE_SECRETARY","ROLE_DIRECTOR"})
	@GetMapping("/ganador/{id_dc}")
	public Map<String, Object> readAll(@PathVariable int idc) {
		return ganadorService.readAll(idc);

    }
	@Secured({"ROLE_SECRETARY","ROLE_DIRECTOR"})
	@GetMapping("/ganador/listar/{idc}/{ide}")
	public Map<String,Object> read(@PathVariable int idc, @PathVariable int ide) {
		return ganadorService.read(idc, ide);
	}
}
