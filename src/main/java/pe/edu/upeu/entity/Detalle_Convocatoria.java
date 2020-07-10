package pe.edu.upeu.entity;

public class Detalle_Convocatoria {
	private int idetalle_convocatoria;
	private int idconvocatoria;
	private int idescuela;
	private String estado;
	private String desde;
	private String hasta;
	private String nombre;
	private String escuela;
	public Detalle_Convocatoria(int idetalle_convocatoria, int idconvocatoria, int idescuela, String estado,
			String desde, String hasta, String nombre,String escuela) {
		this.idetalle_convocatoria = idetalle_convocatoria;
		this.idconvocatoria = idconvocatoria;
		this.idescuela = idescuela;
		this.estado = estado;
		this.desde = desde;
		this.hasta = hasta;
		this.nombre = nombre;
		this.escuela= escuela;
	}
	@Override
	public String toString() {
		return "Detalle_Convocatoria [idetalle_convocatoria=" + idetalle_convocatoria + ", idconvocatoria="
				+ idconvocatoria + ", idescuela=" + idescuela + ", estado=" + estado + ", desde=" + desde + ", hasta="
				+ hasta + ", nombre=" + nombre + ", escuela=" + escuela + "]";
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public int getIdetalle_convocatoria() {
		return idetalle_convocatoria;
	}
	public void setIdetalle_convocatoria(int idetalle_convocatoria) {
		this.idetalle_convocatoria = idetalle_convocatoria;
	}
	public int getIdconvocatoria() {
		return idconvocatoria;
	}
	public void setIdconvocatoria(int idconvocatoria) {
		this.idconvocatoria = idconvocatoria;
	}
	public int getIdescuela() {
		return idescuela;
	}
	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
