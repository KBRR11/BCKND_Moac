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
import pe.edu.upeu.entity.Usuarios;
import pe.edu.upeu.service.Detalle_ConvocatoriaService;

@RestController
@RequestMapping("/api")
public class Detalle_ConvocatoriaController {
	@Autowired
	private Detalle_ConvocatoriaService detalle_ConvocatoriaService;
	
	@Secured({"ROLE_STUDENT","ROLE_DIRECTOR","ROLE_SECRETARY"})
	@PostMapping("/detconvocatoria/add")
	public int create(@RequestBody Detalle_Convocatoria detconv) {
		return detalle_ConvocatoriaService.create(detconv);

	}
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@PostMapping("/detconvocatoria/escuela/add")
	public int create_detalleescuela(@RequestBody Detalle_Convocatoria detconv) {
		return detalle_ConvocatoriaService.crear_escuela(detconv);

	}
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@PutMapping("detconvocatoria/upd/{id}")
	public int update(@RequestBody Detalle_Convocatoria detconv, @PathVariable int id ) {
		detconv.setIdetalle_convocatoria(id);
		System.out.println(detconv.toString());
		return detalle_ConvocatoriaService.update(detconv);
	}
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@DeleteMapping("detconvocatoria/del/{id}")
	public int delete(@PathVariable int id) {
		return detalle_ConvocatoriaService.delete(id);
	}
	@Secured({"ROLE_STUDENT","ROLE_DIRECTOR","ROLE_SECRETARY"})
	@GetMapping("detconvocatoria/{id}/{tipo}/{idep}")
	public Map<String,Object> read(@PathVariable int id,@PathVariable int tipo, @PathVariable int idep) {
		return detalle_ConvocatoriaService.read(id, tipo, idep);
	}
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@GetMapping("detconvocatoria/alum/{id}")
	public Map<String,Object> readAlumnoByIdconv(@PathVariable int id) {
		return detalle_ConvocatoriaService.readAlumnoByIdconv(id);
	}
	@Secured({"ROLE_DIRECTOR","ROLE_SECRETARY"})
	@GetMapping("detconvocatoria/user/{id}")
	public Usuarios user_ides(@PathVariable int id) {
		return detalle_ConvocatoriaService.listar_us(id);
	}
	@Secured({"ROLE_STUDENT","ROLE_DIRECTOR","ROLE_SECRETARY"})
	@GetMapping("detconvocatoria/vacante/{idc}/{ide}")
	public Map<String,Object> listar_vacantes(@PathVariable int idc,@PathVariable int ide) {
		return detalle_ConvocatoriaService.vervacante(idc, ide);
	}
	@Secured({"ROLE_STUDENT","ROLE_DIRECTOR","ROLE_SECRETARY"})
	@PutMapping("detconvocatoria/vacante/{idc}/{ide}/{n_v}")
	public int actualizar_vac(@PathVariable int idc,@PathVariable int ide, @PathVariable int n_v) {
		return detalle_ConvocatoriaService.actualizar_vacante(idc, ide, n_v);
	}
}
