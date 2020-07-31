package pe.edu.upeu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.entity.Solicitud;
import pe.edu.upeu.service.SolicitudService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SolicitudController {
	@Autowired
	private SolicitudService sService;
	
	@Secured({"ROLE_SECRETARY","ROLE_STUDENT"})
	@PostMapping("/solicitud/add")
	public int create(@RequestBody Solicitud req) {
		System.out.println(req.toString());
		return sService.create(req);

	}
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/solicitud/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return sService.read(id);
	}
	
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/solicitudes")
	public Map<String, Object> readAll() {
		return sService.readAll();

	}
}
