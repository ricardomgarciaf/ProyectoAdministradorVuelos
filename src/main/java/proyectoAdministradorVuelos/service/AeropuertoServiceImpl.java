package proyectoAdministradorVuelos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectoAdministradorVuelos.dao.AeropuertoDAO;
import proyectoAdministradorVuelos.model.Aeropuerto;

import org.springframework.transaction.annotation.Transactional;

@Service("aeropuertoService")
@Transactional
public class AeropuertoServiceImpl implements AeropuertoService {

	@Autowired
	private AeropuertoDAO dao;
	
	@Override
	public void agregarAeropuerto(Aeropuerto aeropuerto) {
		dao.agregarAeropuerto(aeropuerto);
	}

	@Override
	public List<Aeropuerto> listaAeropuertos() {
		return dao.listaAeropuertos();
	}

	@Override
	public Aeropuerto getAeropuerto(int idaeropuerto) {
		return dao.getAeropuerto(idaeropuerto);
	}

	@Override
	public void borrarAeropuerto(int idaeropuerto) {
		dao.borrarAeropuerto(idaeropuerto);
	}

}
