package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Opcion;

public interface OpcionDao{
	public int create(Opcion o);
	public int update(Opcion o);
	public int delete(int o);
	public Map<String, Object> read(int idopcion);
	public Map<String, Object> readAll();
	public Map<String, Object> cargarOpciones(String nom_rol);
}
