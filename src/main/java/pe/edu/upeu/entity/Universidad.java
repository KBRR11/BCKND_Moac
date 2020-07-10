package pe.edu.upeu.entity;

public class Universidad {
	private int iduniversidad;
	private String nom_universidad;
	private String pais;
	
	public Universidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Universidad(int iduniversidad, String nom_universidad, String pais) {
		super();
		this.iduniversidad = iduniversidad;
		this.nom_universidad = nom_universidad;
		this.pais = pais;
	}

	public int getIduniversidad() {
		return iduniversidad;
	}

	public void setIduniversidad(int iduniversidad) {
		this.iduniversidad = iduniversidad;
	}

	public String getNom_universidad() {
		return nom_universidad;
	}

	public void setNom_universidad(String nom_universidad) {
		this.nom_universidad = nom_universidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
