package pe.edu.upeu.entity;

public class Personas {
	private int idpersona;
	private String nombres;
	private String apellidos;
	private int t_documento;
	private String n_documento;
	private String correo;
	private String telefono;
	private String direccion;
	public Personas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personas(int idpersona, String nombres, String apellidos, int t_documento, String n_documento, String correo,
			String telefono,String direccion) {
		super();
		this.idpersona = idpersona;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.t_documento = t_documento;
		this.n_documento = n_documento;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion=direccion;
	}

	public Personas(String nombres, String apellidos, int t_documento, String n_documento, String correo,
			String telefono,String direccion) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.t_documento = t_documento;
		this.n_documento = n_documento;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion=direccion;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getT_documento() {
		return t_documento;
	}

	public void setT_documento(int t_documento) {
		this.t_documento = t_documento;
	}

	public String getN_documento() {
		return n_documento;
	}

	public void setN_documento(String n_documento) {
		this.n_documento = n_documento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

}
