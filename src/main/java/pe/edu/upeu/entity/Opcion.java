package pe.edu.upeu.entity;

public class Opcion {
	private int idopcion;
	private String nombre;
	private String descripcion;
	private String enlace;
	private String icono;
	private int estado;
	
	@Override
	public String toString() {
		return "Opcion [idopcion=" + idopcion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", enlace="
				+ enlace + ", icono=" + icono + ", estado=" + estado + "]";
	}
	public Opcion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Opcion(int idopcion, String nombre, String descripcion, String enlace, String icono, int estado) {
		super();
		this.idopcion = idopcion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.enlace = enlace;
		this.icono = icono;
		this.estado = estado;
	}
	
	public Opcion(String nombre, String descripcion, String enlace, String icono, int estado) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.enlace = enlace;
		this.icono = icono;
		this.estado = estado;
	}
	public int getIdopcion() {
		return idopcion;
	}
	public void setIdopcion(int idopcion) {
		this.idopcion = idopcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
