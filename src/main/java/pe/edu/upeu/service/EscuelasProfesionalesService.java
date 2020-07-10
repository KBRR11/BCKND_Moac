package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.EscuelasProfesionales;

public interface EscuelasProfesionalesService {
	public int create(EscuelasProfesionales escuelas);
	public int update(EscuelasProfesionales escuelas);
	public int delete(int id);
	public Map<String, Object> read(int id);
	public Map<String, Object> readAll();
	public Map<String, Object> readEpForFAC(int id);
}
