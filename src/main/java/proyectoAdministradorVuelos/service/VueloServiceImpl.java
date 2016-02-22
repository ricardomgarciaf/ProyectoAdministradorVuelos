package proyectoAdministradorVuelos.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoAdministradorVuelos.dao.VueloDAO;
import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.model.Pasajero;
import proyectoAdministradorVuelos.model.Reporte;
import proyectoAdministradorVuelos.model.Vuelo;

@Service("vueloService")
@Transactional
public class VueloServiceImpl implements VueloService {

	@Autowired
	private VueloDAO dao;
	
	@Override
	public void agregarVuelo(Vuelo vuelo) {
		dao.agregarVuelo(vuelo);
	}

	@Override
	public void modificarVuelo(Vuelo vuelo) {
		Vuelo v=dao.getVuelo(vuelo.getId());
		if(v!=null){
			v.setAvion(vuelo.getAvion());
			v.setFecha(vuelo.getFecha());
			v.setHorafin(vuelo.getHorafin());
			v.setHorainicio(vuelo.getHorainicio());
			v.setRuta(vuelo.getRuta());
			v.setPasajeros(vuelo.getPasajeros());
		}
	}

	@Override
	public List<Vuelo> listaVuelos() {
		return dao.listaVuelos();
	}

	@Override
	public Vuelo getVuelo(int idvuelo) {
		return dao.getVuelo(idvuelo);
	}

	@Override
	public void borrarVuelo(int idvuelo) {
		dao.borrarVuelo(idvuelo);
	}

	@Override
	public boolean reservarVuelo(int idvuelo, Pasajero pasajero) {
		Vuelo vuelo=getVuelo(idvuelo);
		if(vuelo!=null){
			System.out.println(vuelo.getAvion().getCapacidad()+"-"+vuelo.getPasajeros().size());
			if(vuelo.getAvion().getCapacidad()>vuelo.getPasajeros().size()){
				vuelo.getPasajeros().add(pasajero);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Reporte> generarReporte(Date inicio, Date fin, Avion avion) {
		return dao.generarReporte(inicio, fin, avion);
	}
	
	

}
