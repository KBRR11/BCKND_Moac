package pe.edu.upeu.entity;

public class Convocatoria {
	private int idconvocatoria;
	private String nom_convocatoria;
	private String ciclo_academico;
	private String estado;
	private String desde;
	private String hasta;
	
	public Convocatoria() {
	}

	public Convocatoria(int idconvocatoria, String nom_convocatoria, String ciclo_academico, String estado,
			String desde, String hasta) {
		super();
		this.idconvocatoria = idconvocatoria;
		this.nom_convocatoria = nom_convocatoria;
		this.ciclo_academico = ciclo_academico;
		this.estado = estado;
		this.desde = desde;
		this.hasta = hasta;
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

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	
	
	
}
