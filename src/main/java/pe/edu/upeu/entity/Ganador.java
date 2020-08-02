package pe.edu.upeu.entity;

public class Ganador {
	private int idganador;
	private int idusuario;
	private int iddetalle_convocatoria;
	private int estado;
	public Ganador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ganador(int idganador, int idusuario, int iddetalle_convocatoria, int estado) {
		super();
		this.idganador = idganador;
		this.idusuario = idusuario;
		this.iddetalle_convocatoria = iddetalle_convocatoria;
		this.estado = estado;
	}
	public int getIdganador() {
		return idganador;
	}
	public void setIdganador(int idganador) {
		this.idganador = idganador;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public int getIddetalle_convocatoria() {
		return iddetalle_convocatoria;
	}
	public void setIddetalle_convocatoria(int iddetalle_convocatoria) {
		this.iddetalle_convocatoria = iddetalle_convocatoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
