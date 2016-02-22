package proyectoAdministradorVuelos.dao;

import java.util.List;

import proyectoAdministradorVuelos.model.Avion;

public interface AvionDAO {

	public void agregarAvion(Avion avion);

	public List<Avion> listaAviones();

	public Avion getAvion(int idavion);

	public void borrarAvion(int idavion);
}
