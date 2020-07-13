package pe.edu.upeu.serviceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pe.edu.upeu.entity.Recursos;
import pe.edu.upeu.service.RecursoService;
@Service
public class RecursoServiceImp implements RecursoService{
	
	private String folder=".//src//main//resources//file//";
	
	private void savefile(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		if (file.isEmpty()) {
			byte[] bytes = file.getBytes();
			Path path= Paths.get(folder+file.getOriginalFilename());
			Files.write(path, bytes);
		}
	}
	@Override
	public int create(Recursos rec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Recursos rec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idrec) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> read(int idrec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
