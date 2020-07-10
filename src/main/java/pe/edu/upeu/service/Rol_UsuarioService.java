package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Rol_Usuario;

public interface Rol_UsuarioService {
	public int create(Rol_Usuario ru);
	public int update(Rol_Usuario ru);
	public int delete(int id);
	public Map<String, Object> read(int id);
	public Map<String, Object> readAll();
}
