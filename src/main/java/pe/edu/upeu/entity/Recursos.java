package pe.edu.upeu.entity;

import java.util.Arrays;

public class Recursos {
	private int idrecurso;
	private String nom_recurso;
	private String ruta;
	private int tipo;
	private int iduniversidad;
	private int idconvocatoria;
	private int idconvenio;
	private int idcambio;

	
	@Override
	public String toString() {
		return "Recursos [idrecurso=" + idrecurso + ", nom_recurso=" + nom_recurso + ", ruta=" + ruta + ", tipo=" + tipo
				+ ", iduniversidad=" + iduniversidad + ", idconvocatoria=" + idconvocatoria + ", idconvenio="
				+ idconvenio + ", idcambio=" + idcambio+"]";
	}

	private byte[] data;
	public Recursos(String nom_recurso, String ruta, int tipo, int iduniversidad, int idconvocatoria, int idconvenio,
			byte[] data) {
		super();
		this.nom_recurso = nom_recurso;
		this.ruta = ruta;
		this.tipo = tipo;
		this.iduniversidad = iduniversidad;
		this.idconvocatoria = idconvocatoria;
		this.idconvenio = idconvenio;
		this.data = data;
	}
	
	public Recursos(int idrecurso, String nom_recurso, String ruta, int tipo) {
		super();
		this.idrecurso = idrecurso;
		this.nom_recurso = nom_recurso;
		this.ruta = ruta;
		this.tipo = tipo;
	}

	public Recursos() {
		// TODO Auto-generated constructor stub
	}
	

	public Recursos(int idrecurso, String nom_recurso, String ruta, int tipo, int iduniversidad, int idconvocatoria,
			int idconvenio) {
		super();
		this.idrecurso = idrecurso;
		this.nom_recurso = nom_recurso;
		this.ruta = ruta;
		this.tipo = tipo;
		this.iduniversidad = iduniversidad;
		this.idconvocatoria = idconvocatoria;
		this.idconvenio = idconvenio;
	}

	public int getIdrecurso() {
		return idrecurso;
	}
	public void setIdrecurso(int idrecurso) {
		this.idrecurso = idrecurso;
	}
	public String getNom_recurso() {
		return nom_recurso;
	}
	public void setNom_recurso(String nom_recurso) {
		this.nom_recurso = nom_recurso;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getIduniversidad() {
		return iduniversidad;
	}
	public void setIduniversidad(int iduniversidad) {
		this.iduniversidad = iduniversidad;
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
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}

	public int getIdcambio() {
		return idcambio;
	}

	public void setIdcambio(int idcambio) {
		this.idcambio = idcambio;
	}
	
}
