package proyectoAdministradorVuelos.model;

/**
 * Entidad que representa a un reporte
 */
public class Reporte {

	private String ruta;
	private int cantidadVuelos;
	private int cantidadPasajeros;
	
	public int getCantidadPasajeros() {
		return cantidadPasajeros;
	}
	public void setCantidadPasajeros(int cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public int getCantidadVuelos() {
		return cantidadVuelos;
	}
	public void setCantidadVuelos(int cantidadVuelos) {
		this.cantidadVuelos = cantidadVuelos;
	}	
	
}
