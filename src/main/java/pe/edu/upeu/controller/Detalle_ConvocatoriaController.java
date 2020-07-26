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

import pe.edu.upeu.entity.Detalle_Convocatoria;
import pe.edu.upeu.service.Detalle_ConvocatoriaService;

@RestController
@RequestMapping("/api")
public class Detalle_ConvocatoriaController {
	@Autowired
	private Detalle_ConvocatoriaService detalle_ConvocatoriaService;
	
	@Secured({"ROLE_STUDENT"})
	@PostMapping("/detconvocatoria/add")
	public int create(@RequestBody Detalle_Convocatoria detconv) {
		return detalle_ConvocatoriaService.create(detconv);

	}
	@Secured({"ROLE_STUDENT"})
	@PostMapping("/detconvocatoria/escuela/add")
	public int create_detalleescuela(@RequestBody Detalle_Convocatoria detconv) {
		return detalle_ConvocatoriaService.crear_escuela(detconv);

	}
	@Secured({"ROLE_STUDENT"})
	@PutMapping("detconvocatoria/upd/{id}")
	public int update(@RequestBody Detalle_Convocatoria detconv, @PathVariable int id ) {
		detconv.setIdetalle_convocatoria(id);
		System.out.println(detconv.toString());
		return detalle_ConvocatoriaService.update(detconv);
	}
	@Secured({"ROLE_STUDENT"})
	@DeleteMapping("detconvocatoria/del/{id}")
	public int delete(@PathVariable int id) {
		return detalle_ConvocatoriaService.delete(id);
	}
	@Secured({"ROLE_STUDENT"})
	@GetMapping("detconvocatoria/{id}")
	public Map<String,Object> read(@PathVariable int id) {
		return detalle_ConvocatoriaService.read(id);
	}
	@Secured({"ROLE_STUDENT"})
	@GetMapping("detconvocatoria/alum/{id}")
	public Map<String,Object> readAlumnoByIdconv(@PathVariable int id) {
		return detalle_ConvocatoriaService.readAlumnoByIdconv(id);
	}
}
