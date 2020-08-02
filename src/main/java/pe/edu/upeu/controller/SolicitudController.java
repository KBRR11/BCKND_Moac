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
		System.out.println(req.getIdconvocatoria());
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
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/readConv/{idusuario}")
	public Map<String,Object> readConv(@PathVariable int idusuario) {
		return sService.readConv(idusuario);
	}
	//buscar solicitud
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/readSolicitud_Convocatoria/{idso}")
	public Map<String,Object> readSolicitud_Convocatoria(@PathVariable int idso) {
		return sService.readSolicitud_Convocatoria(idso);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/solicitud_deta_convo/{iduser}/{idconvo}/{idunie}")
	public Map<String,Object> readSolicitudDetalleCatoria(@PathVariable int iduser,@PathVariable int idconvo,@PathVariable int idunie) {
		return sService.readSolicitudDetalleCatoria(iduser, idconvo, idunie);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/read_ConvaActiva/{iduser}")
	public Map<String,Object> read_ConvaActiva(@PathVariable int iduser) {
		return sService.read_ConvaActiva(iduser);
	}
	
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/listarUniversidad/{iduser}")
	public Map<String,Object> listarUniversidad(@PathVariable int iduser) {
		return sService.listar_uni(iduser);
	}
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/secre_uni/{idconvocatoria}")
	public Map<String,Object> uni_secre(@PathVariable int idconvocatoria) {
		return sService.uni_secre(idconvocatoria);
	}
	@Secured({"ROLE_STUDENT","ROLE_SECRETARY"})
	@GetMapping("/solicitudes_direc/{idescuela}/{idconvo}")
	public Map<String,Object> solicitudes_direc(@PathVariable int idescuela,@PathVariable int idconvo) {
		return sService.solicitudes_direc(idescuela, idconvo);
	}
	
}
