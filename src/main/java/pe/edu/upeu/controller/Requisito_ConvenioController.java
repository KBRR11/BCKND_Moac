package pe.edu.upeu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.entity.Requisito_Convenio;
import pe.edu.upeu.entity.Requisitos;
import pe.edu.upeu.service.Requisito_ConvenioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Requisito_ConvenioController {
	
	@Autowired
	private Requisito_ConvenioService requisito_convenioService;
	
	@Secured({"ROLE_SECRETARY"})
	@PostMapping("/requisitos_convenio/add")
	public int create(@RequestBody Requisito_Convenio req) {
		System.out.println(req.toString());
		return requisito_convenioService.create(req);

	}
	
	@Secured({"ROLE_SECRETARY"})
	@PutMapping("/requisitos_convenio/upd/{id}")
	public int update(@RequestBody Requisito_Convenio req, @PathVariable int id ) {
		req.setIdrequisito_convenio(id);
		return requisito_convenioService.update(req);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/requisitos_convenio/list/{idco}/{idre}")
	public Map<String,Object> readConvenio(@PathVariable int idco,@PathVariable int idre) {
		return requisito_convenioService.read(idco,idre);
	}
}
