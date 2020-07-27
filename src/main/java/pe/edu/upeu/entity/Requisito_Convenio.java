package pe.edu.upeu.entity;

public class Requisito_Convenio {
	private int idrequisito_convenio;
	private int idrequisito;
	private int idconvenio;
	private String estado;
	public Requisito_Convenio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Requisito_Convenio(int idrequisito_convenio, int idrequisito, int idconvenio, String estado) {
		super();
		this.idrequisito_convenio = idrequisito_convenio;
		this.idrequisito = idrequisito;
		this.idconvenio = idconvenio;
		this.estado = estado;
	}
	public int getIdrequisito_convenio() {
		return idrequisito_convenio;
	}
	public void setIdrequisito_convenio(int idrequisito_convenio) {
		this.idrequisito_convenio = idrequisito_convenio;
	}
	public int getIdrequisito() {
		return idrequisito;
	}
	public void setIdrequisito(int idrequisito) {
		this.idrequisito = idrequisito;
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
