package pe.edu.upeu.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
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
	
	
	
	
	
	@PostMapping("/upload/{tipo}")
	public ResponseEntity<?> actualizarrecurso(@RequestParam("archivo") MultipartFile archivo, @RequestParam("idr") int idr, @RequestParam("id") int id, @PathVariable int tipo){
		Map<String, Object> response = new HashMap<>();
		
		//////VinculosRequisitos vinre = vincu.listarid(idv, idr);/////////
		Recursos recu = recursoService.rec_listarid(idr);
		
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get(".//src//main//resources//file//").resolve(nombreArchivo).toAbsolutePath();
			
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
			recu.setRuta(".//src//main//resources//file//" + nombreArchivo);
			recu.setIdrecurso(idr);
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
		
		//////VinculosRequisitos vinre = vincu.listarid(idv, idr);/////////
		Recursos recurso = new Recursos();
		
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get(".//src//main//resources//file//").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				response.put("mensaje", "Error al subir la imagen : " +nombreArchivo);
				response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			recurso.setTipo(tipo);
			recurso.setRuta(".//src//main//resources//file//"+ nombreArchivo);
			recurso.setNom_recurso(nombreArchivo);
			recurso.setIdcambio(id);
			recursoService.create(recurso);
			response.put("Recurso", 1);
			response.put("mensaje", "has subido correctamente las fotos " + nombreArchivo);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
