package pe.edu.upeu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.service.RolesService;

@RestController
@RequestMapping("/api")
public class RolController {
	@Autowired
	private RolesService rolService;
	
	@Secured({"ROLE_STUDENT","ROLE_DIGETTI"})
	@GetMapping("/rol")
	public Map<String, Object> readAll() {
		return rolService.readAll();

    }
	@Secured({"ROLE_STUDENT","ROLE_DIGETTI"})
	@GetMapping("/rol/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return rolService.read(id);
	}
}
