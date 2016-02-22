package proyectoAdministradorVuelos.dao;

import java.sql.Date;
import java.util.List;

import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.model.Reporte;
import proyectoAdministradorVuelos.model.Vuelo;


public interface VueloDAO {

	public void agregarVuelo(Vuelo vuelo);

	public List<Vuelo> listaVuelos();

	public Vuelo getVuelo(int idvuelo);

	public void borrarVuelo(int idvuelo);
	
	public List<Reporte> generarReporte(Date inicio, Date fin, Avion avion);
}
