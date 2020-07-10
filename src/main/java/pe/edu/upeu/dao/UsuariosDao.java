package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Usuarios;

public interface UsuariosDao {

	public int create_estudiante(Usuarios users);
	public int create_docente(Usuarios users);
	public int create_user_especial(Usuarios users);
	public Map<String, Object> readAll_Active();
	public Map<String, Object> readAll_Pending();
	public Map<String, Object> readAll_Students();
	public Map<String, Object> readAll_Teachers();
	public int update_nomUser(Usuarios usuario);
	public int update_password(Usuarios password);
	public int update_sede(Usuarios sede);
	public int update_ciclo(Usuarios ciclo);
	public int desactivar_user(int id);
	public int activar_user(int id);
	public int delete(int id);
	public Map<String,Object> readName(String nameUser);
	public Map<String,Object> readCodigo(String codigo);
	public Map<String, Object> contadorUsers_Active();
	public Map<String, Object> contadorUsers_Pending();
	public int update_colores(Usuarios colores);
	Usuarios validarUsuario(String username);
	Map<String, Object> datosUsuario(String username);
}
