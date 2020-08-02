package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.GanadorDao;
import pe.edu.upeu.entity.Ganador;
import pe.edu.upeu.service.GanadorService;

@Service
public class GanadorServiceImp implements GanadorService{
	@Autowired
	private GanadorDao ganadorDao;
	@Override
	public int create(Ganador win) {
		// TODO Auto-generated method stub
		return ganadorDao.create(win);
	}

	@Override
	public int update(Ganador win) {
		// TODO Auto-generated method stub
		return ganadorDao.update(win);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return ganadorDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id_dc, int ide) {
		// TODO Auto-generated method stub
		return ganadorDao.read(id_dc, ide);
	}

	@Override
	public Map<String, Object> readAll(int id_dc) {
		// TODO Auto-generated method stub
		return ganadorDao.readAll(id_dc);
	}
	
}
