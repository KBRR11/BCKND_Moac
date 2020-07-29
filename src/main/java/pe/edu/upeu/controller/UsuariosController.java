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
import pe.edu.upeu.entity.Usuarios;
import pe.edu.upeu.service.UsuariosService;



@RestController
@RequestMapping("/api")
public class UsuariosController {
	@Autowired
	private UsuariosService usuariosService;
	
	@PostMapping("/add_student")
	public int create_estudiante(@RequestBody Usuarios users) {
		return usuariosService.create_estudiante(users);
	}
	@PostMapping("/add_teacher")
	public int create_docente(@RequestBody Usuarios users) {
		return usuariosService.create_docente(users);
	}
	
	@Secured({"ROLE_DIGETTI","ROLE_STUDENT"})
	@PostMapping("/add_especial_user")
	public int create_user_especial(@RequestBody Usuarios users) {
		return usuariosService.create_user_especial(users);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/all_active")
	public Map<String, Object> readAll_Active() {
		return usuariosService.readAll_Active();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/all_pending_Est")
	public Map<String, Object> readAll_Pending_Est() {
		return usuariosService.readAll_Pending_Est();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/all_pending_Doc")
	public Map<String, Object> readAll_Pending_Doc() {
		return usuariosService.readAll_Pending_Doc();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/all_students")
	public Map<String, Object> readAll_Students() {
		return usuariosService.readAll_Students();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/all_teachers")
	public Map<String, Object> readAll_Teachers() {
		return usuariosService.readAll_Teachers();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_STUDENT","ROLE_TEACHER"})
	@PutMapping("/upd/nom_user/{id}")
	public int update_nomUser(@RequestBody Usuarios usuario, @PathVariable int id) {
		usuario.setIdusuario(id);
		return usuariosService.update_nomUser(usuario);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_STUDENT","ROLE_TEACHER","ROLE_DIGETTI"})
	@PutMapping("/upd/password/{id}")
	public int update_password(@RequestBody Usuarios password , @PathVariable int id) {
		password.setIdusuario(id);
		return usuariosService.update_password(password);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_TEACHER"})
	@PutMapping("/upd/sede/{id}")
	public int update_sede(@RequestBody Usuarios sede, @PathVariable int id) {
		sede.setIdusuario(id);
		return usuariosService.update_sede(sede);
	}
	
	@Secured({"ROLE_STUDENT"})
	@PutMapping("/upd/ciclo/{id}")
	public int update_ciclo(@RequestBody Usuarios ciclo, @PathVariable int id) {
		ciclo.setIdusuario(id);
		return usuariosService.update_ciclo(ciclo);
	}	
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_DIGETTI"})
	@PutMapping("/deactivate/{id}")
	public int desactivar_user( @PathVariable int id) {
		return usuariosService.desactivar_user(id);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_DIGETTI"})
	@PutMapping("/activate/{id}")
	public int activar_user( @PathVariable int id) {
		return usuariosService.activar_user(id);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_DIGETTI","ROLE_SECRETARY"})
	@DeleteMapping("/delete_user/{id}")
	public int delete(@PathVariable int id) {
		return usuariosService.delete(id);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/contador_active")
	public Map<String, Object> contadorUsers_Active() {
		return usuariosService.contadorUsers_Active();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/contEst_active")
	public Map<String, Object> contadorEstudents_Active() {
		return usuariosService.contadorEstudents_Active();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/contTeach_active")
	public Map<String, Object> contadorTeachers_Active() {
		return usuariosService.contadorTeachers_Active();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/contador_pending")
	public Map<String, Object> contadorUsers_Pending() {
		return usuariosService.contadorUsers_Pending();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/contEst_pending")
	public Map<String, Object> contadorEstudents_Pending() {
		return usuariosService.contadorEstudents_Pending();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY"})
	@GetMapping("/contTeach_pending")
	public Map<String, Object> contadorTeachers_Pending() {
		return usuariosService.contadorTeachers_Pending();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_SECRETARY","ROLE_STUDENT","ROLE_TEACHER","ROLE_DIGETTI"})
	@PutMapping("upd/colores/{id}")
	public int update_colores(@RequestBody Usuarios colores, @PathVariable int id) {
		colores.setIdusuario(id);
		return usuariosService.update_colores(colores);
	}


	
	@Secured({"ROLE_DIGETTI", "ROLE_STUDENT"})
	@PostMapping("/add_user")
	public int create_user(@RequestBody Usuarios users) {
		return usuariosService.create_user(users);
	}		
	
	@Secured({"ROLE_DIGETTI", "ROLE_STUDENT"})
	@PutMapping("/update_user/{id}")
	public int update_user(@RequestBody Usuarios users, @PathVariable int id) {
		users.setIdusuario(id);
		return usuariosService.update_user(users);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_DIGETTI"})
	@GetMapping("/listar")
	public Map<String, Object> listarAll() {
		return usuariosService.listarTodo();

    }
	@Secured({"ROLE_SECRETARY","ROLE_TEACHER", "ROLE_ADMIN", "ROLE_STUDENT" , "ROLE_DIGETTI"})
	@GetMapping("/listar/{id}")
	public Map<String,Object> listar(@PathVariable int id) {
		return usuariosService.listar(id);
	}
	

	@Secured({"ROLE_SECRETARY","ROLE_TEACHER", "ROLE_ADMIN", "ROLE_STUDENT" , "ROLE_DIGETTI"})
	@GetMapping("/listarDatosPersona/{id}")
	public Map<String,Object> listarDatosPersona(@PathVariable int id) {
		return usuariosService.listar_datosPersona(id);
	}

	@GetMapping("/userfoto/{id}")
	public ResponseEntity<Resource> verFotouser(@PathVariable int id){
		Usuarios us = new Usuarios();
		Resource user = null;
		usuariosService.listar(id);
		
		us=usuariosService.listar_foto(id);
		//System.out.println(us);
		String nombreArchivo = us.getFoto();
		Path rutaArchivo = Paths.get(".//src//main//resources//file//usuarios//").resolve(nombreArchivo).toAbsolutePath();	

		
		try {
			user = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!user.exists() && !user.isReadable()) {
			throw new RuntimeException("Error :" + nombreArchivo);
		}
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + user.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(user, cabecera, HttpStatus.OK);
	}
	
	@PostMapping("/subirfoto")
	public ResponseEntity<?> updtefoto(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") int id){
	Map<String, Object> response = new HashMap<>();
	//System.out.println(id+" es el puto id");
	Path rutaArchivo = null;
	String nombreArchivo = null; 
	Usuarios u = new Usuarios();
	u = usuariosService.listar_foto(id);
	//System.out.println(u.getFoto());
	if(!archivo.isEmpty()) {
		
			nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", "");
			rutaArchivo = Paths.get(".//src//main//resources//file//usuarios//").resolve(nombreArchivo).toAbsolutePath();
		
		}
		
		
		try {
			
			Files.copy(archivo.getInputStream(), rutaArchivo);
			usuariosService.UpdateFoto(id, nombreArchivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			response.put("mensaje", "Error al subir la imagen : " +nombreArchivo);
			response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		String nombrefotoanterior = u.getFoto();
				
		//System.out.println("Soy el Id del Usuario"+id);	
		//System.out.println("Soy el archivo "+nombreArchivo);
		if (nombrefotoanterior != null ) {
			Path rutaFotoAnterior = Paths.get(".//src//main//resources//file//usuarios//").resolve(nombrefotoanterior).toAbsolutePath();
			File archivoanterior = rutaFotoAnterior.toFile();
			if (archivoanterior.exists() && archivoanterior.canRead()) {
				archivoanterior.delete();
			}
		}
		
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
}
	

}
