package pe.edu.upeu.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.edu.upeu.entity.Recursos;
import pe.edu.upeu.entity.Requisitos;
import pe.edu.upeu.service.RequisitosService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RequisitoController {
	
	@Autowired
	private RequisitosService requisitosService;
	
	@Secured({"ROLE_SECRETARY"})
	@PostMapping("/requisitos/add")
	public int create(@RequestBody Requisitos req) {
		System.out.println(req.toString());
		return requisitosService.create(req);

	}
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/requisitos")
	public Map<String, Object> readAll() {
		return requisitosService.readAll();

	}
	@Secured({"ROLE_SECRETARY"})
	@PutMapping("/requisitos/upd/{id}")
	public int update(@RequestBody Requisitos req, @PathVariable int id ) {
		req.setIdrequisito(id);
		return requisitosService.update(req);
	}
	
	@Secured({"ROLE_SECRETARY"})
	@DeleteMapping("/requisitos/del/{id}")
	public int delete(@PathVariable int id) {
		return requisitosService.delete(id);
	}
	//@Secured({"ROLE_ADMIN","ROLE_SECRETARY,ROLE_STUDENT"})
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/requisitos/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return requisitosService.read(id);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/requisitos/convenio/{idconve}/{ide}")
	public Map<String,Object> readConvenio(@PathVariable int idconve,@PathVariable int ide) {
		return requisitosService.readConvenios(idconve,ide);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/requisitos/convenio2/{idconve}/{ide}")
	public Map<String,Object> readConvenio2(@PathVariable int idconve,@PathVariable int ide) {
		return requisitosService.readConvenios2(idconve,ide);
	}
	
	@PostMapping("/requisito/create")
	public ResponseEntity<?> createRequisito(@RequestParam("archivo") MultipartFile archivo,@RequestParam String nombre){
		Map<String, Object> response = new HashMap<>();
		Requisitos req=new Requisitos();
		Path rutaArchivo = null;
		String nombreArchivo = null ; 
		if(!archivo.isEmpty()) {
			nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			rutaArchivo = Paths.get(".//src//main//resources//file//requisito//").resolve(nombreArchivo).toAbsolutePath();
		}
		try {
			req.setNombre(nombre);
			req.setRuta(nombreArchivo);
			requisitosService.create(req);
			Files.copy(archivo.getInputStream(), rutaArchivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al subir la imagen : " +nombreArchivo);
			response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("Recurso", 1);
		response.put("mensaje", "has subido correctamente las fotos " + nombreArchivo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/requisitoVer/{id}")
	public ResponseEntity<Resource> verArchivo(@PathVariable int id){
		Requisitos reqe = new Requisitos();
		Resource recurso = null;
		Path rutaArchivo = null;
		String nombreArchivo = null;
		reqe = requisitosService.listarArchivo(id);
			nombreArchivo = reqe.getRuta();
			rutaArchivo = Paths.get(".//src//main//resources//file//requisito//").resolve(nombreArchivo).toAbsolutePath();
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error :" + nombreArchivo);
		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
}
