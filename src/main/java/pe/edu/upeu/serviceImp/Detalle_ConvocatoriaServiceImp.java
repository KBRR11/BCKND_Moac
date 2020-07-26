package pe.edu.upeu.serviceImp;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.Detalle_ConvocatoriaDao;
import pe.edu.upeu.entity.Detalle_Convocatoria;
import pe.edu.upeu.service.Detalle_ConvocatoriaService;
@Service
public class Detalle_ConvocatoriaServiceImp implements Detalle_ConvocatoriaService{
	
	@Autowired
	private Detalle_ConvocatoriaDao convocatoriaDao;
	@Override
	public int create(Detalle_Convocatoria detconv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.create(detconv);
	}

	@Override
	public int update(Detalle_Convocatoria detconv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.update(detconv);
	}

	@Override
	public int delete(int iddetconv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.delete(iddetconv);
	}

	@Override
	public Map<String, Object> read(int idconv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.read(idconv);
	}

	@Override
	public Map<String, Object> readAlumnoByIdconv(int idconv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.readAlumnoByIdconv(idconv);
	}

	@Override
	public int crear_escuela(Detalle_Convocatoria detconv) {
		// TODO Auto-generated method stub
		return convocatoriaDao.crear_escuela(detconv);
	}

}
