package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.SolicitudDao;
import pe.edu.upeu.entity.Solicitud;
import pe.edu.upeu.service.SolicitudService;

@Service
public class SolicitudServiceImp implements SolicitudService{
	@Autowired
	private SolicitudDao solicitudDao;
	@Override
	public int create(Solicitud o) {
		// TODO Auto-generated method stub
		return solicitudDao.create(o);
	}

	@Override
	public Map<String, Object> read(int idsolicitud) {
		// TODO Auto-generated method stub
		return solicitudDao.read(idsolicitud);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return solicitudDao.readAll();
	}

}
