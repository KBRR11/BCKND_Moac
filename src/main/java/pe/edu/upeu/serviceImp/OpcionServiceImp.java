package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.OpcionDao;
import pe.edu.upeu.entity.Opcion;
import pe.edu.upeu.service.OpcionService;

@Service
public class OpcionServiceImp implements OpcionService{
	@Autowired
	private OpcionDao opcionDao;
	@Override
	public int create(Opcion o) {
		// TODO Auto-generated method stub
		return opcionDao.create(o);
	}

	@Override
	public int update(Opcion o) {
		// TODO Auto-generated method stub
		return opcionDao.update(o);
	}

	@Override
	public int delete(int o) {
		// TODO Auto-generated method stub
		return opcionDao.delete(o);
	}

	@Override
	public Map<String, Object> read(int idopcion) {
		// TODO Auto-generated method stub
		return opcionDao.read(idopcion);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return opcionDao.readAll();
	}

}
