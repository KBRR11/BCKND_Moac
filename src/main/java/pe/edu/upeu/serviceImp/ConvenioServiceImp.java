package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.ConveniosDao;
import pe.edu.upeu.entity.Convenios;
import pe.edu.upeu.service.ConvenioService;

@Service
public class ConvenioServiceImp implements ConvenioService{
	
	@Autowired
	private ConveniosDao convenioDao;
	@Override
	public int create(Convenios c) {
		// TODO Auto-generated method stub
		return convenioDao.create(c);
	}

	@Override
	public int update(Convenios c) {
		// TODO Auto-generated method stub
		return convenioDao.update(c);
	}

	@Override
	public int delete(int idc) {
		// TODO Auto-generated method stub
		return convenioDao.delete(idc);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return convenioDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return convenioDao.readAll();
	}

	@Override
	public Map<String, Object> listarcursores(int id) {
		// TODO Auto-generated method stub
		return convenioDao.listarcursores(id);
	}

}
