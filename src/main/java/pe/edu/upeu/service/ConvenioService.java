package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Convenios;

public interface ConvenioService {
	public int create(Convenios c);
	public int update(Convenios c);
	public int delete(int idc);
	public Map<String,Object> read(int id);
	public Map<String, Object> readAll();
	public Map<String,Object> validador(int idconvenio,int idusuarui);
	public Map<String, Object> listarcursores(int id);
}
