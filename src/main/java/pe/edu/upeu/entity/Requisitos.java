package pe.edu.upeu.entity;

public class Requisitos {
	private int idrequisito;
	private String nombre;
	private int idconvenio;
	private String estado;
	public Requisitos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Requisitos(int idrequisito, String nombre, int idconvenio, String estado) {
		super();
		this.idrequisito = idrequisito;
		this.nombre = nombre;
		this.idconvenio = idconvenio;
		this.estado = estado;
	}
	public int getIdrequisito() {
		return idrequisito;
	}
	public void setIdrequisito(int idrequisito) {
		this.idrequisito = idrequisito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdconvenio() {
		return idconvenio;
	}
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
