package pe.edu.upeu.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pe.edu.upeu.entity.Solicitud_Requisito;
import pe.edu.upeu.service.Solicitud_RequisitoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Solicitud_RequisitoController {
	@Autowired
	private Solicitud_RequisitoService srService;
	
	@Secured({"ROLE_SECRETARY","ROLE_DIRECTOR"})
	@PostMapping("/solicitud_requisitos/add")
	public int create(@RequestBody Solicitud_Requisito solicitud) {
		return srService.create(solicitud);
	}
	
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@DeleteMapping("/solicitud_requisitos/del/{id}")
	public int delete(@PathVariable int id) {
		return srService.delete(id);
	}
	
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@GetMapping("/solicitud_requisitos/read/{idsolicitud}")
	public Map<String,Object> read(@PathVariable int idsolicitud) {
		return srService.read(idsolicitud);
	}
	
	@PostMapping("/solicitud_requisitos/create")
	public ResponseEntity<?> createRequisito(@RequestParam("archivo") MultipartFile archivo,@RequestParam int idsolicitud,@RequestParam int idrequisito){
		Map<String, Object> response = new HashMap<>();
		Solicitud_Requisito req=new Solicitud_Requisito();
		Path rutaArchivo = null;
		String nombreArchivo = null ; 
		if(!archivo.isEmpty()) {
			nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			rutaArchivo = Paths.get(".//src//main//resources//file//solicitud_requisito//").resolve(nombreArchivo).toAbsolutePath();
		}
		try {
			req.setIdsolicitud(idsolicitud);
			req.setIdrequisito(idrequisito);
			req.setRuta(nombreArchivo);
			System.out.println("idsolicitud: "+req.getIdsolicitud());
			System.out.println("idrequisito: "+req.getIdrequisito());
			System.out.println("ruta: "+req.getRuta());
			srService.create(req);
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
	@PostMapping("/solicitud_requisitos/update")
	public ResponseEntity<?> updatearchivo(@RequestParam("archivo") MultipartFile archivo,@RequestParam("id") int idsol_req){
		Map<String, Object> response = new HashMap<>();
		Solicitud_Requisito req=new Solicitud_Requisito();
		System.out.println(idsol_req);
		req=srService.listar(idsol_req);
		req.toString();
		Path rutaArchivo = null;
		String nombreArchivo = null ; 
		if(!archivo.isEmpty()) {
			nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			rutaArchivo = Paths.get(".//src//main//resources//file//solicitud_requisito//").resolve(nombreArchivo).toAbsolutePath();
		}
		try {
			
			Files.copy(archivo.getInputStream(), rutaArchivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al subir la imagen : " +nombreArchivo);
			response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String nombrefotoanterior = req.getRuta();
		if (nombrefotoanterior != null ) {
			Path rutaFotoAnterior = Paths.get(".//src//main//resources//file//solicitud_requisito//").resolve(nombrefotoanterior).toAbsolutePath();
			File archivoanterior = rutaFotoAnterior.toFile();
			if (archivoanterior.exists() && archivoanterior.canRead()) {
				archivoanterior.delete();
			}
		}
		req.setRuta(nombreArchivo);
		srService.update(req);
		response.put("Recurso", 1);
		response.put("mensaje", "has subido correctamente las fotos " + nombreArchivo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/solicitud_requisitos/{id}")
	public ResponseEntity<Resource> verArchivo(@PathVariable int id){
		Resource recurso = null;
		Path rutaArchivo = null;
		String nombreArchivo = null;
		Solicitud_Requisito req=new Solicitud_Requisito();
		req=srService.listar(id);
		System.out.println(req);
		nombreArchivo = req.getRuta();
		rutaArchivo = Paths.get(".//src//main//resources//file//solicitud_requisito//").resolve(nombreArchivo).toAbsolutePath();
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
