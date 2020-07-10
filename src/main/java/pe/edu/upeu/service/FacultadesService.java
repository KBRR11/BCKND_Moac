package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Facultades;

public interface FacultadesService {
	public int create(Facultades fac);
	public int update(Facultades fac);
	public int delete(int idfac);
	public Map<String,Object> read(int id);
	public Map<String, Object> readAll();
}
