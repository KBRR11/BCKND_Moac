package pe.edu.upeu.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.dao.PersonasDao;
import pe.edu.upeu.entity.Personas;
import pe.edu.upeu.service.PersonasService;
@Service
public class PersonasServiceImp implements PersonasService{
	@Autowired
	private PersonasDao personasDao;
	@Override
	public int create(Personas per) {
		// TODO Auto-generated method stub
		return personasDao.create(per);
	}

	@Override
	public int update(Personas per) {
		// TODO Auto-generated method stub
		return personasDao.update(per);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return personasDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return personasDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return personasDao.readAll();
	}

	@Override
	public Map<String, Object> findDocumento(String documento) {
		// TODO Auto-generated method stub
		return personasDao.findDocumento(documento);
	}

	@Override
	public Map<String, Object> findAPELLIDOS(String apellido) {
		// TODO Auto-generated method stub
		return personasDao.findAPELLIDOS(apellido);
	}

}
