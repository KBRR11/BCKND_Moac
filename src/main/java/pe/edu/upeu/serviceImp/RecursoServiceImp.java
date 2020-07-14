package pe.edu.upeu.serviceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pe.edu.upeu.dao.RecursosDao;
import pe.edu.upeu.entity.Recursos;
import pe.edu.upeu.service.RecursoService;
@Service
public class RecursoServiceImp implements RecursoService{
	
	private String folder=".//src//main//resources//file//";
	
	@Autowired
	private RecursosDao recursoDao;
	
	@Override
	public int create(Recursos rec) {
		// TODO Auto-generated method stub
		return recursoDao.create(rec);
	}

	@Override
	public int update(Recursos rec) {
		// TODO Auto-generated method stub
		return recursoDao.update(rec);
	}

	@Override
	public int delete(int idrec) {
		// TODO Auto-generated method stub
		return recursoDao.delete(idrec);
	}

	@Override
	public Map<String, Object> read(int idrec) {
		// TODO Auto-generated method stub
		return recursoDao.read(idrec);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return recursoDao.readAll();
	}

	@Override
	public Recursos rec_listarid(int idr) {
		// TODO Auto-generated method stub
		return recursoDao.rec_listarid(idr);
	}

}
