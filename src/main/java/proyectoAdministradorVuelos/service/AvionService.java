package proyectoAdministradorVuelos.service;

import java.util.List;

import proyectoAdministradorVuelos.model.Avion;

public interface AvionService {

	public void agregarAvion(Avion avion);
	
	public void modificarAvion(Avion avion);

	public List<Avion> listaAviones();

	public Avion getAvion(int idavion);

	public void borrarAvion(int idavion);
}
