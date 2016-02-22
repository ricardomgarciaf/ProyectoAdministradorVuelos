package proyectoAdministradorVuelos.model;

/**
 * Entidad que representa a una reserva de vuelo
 */
public class Reserva {

	private Vuelo vuelo;
	private Pasajero pasajero;
	
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	
}
