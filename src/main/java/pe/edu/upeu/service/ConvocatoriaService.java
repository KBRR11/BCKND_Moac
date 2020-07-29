package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Convocatoria;

public interface ConvocatoriaService {
	public int create(Convocatoria conv);
	public int update(Convocatoria conv);
	public int delete(int idconv);
	public Map<String,Object> readAll(int tipo);
	public Map<String,Object> read(int id);
}
