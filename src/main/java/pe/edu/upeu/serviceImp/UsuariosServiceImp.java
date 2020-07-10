package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.UsuariosDao;
import pe.edu.upeu.entity.Usuarios;
import pe.edu.upeu.service.UsuariosService;

@Service
public class UsuariosServiceImp implements UsuariosService {
	@Autowired
	private UsuariosDao usuariosDao;
	@Override
	public int create_estudiante(Usuarios users) {
		// TODO Auto-generated method stub
		return usuariosDao.create_estudiante(users);
	}

	@Override
	public int create_docente(Usuarios users) {
		// TODO Auto-generated method stub
		return usuariosDao.create_docente(users);
	}

	@Override
	public int create_user_especial(Usuarios users) {
		// TODO Auto-generated method stub
		return usuariosDao.create_user_especial(users);
	}

	@Override
	public Map<String, Object> readAll_Active() {
		// TODO Auto-generated method stub
		return usuariosDao.readAll_Active();
	}

	@Override
	public Map<String, Object> readAll_Pending() {
		// TODO Auto-generated method stub
		return usuariosDao.readAll_Pending();
	}

	@Override
	public Map<String, Object> readAll_Students() {
		// TODO Auto-generated method stub
		return usuariosDao.readAll_Students();
	}

	@Override
	public Map<String, Object> readAll_Teachers() {
		// TODO Auto-generated method stub
		return usuariosDao.readAll_Teachers();
	}

	@Override
	public int update_nomUser(Usuarios usuario) {
		// TODO Auto-generated method stub
		return usuariosDao.update_nomUser(usuario);
	}

	@Override
	public int update_password(Usuarios password) {
		// TODO Auto-generated method stub
		return usuariosDao.update_password(password);
	}

	@Override
	public int update_sede(Usuarios sede) {
		// TODO Auto-generated method stub
		return usuariosDao.update_sede(sede);
	}
	@Override
	public int update_ciclo(Usuarios ciclo) {
		// TODO Auto-generated method stub
		return usuariosDao.update_ciclo(ciclo);
	}

	@Override
	public int desactivar_user(int id) {
		// TODO Auto-generated method stub
		return usuariosDao.desactivar_user(id);
	}

	@Override
	public int activar_user(int id) {
		// TODO Auto-generated method stub
		return usuariosDao.activar_user(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return usuariosDao.delete(id);
	}

	@Override
	public Map<String, Object> readName(String nameUser) {
		// TODO Auto-generated method stub
		return usuariosDao.readName(nameUser);
	}

	@Override
	public Map<String, Object> readCodigo(String codigo) {
		// TODO Auto-generated method stub
		return usuariosDao.readCodigo(codigo);
	}

	@Override
	public Map<String, Object> contadorUsers_Active() {
		// TODO Auto-generated method stub
		return usuariosDao.contadorUsers_Active();
	}

	@Override
	public Map<String, Object> contadorUsers_Pending() {
		// TODO Auto-generated method stub
		return usuariosDao.contadorUsers_Pending();
	}

	@Override
	public int update_colores(Usuarios colores) {
		// TODO Auto-generated method stub
		return usuariosDao.update_colores(colores);
	}

}
