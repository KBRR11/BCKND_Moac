package pe.edu.upeu.entity;

public class Solicitud_Requisito {
	private int idrequisito;
	private int idsolicitud; 
	private String ruta;
	private String estado;
	private int idrequisito_solicitud;
	public Solicitud_Requisito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Solicitud_Requisito(int idrequisito, int idsolicitud, String ruta, String estado,
			int idrequisito_solicitud) {
		super();
		this.idrequisito = idrequisito;
		this.idsolicitud = idsolicitud;
		this.ruta = ruta;
		this.estado = estado;
		this.idrequisito_solicitud = idrequisito_solicitud;
	}
	public int getIdrequisito() {
		return idrequisito;
	}
	public void setIdrequisito(int idrequisito) {
		this.idrequisito = idrequisito;
	}
	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdrequisito_solicitud() {
		return idrequisito_solicitud;
	}
	public void setIdrequisito_solicitud(int idrequisito_solicitud) {
		this.idrequisito_solicitud = idrequisito_solicitud;
	}
	
}
