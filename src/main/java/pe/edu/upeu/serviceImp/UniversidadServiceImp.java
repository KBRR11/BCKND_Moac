package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.UniversidadDao;
import pe.edu.upeu.entity.Universidad;
import pe.edu.upeu.service.UniversidadService;

@Service
public class UniversidadServiceImp implements UniversidadService{
	@Autowired
	private UniversidadDao universidadDao;
	@Override
	public int create(Universidad uni) {
		// TODO Auto-generated method stub
		return universidadDao.create(uni);
	}

	@Override
	public int update(Universidad uni) {
		// TODO Auto-generated method stub
		return universidadDao.update(uni);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return universidadDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return universidadDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return universidadDao.readAll();
	}

}
