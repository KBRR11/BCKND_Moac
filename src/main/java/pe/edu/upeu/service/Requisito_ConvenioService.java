package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Requisito_Convenio;

public interface Requisito_ConvenioService {
	public int create(Requisito_Convenio rc);
	public int update(Requisito_Convenio rc);
	public Map<String, Object> read(int idco, int idre);
}
