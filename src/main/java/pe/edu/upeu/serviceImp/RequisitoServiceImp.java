package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.RequisitosDao;
import pe.edu.upeu.entity.Requisitos;
import pe.edu.upeu.service.RequisitosService;

@Service
public class RequisitoServiceImp implements RequisitosService{
	
	@Autowired
	private RequisitosDao requisitosDao;
	@Override
	public int create(Requisitos req) {
		// TODO Auto-generated method stub
		return requisitosDao.create(req);
	}

	@Override
	public int update(Requisitos req) {
		// TODO Auto-generated method stub
		return requisitosDao.update(req);
	}

	@Override
	public int delete(int idreq) {
		// TODO Auto-generated method stub
		return requisitosDao.delete(idreq);
	}

	@Override
	public Map<String, Object> read(int idreq) {
		// TODO Auto-generated method stub
		return requisitosDao.read(idreq);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return requisitosDao.readAll();
	}
	
	@Override
	public Map<String, Object> readConvenios(int idconve) {
		// TODO Auto-generated method stub
		return requisitosDao.readConvenios(idconve);
	}

}
