package pe.edu.upeu.entity;

public class Rol_Opciones {
	private int idopcion;
	private String nom_opcion;
	private int idrol;
	private String nom_rol;
	private int idrol_opcion;
	
	public Rol_Opciones(int idopcion, String nom_opcion, int idrol, String nom_rol, int idrol_opcion) {
		super();
		this.idopcion = idopcion;
		this.nom_opcion = nom_opcion;
		this.idrol = idrol;
		this.nom_rol = nom_rol;
		this.idrol_opcion = idrol_opcion;
	}
	
	public Rol_Opciones(int idopcion, int idrol, int idrol_opcion) {
		super();
		this.idopcion = idopcion;
		this.idrol = idrol;
		this.idrol_opcion = idrol_opcion;
	}

	public Rol_Opciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdopcion() {
		return idopcion;
	}
	public void setIdopcion(int idopcion) {
		this.idopcion = idopcion;
	}
	public String getNom_opcion() {
		return nom_opcion;
	}
	public void setNom_opcion(String nom_opcion) {
		this.nom_opcion = nom_opcion;
	}
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public String getNom_rol() {
		return nom_rol;
	}
	public void setNom_rol(String nom_rol) {
		this.nom_rol = nom_rol;
	}
	public int getIdrol_opcion() {
		return idrol_opcion;
	}
	public void setIdrol_opcion(int idrol_opcion) {
		this.idrol_opcion = idrol_opcion;
	}
	
}
