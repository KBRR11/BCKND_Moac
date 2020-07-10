package pe.edu.upeu.entity;

import java.sql.Date;

public class Rol_Usuario {
	private int idrol_us;
	private int idusuario;
	private int idrol;
	
	public Rol_Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rol_Usuario(int idrol_us, int idusuario, int idrol) {
		super();
		this.idrol_us = idrol_us;
		this.idusuario = idusuario;
		this.idrol = idrol;
	}

	public int getIdrol_us() {
		return idrol_us;
	}

	public void setIdrol_us(int idrol_us) {
		this.idrol_us = idrol_us;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	
	
}
