package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.FacultadesDao;
import pe.edu.upeu.entity.Facultades;
import pe.edu.upeu.service.FacultadesService;

@Service
public class FacultadesServiceImp implements FacultadesService{
	
	@Autowired
	private FacultadesDao facultadesDao;
	@Override
	public int create(Facultades fac) {
		// TODO Auto-generated method stub
		return facultadesDao.create(fac);
	}

	@Override
	public int update(Facultades fac) {
		// TODO Auto-generated method stub
		return facultadesDao.update(fac);
	}

	@Override
	public int delete(int idfac) {
		// TODO Auto-generated method stub
		return facultadesDao.delete(idfac);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return facultadesDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return facultadesDao.readAll();
	}
	
	
}
