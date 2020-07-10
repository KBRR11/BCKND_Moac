package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Rol_Opciones;

public interface Rol_OpcionesDao {
	public int create(Rol_Opciones RO);
	public int update(Rol_Opciones RO);
	public int delete(int idRO);
	public Map<String, Object> readByRol(int idorl);
	public Map<String, Object> readAll();
}
