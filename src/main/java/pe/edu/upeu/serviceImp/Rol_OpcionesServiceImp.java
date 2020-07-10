package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.Rol_OpcionesDao;
import pe.edu.upeu.entity.Rol_Opciones;
import pe.edu.upeu.service.Rol_OpcionesService;
@Service
public class Rol_OpcionesServiceImp implements Rol_OpcionesService {
	@Autowired
	private Rol_OpcionesDao rol_OpcionesDao;
	@Override
	public int create(Rol_Opciones RO) {
		// TODO Auto-generated method stub
		return rol_OpcionesDao.create(RO);
	}

	@Override
	public int update(Rol_Opciones RO) {
		// TODO Auto-generated method stub
		return rol_OpcionesDao.update(RO);
	}

	@Override
	public int delete(int idRO) {
		// TODO Auto-generated method stub
		return rol_OpcionesDao.delete(idRO);
	}

	@Override
	public Map<String, Object> readByRol(int idorl) {
		// TODO Auto-generated method stub
		return rol_OpcionesDao.readByRol(idorl);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return rol_OpcionesDao.readAll() ;
	}

}
