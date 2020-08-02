package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Solicitud_Requisito;

public interface Requisito_SolicitudDao {
	public int create(Solicitud_Requisito sr);
	public int update(Solicitud_Requisito sr);
	public int delete(int idsr);
	public Solicitud_Requisito listar(int id);
	Map<String, Object> read(int idsolicitud);
}
