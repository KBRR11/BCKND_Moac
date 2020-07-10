package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Facultades;

public interface FacultadesDao {
	public int create(Facultades fac);
	public int update(Facultades fac);
	public int delete(int idfac);
	public Map<String,Object> read(int id);
	public Map<String, Object> readAll();
}
