package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.Rol_UsuarioDao;
import pe.edu.upeu.entity.Rol_Usuario;
import pe.edu.upeu.service.Rol_UsuarioService;

@Service
public class Rol_UsuarioServiceImp implements Rol_UsuarioService{
	@Autowired
	private Rol_UsuarioDao roluserDao;
	
	@Override
	public int create(Rol_Usuario ru) {
		// TODO Auto-generated method stub
		return roluserDao.create(ru);
	}

	@Override
	public int update(Rol_Usuario ru) {
		// TODO Auto-generated method stub
		return roluserDao.update(ru);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return roluserDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return roluserDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return roluserDao.readAll();
	}

}
