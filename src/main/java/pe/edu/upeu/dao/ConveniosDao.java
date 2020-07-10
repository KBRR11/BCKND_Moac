package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Convenios;


public interface ConveniosDao {
	public int create(Convenios c);
	public int update(Convenios c);
	public int delete(int idc);
	public Map<String,Object> read(int id);
	public Map<String, Object> readAll();
}
