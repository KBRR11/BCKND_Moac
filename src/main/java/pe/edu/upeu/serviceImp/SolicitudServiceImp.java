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

	@Override
	public Map<String, Object> readSolicitud_Convocatoria(int idsolicitud) {
		// TODO Auto-generated method stub
		return solicitudDao.readSolicitud_Convocatoria(idsolicitud);
	}

	@Override
	public Map<String, Object> readConv(int idusuario) {
		// TODO Auto-generated method stub
		return solicitudDao.readConv(idusuario);
	}

	@Override
	public Map<String, Object> readSolicitudDetalleCatoria(int idusuario, int idconvocatoria, int iduniversidaduser) {
		// TODO Auto-generated method stub
		return solicitudDao.readSolicitudDetalleCatoria(idusuario, idconvocatoria, iduniversidaduser);
	}

	@Override
	public Map<String, Object> read_ConvaActiva(int iduser) {
		// TODO Auto-generated method stub
		return solicitudDao.read_ConvaActiva(iduser);
	}

	@Override
	public Map<String, Object> listar_uni(int iduser) {
		// TODO Auto-generated method stub
		return solicitudDao.listar_uni(iduser);
	}

	@Override
	public Map<String, Object> uni_secre(int idconvocatoria) {
		// TODO Auto-generated method stub
		return solicitudDao.uni_secre(idconvocatoria);
	}

	@Override
	public Map<String, Object> solicitudes_direc(int idescuela, int idconvo) {
		// TODO Auto-generated method stub
		return solicitudDao.solicitudes_direc(idescuela, idconvo);
	}

}
