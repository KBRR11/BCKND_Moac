package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Personas;



public interface PersonasDao {

	public int create(Personas per);
	public int update(Personas per);
	public int delete(int id);
	public Map<String,Object> read(int id);
	public Map<String, Object> readAll();
	public Map<String, Object> findDocumento(String documento);
	public Map<String, Object> findAPELLIDOS(String apellido);
}
