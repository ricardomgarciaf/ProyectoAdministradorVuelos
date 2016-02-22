package proyectoAdministradorVuelos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoAdministradorVuelos.dao.RutaDAO;
import proyectoAdministradorVuelos.model.Ruta;

@Service("rutaService")
@Transactional
public class RutaServiceImpl implements RutaService{

	@Autowired
	private RutaDAO dao;
	@Override
	public void agregarRuta(Ruta ruta) {
		dao.agregarRuta(ruta);
	}

	@Override
	public void modificarRuta(Ruta ruta) {
		Ruta r=dao.getRuta(ruta.getId());
		if(r!=null){
			r.setAeropuertoByAeropuertoOrigen(ruta.getAeropuertoByAeropuertoOrigen());
			r.setAeropuertoByAeropuertoDestino(ruta.getAeropuertoByAeropuertoDestino());
			r.setDuracion(ruta.getDuracion());
			r.setVuelos(ruta.getVuelos());
		}
	}

	@Override
	public List<Ruta> listaRutas() {
		return dao.listaRutas();
	}

	@Override
	public Ruta getRuta(int idruta) {
		return dao.getRuta(idruta);
	}

	@Override
	public void borrarRuta(int idruta) {
		dao.borrarRuta(idruta);
	}

}
