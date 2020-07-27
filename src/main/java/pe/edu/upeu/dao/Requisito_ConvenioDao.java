package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Requisito_Convenio;

public interface Requisito_ConvenioDao {
	public int create(Requisito_Convenio rc);
	public int update(Requisito_Convenio rc);
	public Map<String, Object> read(int idco, int idre);
	
}
