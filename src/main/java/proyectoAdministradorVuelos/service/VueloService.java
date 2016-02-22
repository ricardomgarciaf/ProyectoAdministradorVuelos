package proyectoAdministradorVuelos.service;

import java.sql.Date;
import java.util.List;

import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.model.Pasajero;
import proyectoAdministradorVuelos.model.Reporte;
import proyectoAdministradorVuelos.model.Vuelo;

public interface VueloService {

	public void agregarVuelo(Vuelo vuelo);
	
	public void modificarVuelo(Vuelo vuelo);

	public List<Vuelo> listaVuelos();

	public Vuelo getVuelo(int idvuelo);

	public void borrarVuelo(int idvuelo);
	
	public boolean reservarVuelo(int idvuelo,Pasajero pasajero);
	
	public List<Reporte> generarReporte(Date inicio, Date fin, Avion avion);
}
