package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Recursos;

public interface RecurosoDao {
	public int create(Recursos rec);
	public int update(Recursos rec);
	public int delete(int idrec);
	public Map<String,Object> read(int idrec);
	public Map<String, Object> readAll();
}
