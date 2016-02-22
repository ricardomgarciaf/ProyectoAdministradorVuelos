package proyectoAdministradorVuelos.dao;

import java.util.List;

import proyectoAdministradorVuelos.model.Ruta;


public interface RutaDAO {

	public void agregarRuta(Ruta ruta);

	public List<Ruta> listaRutas();

	public Ruta getRuta(int idruta);

	public void borrarRuta(int idruta);
}
