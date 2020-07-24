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

import pe.edu.upeu.entity.Convenios;
import pe.edu.upeu.service.ConvenioService;

@RestController
@RequestMapping("/api")
public class ConvenioController {
	@Autowired
	private ConvenioService convenioService;
	
	@Secured({"ROLE_STUDENT"})
	@PostMapping("/convenios/add")
	public int create(@RequestBody Convenios co) {
		System.out.println(co.toString());
		return convenioService.create(co);

	}
	@Secured({"ROLE_STUDENT"})
	@GetMapping("/convenios")
	public Map<String, Object> readAll() {
		return convenioService.readAll();

	}
	
	@Secured({"ROLE_STUDENT"})
	@PutMapping("convenios/upd/{id}")
	public int update(@RequestBody Convenios co, @PathVariable int id ) {
		co.setIdconvenio(id);
		return convenioService.update(co);
	}
	
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("convenios/del/{id}")
	public int delete(@PathVariable int id) {
		return convenioService.delete(id);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_STUDENT"})
	@GetMapping("convenios/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return convenioService.read(id);
	}
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("convenios/{idconv}/{idusu}")
	public Map<String, Object> validar(@PathVariable int idconv,@PathVariable int idusu) {
		return convenioService.validador(idconv, idusu);
	}
}
