package pe.edu.upeu.entity;

public class Facultades {
	private int idfacultad;
	private String nom_facultad;
	private String acronimo;
	public Facultades() {
		super();
	}
	@Override
	public String toString() {
		return "Facultades [idfacultad=" + idfacultad + ", nom_facultad=" + nom_facultad + ", acronimo=" + acronimo
				+ "]";
	}
	public Facultades(int idfacultad, String nom_facultad, String acronimo) {
		super();
		this.idfacultad = idfacultad;
		this.nom_facultad = nom_facultad;
		this.acronimo = acronimo;
	}
	public Facultades( String nom_facultad, String acronimo) {
		super();
		this.nom_facultad = nom_facultad;
		this.acronimo = acronimo;
	}
	public int getIdfacultad() {
		return idfacultad;
	}
	public void setIdfacultad(int idfacultad) {
		this.idfacultad = idfacultad;
	}
	public String getNom_facultad() {
		return nom_facultad;
	}
	public void setNom_facultad(String nom_facultad) {
		this.nom_facultad = nom_facultad;
	}
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	
}
