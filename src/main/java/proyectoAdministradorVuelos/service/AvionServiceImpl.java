package proyectoAdministradorVuelos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoAdministradorVuelos.dao.AvionDAO;
import proyectoAdministradorVuelos.model.Avion;

@Service("avionService")
@Transactional
public class AvionServiceImpl implements AvionService {
	
	@Autowired
	private AvionDAO dao;
	
	@Override
	public void agregarAvion(Avion avion) {
		dao.agregarAvion(avion);
	}

	@Override
	public void modificarAvion(Avion avion) {
		Avion a=dao.getAvion(avion.getId());
		if(a!=null){
			a.setModelo(avion.getModelo());
			a.setCapacidad(avion.getCapacidad());
			a.setFabricante(avion.getFabricante());
			a.setVuelos(avion.getVuelos());
		}
		//dao.agregarAvion(avion);
	}

	@Override
	public List<Avion> listaAviones() {
		return dao.listaAviones();
	}

	@Override
	public Avion getAvion(int idavion) {
		return dao.getAvion(idavion);
	}

	@Override
	public void borrarAvion(int idavion) {
		dao.borrarAvion(idavion);
	}

}
