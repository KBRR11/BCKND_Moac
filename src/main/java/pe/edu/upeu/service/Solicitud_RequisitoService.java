package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Solicitud_Requisito;

public interface Solicitud_RequisitoService {
	public int create(Solicitud_Requisito sr);
	public int update(Solicitud_Requisito sr);
	public int delete(int idsr);
	public Solicitud_Requisito listar(int id);
	Map<String, Object> read(int idsolicitud);
}
