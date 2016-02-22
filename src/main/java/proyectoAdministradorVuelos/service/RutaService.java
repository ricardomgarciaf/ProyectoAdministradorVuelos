package proyectoAdministradorVuelos.service;

import java.util.List;

import proyectoAdministradorVuelos.model.Ruta;

public interface RutaService {

	public void agregarRuta(Ruta ruta);
	
	public void modificarRuta(Ruta ruta);

	public List<Ruta> listaRutas();

	public Ruta getRuta(int idruta);

	public void borrarRuta(int idruta);
}
