package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Recursos;

public interface RecursoService {
	public int create(Recursos rec);
	public int update(Recursos rec);
	public int delete(int idrec);
	public Recursos read(int id, int tipo);
	public Map<String, Object> readAll();
	public Recursos rec_listarid(int idr);
	
	public Recursos listar1(int id);
	public Recursos listar2(int id);
	public Recursos listar3(int id);
	public Recursos listar4(int id);
	
}
