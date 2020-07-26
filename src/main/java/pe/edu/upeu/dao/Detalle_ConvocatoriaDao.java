package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Detalle_Convocatoria;

public interface Detalle_ConvocatoriaDao {
	public int create(Detalle_Convocatoria detconv);
	public int update(Detalle_Convocatoria detconv);
	public int delete(int iddetconv);
	public Map<String,Object> read(int idconv);
	public Map<String,Object> readAlumnoByIdconv(int idconv);
	public int crear_escuela(Detalle_Convocatoria detconv);
}
