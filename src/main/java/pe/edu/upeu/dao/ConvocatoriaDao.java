package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Convocatoria;

public interface ConvocatoriaDao {
	public int create(Convocatoria conv);
	public int update(Convocatoria conv);
	public int delete(int idconv);
	public Map<String,Object> readAll(int tipo);
	public Map<String,Object> read(int id);
}
