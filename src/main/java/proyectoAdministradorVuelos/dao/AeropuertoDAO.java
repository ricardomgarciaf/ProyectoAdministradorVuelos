package proyectoAdministradorVuelos.dao;

import java.util.List;

import proyectoAdministradorVuelos.model.Aeropuerto;

public interface AeropuertoDAO {
	
	public void agregarAeropuerto(Aeropuerto aeropuerto);

	public List<Aeropuerto> listaAeropuertos();

	public Aeropuerto getAeropuerto(int idaeropuerto);

	public void borrarAeropuerto(int idaeropuerto);
}
