package pe.edu.upeu.entity;

public class Usuarios {
private int idusuario;
private String codigo;
private String usuario;
private String password;
private int sede;
private int tipo;
private int estado;
private int idpersona;
private int idep;
private String ciclo;
private String n_documento;
private int idrol;
private String color_fondo;
private String color_menu;
private String foto;

public Usuarios() {
	super();
	// TODO Auto-generated constructor stub
}

public Usuarios(int idusuario, String codigo, String usuario, String password, int sede, int tipo, int estado,
		int idpersona, int idep, String ciclo) {
	super();
	this.idusuario = idusuario;
	this.codigo = codigo;
	this.usuario = usuario;
	this.password = password;
	this.sede = sede;
	this.tipo = tipo;
	this.estado = estado;
	this.idpersona = idpersona;
	this.idep = idep;
	this.ciclo = ciclo;
}

///PARA ESTUDIANTES Y DOCENTES
public Usuarios(String codigo, String usuario, String password, int sede, int tipo, int estado, int idep, String ciclo,
		String n_documento) {
	super();
	this.codigo = codigo;
	this.usuario = usuario;
	this.password = password;
	this.sede = sede;
	this.tipo = tipo;
	this.estado = estado;
	this.idep = idep;
	this.ciclo = ciclo;
	this.n_documento = n_documento;
}


/// PARA USUARIOS ESPECIALES
public Usuarios(String codigo, String usuario, String password, int sede, int tipo, int idep, String n_documento,
		int idrol) {
	super();
	this.codigo = codigo;
	this.usuario = usuario;
	this.password = password;
	this.sede = sede;
	this.tipo = tipo;
	this.idep = idep;
	this.n_documento = n_documento;
	this.idrol = idrol;
}

public Usuarios(String codigo, String usuario, String password, int sede, int tipo, int idep, String ciclo,
		String n_documento, int idrol) {
	super();
	this.codigo = codigo;
	this.usuario = usuario;
	this.password = password;
	this.sede = sede;
	this.tipo = tipo;
	this.idep = idep;
	this.ciclo = ciclo;
	this.n_documento = n_documento;
	this.idrol = idrol;
}

public Usuarios(int idusuario, String color_fondo, String color_menu) {
	super();
	this.idusuario = idusuario;
	this.color_fondo = color_fondo;
	this.color_menu = color_menu;
}



public Usuarios(int idusuario, String password) {
	super();
	this.idusuario = idusuario;
	this.password = password;
}

public int getIdusuario() {
	return idusuario;
}

public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getSede() {
	return sede;
}

public void setSede(int sede) {
	this.sede = sede;
}

public int getTipo() {
	return tipo;
}

public void setTipo(int tipo) {
	this.tipo = tipo;
}

public int getEstado() {
	return estado;
}

public void setEstado(int estado) {
	this.estado = estado;
}

public int getIdpersona() {
	return idpersona;
}

public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
}

public int getIdep() {
	return idep;
}

public void setIdep(int idep) {
	this.idep = idep;
}

public String getCiclo() {
	return ciclo;
}

public void setCiclo(String ciclo) {
	this.ciclo = ciclo;
}

public String getN_documento() {
	return n_documento;
}

public void setN_documento(String n_documento) {
	this.n_documento = n_documento;
}

public int getIdrol() {
	return idrol;
}

public void setIdrol(int idrol) {
	this.idrol = idrol;
}

public String getColor_fondo() {
	return color_fondo;
}

public void setColor_fondo(String color_fondo) {
	this.color_fondo = color_fondo;
}

public String getColor_menu() {
	return color_menu;
}

public void setColor_menu(String color_menu) {
	this.color_menu = color_menu;
}

public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}



}
