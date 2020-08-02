package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Facultades;
import pe.edu.upeu.entity.Ganador;

public interface GanadorDao {
	public int create(Ganador win);
	public int update(Ganador win);
	public int delete(int id);
	public Map<String,Object> read(int id_dc, int ide);
	public Map<String, Object> readAll(int id_dc);
}
