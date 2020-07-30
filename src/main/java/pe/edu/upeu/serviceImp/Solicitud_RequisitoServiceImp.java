package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.Requisito_SolicitudDao;
import pe.edu.upeu.entity.Solicitud_Requisito;
import pe.edu.upeu.service.Solicitud_RequisitoService;

@Service
public class Solicitud_RequisitoServiceImp implements Solicitud_RequisitoService{
	@Autowired
	private Requisito_SolicitudDao rsDao;
	@Override
	public int create(Solicitud_Requisito sr) {
		// TODO Auto-generated method stub
		return rsDao.create(sr);
	}

	@Override
	public int delete(int idsr) {
		// TODO Auto-generated method stub
		return rsDao.delete(idsr);
	}

	@Override
	public Map<String, Object> read(int idconvenio,int iduser, int idconvo) {
		// TODO Auto-generated method stub
		return rsDao.read(idconvenio,iduser,idconvo);
	}

}
