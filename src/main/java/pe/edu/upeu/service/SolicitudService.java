package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Solicitud;

public interface SolicitudService {
	public int create(Solicitud o);
	public Map<String, Object> read(int idsolicitud);
	public Map<String, Object> readAll();
}
