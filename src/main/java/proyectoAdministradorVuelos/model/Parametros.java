package proyectoAdministradorVuelos.model;

import java.sql.Date;

/**
 * Entidad utilizada para la representacion del reporte basado en los parametros de busqueda
 */
public class Parametros {
	
	private String fechaInicial;
	private String fechaFinal;
	private Avion avion;
	public String getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	
}
