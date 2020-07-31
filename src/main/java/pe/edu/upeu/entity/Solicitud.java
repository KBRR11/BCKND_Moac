package pe.edu.upeu.entity;

public class Solicitud {
	private int idsolicitud;
	private int idusuario;
	private int idconvocatoria;
	private int idconvenio;
	private int tipo;
	public Solicitud() {
		
	}
	
	
	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public Solicitud(int idsolicitud, int idusuario, int idconvocatoria, int idconvenio, int tipo) {
		super();
		this.idsolicitud = idsolicitud;
		this.idusuario = idusuario;
		this.idconvocatoria = idconvocatoria;
		this.idconvenio = idconvenio;
		this.tipo = tipo;
	}


	public int getIdsolicitud() {
		return idsolicitud;
	}
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public int getIdconvocatoria() {
		return idconvocatoria;
	}
	public void setIdconvocatoria(int idconvocatoria) {
		this.idconvocatoria = idconvocatoria;
	}
	public int getIdconvenio() {
		return idconvenio;
	}
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}
	
	
}
