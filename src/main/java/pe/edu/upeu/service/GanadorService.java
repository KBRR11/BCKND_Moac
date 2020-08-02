package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Ganador;

public interface GanadorService {
	public int create(Ganador win);
	public int update(Ganador win);
	public int delete(int id);
	public Map<String,Object> read(int id_dc, int ide);
	public Map<String, Object> readAll(int id_dc);
}
