package proyectoAdministradorVuelos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoAdministradorVuelos.dao.PasajeroDAO;
import proyectoAdministradorVuelos.model.Pasajero;

@Service("pasajeroService")
@Transactional
public class PasajeroServiceImpl implements PasajeroService {

	@Autowired
	private PasajeroDAO dao;
	
	@Override
	public void agregarPasajero(Pasajero pasajero) {
		dao.agregarPasajero(pasajero);
	}

	@Override
	public void modificarPasajero(Pasajero pasajero) {
		Pasajero p=dao.getPasajero(pasajero.getId());
		if(p!=null){
			p.setNombre(pasajero.getNombre());
			p.setApellido(pasajero.getApellido());
			p.setVuelos(pasajero.getVuelos());
		}
	}

	@Override
	public List<Pasajero> listaPasajeros() {
		return dao.listaPasajeros();
	}

	@Override
	public Pasajero getPasajero(int idpasajero) {
		return dao.getPasajero(idpasajero);
	}

	@Override
	public void borrarPasajero(int idpasajero) {
		dao.borrarPasajero(idpasajero);
	}

}
