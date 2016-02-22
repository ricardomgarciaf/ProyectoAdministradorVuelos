package proyectoAdministradorVuelos.dao;

import java.util.List;

import proyectoAdministradorVuelos.model.Pasajero;


public interface PasajeroDAO {

	public void agregarPasajero(Pasajero pasajero);

	public List<Pasajero> listaPasajeros();

	public Pasajero getPasajero(int idpasajero);

	public void borrarPasajero(int idpasajero);
}
