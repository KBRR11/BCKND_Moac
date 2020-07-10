package pe.edu.upeu.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

import pe.edu.upeu.entity.Roles;

public interface RolesService {
	public int create(Roles r);
	public int update(Roles r);
	public int delete(int id);
	public Map<String, Object> read(int id);
	public Map<String, Object> readN(String nombre);
	public Map<String, Object> readE(int estado);
	public Map<String, Object> readAll();
	
}
