package pe.edu.upeu.entity;

public class Convenios {
	private int idconvenio;
	private String nom_c_ep;
	private int estado;
	private int iduniversidad;
	private String informacion;
	public Convenios() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Convenios(int idconvenio, String nom_c_ep, int estado, int iduniversidad, String informacion) {
		super();
		this.idconvenio = idconvenio;
		this.nom_c_ep = nom_c_ep;
		this.estado = estado;
		this.iduniversidad = iduniversidad;
		this.informacion = informacion;
	}
	@Override
	public String toString() {
		return "Convenios [idconvenio=" + idconvenio + ", nom_c_ep=" + nom_c_ep + ", estado=" + estado
				+ ", iduniversidad=" + iduniversidad + ", informacion=" + informacion + "]";
	}
	public int getIdconvenio() {
		return idconvenio;
	}
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}
	public String getNom_c_ep() {
		return nom_c_ep;
	}
	public void setNom_c_ep(String nom_c_ep) {
		this.nom_c_ep = nom_c_ep;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIduniversidad() {
		return iduniversidad;
	}
	public void setIduniversidad(int iduniversidad) {
		this.iduniversidad = iduniversidad;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	
}
