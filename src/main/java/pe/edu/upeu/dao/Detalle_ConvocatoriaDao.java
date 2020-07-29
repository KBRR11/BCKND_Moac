package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Detalle_Convocatoria;
import pe.edu.upeu.entity.Usuarios;

public interface Detalle_ConvocatoriaDao {
	public int create(Detalle_Convocatoria detconv);
	public int update(Detalle_Convocatoria detconv);
	public int delete(int iddetconv);
	public Map<String,Object> read(int idconv, int tipo, int idep);
	public Map<String,Object> readAlumnoByIdconv(int idconv);
	public int crear_escuela(Detalle_Convocatoria detconv);
	public Usuarios listar_us(int id);
	public Map<String, Object> vervacante(int idc, int ide);
	public int actualizar_vacante(int idc, int ide, int n_v);
}
