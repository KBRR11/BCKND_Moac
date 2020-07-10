package pe.edu.upeu.entity;

public class EscuelasProfesionales {
	private int idep;
	private String nom_ep;
	private int idfacultad;
	
	public EscuelasProfesionales() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public EscuelasProfesionales(int idep, String nom_ep, int idfacultad) {
		super();
		this.idep = idep;
		this.nom_ep = nom_ep;
		this.idfacultad = idfacultad;
	}
	
	public EscuelasProfesionales(int idfacultad) {
		super();
		this.idfacultad = idfacultad;
	}


	public int getIdep() {
		return idep;
	}


	public void setIdep(int idep) {
		this.idep = idep;
	}


	public String getNom_ep() {
		return nom_ep;
	}


	public void setNom_ep(String nom_ep) {
		this.nom_ep = nom_ep;
	}


	public int getIdfacultad() {
		return idfacultad;
	}


	public void setIdfacultad(int idfacultad) {
		this.idfacultad = idfacultad;
	}

	
	
}
