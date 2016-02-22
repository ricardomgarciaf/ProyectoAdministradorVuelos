package proyectoAdministradorVuelos.service;

import java.util.List;

import proyectoAdministradorVuelos.model.Pasajero;

public interface PasajeroService {

	public void agregarPasajero(Pasajero pasajero);
	
	public void modificarPasajero(Pasajero pasajero);

	public List<Pasajero> listaPasajeros();

	public Pasajero getPasajero(int idpasajero);

	public void borrarPasajero(int idpasajero);
}
