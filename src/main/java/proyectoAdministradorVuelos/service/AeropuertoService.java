package proyectoAdministradorVuelos.service;

import java.util.List;

import proyectoAdministradorVuelos.model.Aeropuerto;

public interface AeropuertoService {

	public void agregarAeropuerto(Aeropuerto aeropuerto);

	public List<Aeropuerto> listaAeropuertos();

	public Aeropuerto getAeropuerto(int idaeropuerto);

	public void borrarAeropuerto(int idaeropuerto);
}
