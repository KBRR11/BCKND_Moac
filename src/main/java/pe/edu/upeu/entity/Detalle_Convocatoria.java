package pe.edu.upeu.entity;

public class Detalle_Convocatoria {
	private int idetalle_convocatoria;
	private int idconvocatoria;
	private int idescuela;
	private int idconvenio;
	private int n_vacantes;
	
	public Detalle_Convocatoria() {
	}
	
	public Detalle_Convocatoria(int idetalle_convocatoria, int idconvocatoria, int idescuela, int idconvenio,
			int n_vacantes) {
		super();
		this.idetalle_convocatoria = idetalle_convocatoria;
		this.idconvocatoria = idconvocatoria;
		this.idescuela = idescuela;
		this.idconvenio = idconvenio;
		this.n_vacantes = n_vacantes;
	}

	public int getIdetalle_convocatoria() {
		return idetalle_convocatoria;
	}



	public void setIdetalle_convocatoria(int idetalle_convocatoria) {
		this.idetalle_convocatoria = idetalle_convocatoria;
	}



	public int getIdconvocatoria() {
		return idconvocatoria;
	}



	public void setIdconvocatoria(int idconvocatoria) {
		this.idconvocatoria = idconvocatoria;
	}



	public int getIdescuela() {
		return idescuela;
	}



	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}



	public int getIdconvenio() {
		return idconvenio;
	}



	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}



	public int getN_vacantes() {
		return n_vacantes;
	}



	public void setN_vacantes(int n_vacantes) {
		this.n_vacantes = n_vacantes;
	}

	
}
