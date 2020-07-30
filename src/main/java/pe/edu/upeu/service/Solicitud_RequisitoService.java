package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Solicitud_Requisito;

public interface Solicitud_RequisitoService {
	public int create(Solicitud_Requisito sr);
	public int delete(int idsr);
	public Map<String,Object> read(int idconvenio,int iduser, int idconvo);
}
