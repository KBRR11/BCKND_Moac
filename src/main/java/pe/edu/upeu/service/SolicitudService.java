package pe.edu.upeu.service;

import java.util.Map;

import pe.edu.upeu.entity.Solicitud;

public interface SolicitudService {
	public int create(Solicitud o);
	public Map<String, Object> read(int idsolicitud);
	public Map<String, Object> readConv(int idusuario);
	public Map<String, Object> readSolicitud_Convocatoria(int idsolicitud);
	public Map<String, Object> readSolicitudDetalleCatoria(int idusuario,int idconvocatoria,int iduniversidaduser);
	public Map<String, Object> readAll();
	public Map<String, Object> read_ConvaActiva(int iduser);
	public Map<String, Object> listar_uni(int iduser);
}
