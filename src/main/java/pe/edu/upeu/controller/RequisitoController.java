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

import pe.edu.upeu.entity.Requisitos;
import pe.edu.upeu.service.RequisitosService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RequisitoController {
	
	@Autowired
	private RequisitosService requisitosService;
	
	@Secured({"ROLE_STUDENT"})
	@PostMapping("/requisitos/add")
	public int create(@RequestBody Requisitos req) {
		System.out.println(req.toString());
		return requisitosService.create(req);

	}
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/requisitos")
	public Map<String, Object> readAll() {
		return requisitosService.readAll();

	}
	@Secured({"ROLE_STUDENT"})
	@PutMapping("/requisitos/upd/{id}")
	public int update(@RequestBody Requisitos req, @PathVariable int id ) {
		req.setIdrequisito(id);
		return requisitosService.update(req);
	}
	
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("/requisitos/del/{id}")
	public int delete(@PathVariable int id) {
		return requisitosService.delete(id);
	}
	//@Secured({"ROLE_ADMIN","ROLE_SECRETARY,ROLE_STUDENT"})
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/requisitos/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return requisitosService.read(id);
	}
	
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/requisitos/convenio/{idconve}")
	public Map<String,Object> readConvenio(@PathVariable int idconve) {
		return requisitosService.readConvenios(idconve);
	}
}
