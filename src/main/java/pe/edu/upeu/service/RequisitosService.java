package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Requisitos;

public interface RequisitosService {
	public int create(Requisitos req);
	public int update(Requisitos req);
	public int delete(int idreq);
	public Map<String,Object> read(int idreq);
	public Map<String, Object> readAll();
	public Map<String,Object> readConvenios(int idconve,int ide);
	public Map<String,Object> readConvenios2(int idconve,int ide);
	public Requisitos listarArchivo(int id);

}
