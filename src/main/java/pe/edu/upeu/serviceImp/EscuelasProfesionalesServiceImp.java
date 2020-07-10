package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.EscuelasProfesionalesDao;
import pe.edu.upeu.entity.EscuelasProfesionales;
import pe.edu.upeu.service.EscuelasProfesionalesService;

@Service
public class EscuelasProfesionalesServiceImp implements EscuelasProfesionalesService{
	@Autowired
	private EscuelasProfesionalesDao escuelasDao;
	@Override
	public int create(EscuelasProfesionales escuelas) {
		// TODO Auto-generated method stub
		return escuelasDao.create(escuelas);
	}

	@Override
	public int update(EscuelasProfesionales escuelas) {
		// TODO Auto-generated method stub
		return escuelasDao.update(escuelas);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return escuelasDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return escuelasDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return escuelasDao.readAll();
	}

	@Override
	public Map<String, Object> readEpForFAC(int id) {
		// TODO Auto-generated method stub
		return escuelasDao.readEpForFAC(id);
	}
	
}
