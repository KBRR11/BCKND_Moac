package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Solicitud_Requisito;

public interface Requisito_SolicitudDao {
	public int create(Solicitud_Requisito sr);
	public int delete(int idsr);
	public Map<String,Object> read(int idconvenio,int iduser, int idconvo);
}
