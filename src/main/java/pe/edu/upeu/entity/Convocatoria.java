package pe.edu.upeu.entity;

public class Convocatoria {
	private int idconvocatoria;
	private String nom_convocatoria;
	private String info_convocatoria;
	private int n_vacantes;
	private String ciclo_academico;
	private String estado;
	public Convocatoria() {
	}
	public Convocatoria(int idconvocatoria, String nom_convocatoria, String info_convocatoria, int n_vacantes,
			String ciclo_academico, String estado) {

		this.idconvocatoria = idconvocatoria;
		this.nom_convocatoria = nom_convocatoria;
		this.info_convocatoria = info_convocatoria;
		this.n_vacantes = n_vacantes;
		this.ciclo_academico = ciclo_academico;
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Convocatoria [idconvocatoria=" + idconvocatoria + ", nom_convocatoria=" + nom_convocatoria
				+ ", info_convocatoria=" + info_convocatoria + ", n_vacantes=" + n_vacantes + ", cicloacademico="
				+ ciclo_academico + ", estado=" + estado + "]";
	}
	public int getIdconvocatoria() {
		return idconvocatoria;
	}
	public void setIdconvocatoria(int idconvocatoria) {
		this.idconvocatoria = idconvocatoria;
	}
	public String getNom_convocatoria() {
		return nom_convocatoria;
	}
	public void setNom_convocatoria(String nom_convocatoria) {
		this.nom_convocatoria = nom_convocatoria;
	}
	public String getInfo_convocatoria() {
		return info_convocatoria;
	}
	public void setInfo_convocatoria(String info_convocatoria) {
		this.info_convocatoria = info_convocatoria;
	}
	
	public int getN_vacantes() {
		return n_vacantes;
	}
	public void setN_vacantes(int n_vacantes) {
		this.n_vacantes = n_vacantes;
	}
	public String getCiclo_academico() {
		return ciclo_academico;
	}
	public void setCiclo_academico(String ciclo_academico) {
		this.ciclo_academico = ciclo_academico;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
