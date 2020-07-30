package pe.edu.upeu.dao;

import java.util.Map;

import pe.edu.upeu.entity.Solicitud;

public interface SolicitudDao {
	public int create(Solicitud o);
	public Map<String, Object> read(int idsolicitud);
	public Map<String, Object> readAll();
}
