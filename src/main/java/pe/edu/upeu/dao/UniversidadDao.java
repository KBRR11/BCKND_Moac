package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Universidad;

public interface UniversidadDao {
	public int create(Universidad uni);
	public int update(Universidad uni);
	public int delete(int id);
	public Map<String, Object> read(int id);
	public Map<String, Object> readAll();
}
