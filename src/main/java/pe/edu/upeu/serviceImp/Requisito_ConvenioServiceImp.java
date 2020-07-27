package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.Requisito_ConvenioDao;
import pe.edu.upeu.entity.Requisito_Convenio;
import pe.edu.upeu.service.Requisito_ConvenioService;

@Service
public class Requisito_ConvenioServiceImp implements Requisito_ConvenioService{
	
	@Autowired
	private Requisito_ConvenioDao requisito_convenioDao;
	
	@Override
	public int create(Requisito_Convenio rc) {
		// TODO Auto-generated method stub
		return requisito_convenioDao.create(rc);
	}

	@Override
	public int update(Requisito_Convenio rc) {
		// TODO Auto-generated method stub
		return requisito_convenioDao.update(rc);
	}

	@Override
	public Map<String, Object> read(int idco, int idre) {
		// TODO Auto-generated method stub
		return requisito_convenioDao.read(idco, idre);
	}

}
