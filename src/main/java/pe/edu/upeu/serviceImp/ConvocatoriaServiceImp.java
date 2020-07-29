package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.ConvocatoriaDao;
import pe.edu.upeu.entity.Convocatoria;
import pe.edu.upeu.service.ConvocatoriaService;

@Service
public class ConvocatoriaServiceImp implements ConvocatoriaService {
	
	@Autowired
	private ConvocatoriaDao convocatoriaDao;
	@Override
	public int create(Convocatoria conv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.create(conv);
	}

	@Override
	public int update(Convocatoria conv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.update(conv);
	}

	@Override
	public int delete(int idconv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.delete(idconv);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return convocatoriaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll(int tipo) {
		// TODO Auto-generated method stub
		return convocatoriaDao.readAll(tipo);
	}

}
