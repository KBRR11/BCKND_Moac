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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import pe.edu.upeu.dao.RecursosDao;
import pe.edu.upeu.entity.Recursos;
import pe.edu.upeu.service.RecursoService;
import pe.edu.upeu.serviceImp.RecursoServiceImp;

@Controller
public class RecursosController {
	@Autowired
	private RecursoServiceImp recursoService;
	
	
	/*@GetMapping("/upload/listar/{id}/{tipo}")
	public Map<String, Object> read(@PathVariable int id, @PathVariable int tipo){
		return recursoService.read(id, tipo);
	} */
	
	
	@PostMapping("/upload/{tipo}")
	public ResponseEntity<?> actualizarrecurso(@RequestParam("archivo") MultipartFile archivo, @RequestParam("idr") int idr, @RequestParam("id") int id, @PathVariable int tipo){
		
		Map<String, Object> response = new HashMap<>();
		Recursos recu = recursoService.rec_listarid(idr);
		Path rutaArchivo = null;
		String nombreArchivo = null; 
		
		if(!archivo.isEmpty()) {
			switch (recu.getTipo()) {
			case 1:
				nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
				rutaArchivo = Paths.get(".//src//main//resources//file//convocatoria//").resolve(nombreArchivo).toAbsolutePath();
				break;
			case 2:
				nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
				rutaArchivo = Paths.get(".//src//main//resources//file//convenio//").resolve(nombreArchivo).toAbsolutePath();
				break;
			case 3:
				nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
				rutaArchivo = Paths.get(".//src//main//resources//file//universidad//").resolve(nombreArchivo).toAbsolutePath();
				break;
			case 4:
				nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
				rutaArchivo = Paths.get(".//src//main//resources//file//requisito//").resolve(nombreArchivo).toAbsolutePath();
				break;
			default:
				break;
			}
			
			
			try {
				
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				response.put("mensaje", "Error al subir la imagen : " +nombreArchivo);
				response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombrefotoanterior = recu.getRuta();
			
			if (nombrefotoanterior != null || nombrefotoanterior.length() >0) {
				Path rutaFotoAnterior = Paths.get(".//src//main//resources//file//").resolve(nombrefotoanterior).toAbsolutePath();
				File archivoanterior = rutaFotoAnterior.toFile();
				if (archivoanterior.exists() && archivoanterior.canRead()) {
					archivoanterior.delete();
				}
			}
			recu.setRuta(nombreArchivo);
			recu.setIdrecurso(idr);
			recu.setNom_recurso(nombreArchivo);
			recu.setTipo(tipo);
			recursoService.update(recu);
			response.put("vinculosrequisitos", recu);
			response.put("mensaje", "has subido correctamente las fotos " + nombreArchivo);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/upload/create/{tipo}")
	public ResponseEntity<?> crearrecurso(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") int id, @PathVariable int tipo){
		Map<String, Object> response = new HashMap<>();
		Recursos recurso = new Recursos();
		Path rutaArchivo = null;
		String nombreArchivo = "" ; 
		
		if(!archivo.isEmpty()) {
			switch (tipo) {
			case 1:
				nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
				rutaArchivo = Paths.get(".//src//main//resources//file//convocatoria//").resolve(nombreArchivo).toAbsolutePath();
				break;
			case 2:
				nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
				rutaArchivo = Paths.get(".//src//main//resources//file//convenio//").resolve(nombreArchivo).toAbsolutePath();
				break;
			case 3:
				nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
				rutaArchivo = Paths.get(".//src//main//resources//file//universidad//").resolve(nombreArchivo).toAbsolutePath();
				break;
			case 4:
				nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
				rutaArchivo = Paths.get(".//src//main//resources//file//requisito//").resolve(nombreArchivo).toAbsolutePath();
				break;
			default:
				break;
			}
			System.out.println(rutaArchivo);
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				response.put("mensaje", "Error al subir la imagen : " +nombreArchivo);
				response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			recurso.setTipo(tipo);
			recurso.setRuta(nombreArchivo);
			recurso.setNom_recurso(nombreArchivo);
			recurso.setIdcambio(id);
			recursoService.create(recurso);
			response.put("Recurso", 1);
			response.put("mensaje", "has subido correctamente las fotos " + nombreArchivo);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/upload/{tipo}/{id}")
	public ResponseEntity<Resource> verArchivo(@PathVariable int tipo, @PathVariable int id){
		Recursos rec = new Recursos();
		Resource recurso = null;
		Path rutaArchivo = null;
		String nombreArchivo = null;
		
		switch (tipo) {
		case 1:
			rec=recursoService.listar1(id);
			System.out.println(rec);
			nombreArchivo = rec.getNom_recurso();
			rutaArchivo = Paths.get(".//src//main//resources//file//convocatoria//").resolve(nombreArchivo).toAbsolutePath();
			break;
			
		case 2:
			rec=recursoService.listar2(id);
			nombreArchivo = rec.getNom_recurso();
			rutaArchivo = Paths.get(".//src//main//resources//file//convenio//").resolve(nombreArchivo).toAbsolutePath();
			break;
		case 3:
			rec=recursoService.listar3(id);
			nombreArchivo = rec.getNom_recurso();
			rutaArchivo = Paths.get(".//src//main//resources//file//universidad//").resolve(nombreArchivo).toAbsolutePath();
			break;
		case 4:
			rec=recursoService.listar4(id);
			nombreArchivo = rec.getNom_recurso();
			rutaArchivo = Paths.get(".//src//main//resources//file//requisito//").resolve(nombreArchivo).toAbsolutePath();
			break;
		default:
			break;
		}
		
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
