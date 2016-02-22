package proyectoAdministradorVuelos.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyectoAdministradorVuelos.model.Pasajero;
import proyectoAdministradorVuelos.model.Ruta;

@Repository("rutaDao")
public class RutaDAOImpl implements RutaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void agregarRuta(Ruta ruta) {
		sessionFactory.getCurrentSession().persist(ruta);
	}

	@Override
	public List<Ruta> listaRutas() {
		List<Ruta> rutas=sessionFactory.getCurrentSession().createCriteria(Ruta.class).list();
		for(Ruta r:rutas){
			Hibernate.initialize(r.getVuelos());
			Hibernate.initialize(r.getAeropuertoByAeropuertoDestino().getRutasForAeropuertoDestino());
			Hibernate.initialize(r.getAeropuertoByAeropuertoDestino().getRutasForAeropuertoOrigen());
			Hibernate.initialize(r.getAeropuertoByAeropuertoOrigen().getRutasForAeropuertoOrigen());
			Hibernate.initialize(r.getAeropuertoByAeropuertoOrigen().getRutasForAeropuertoDestino());
		}
		return rutas; 
	}

	@Override
	public Ruta getRuta(int idruta) {
		Ruta ruta=sessionFactory.getCurrentSession().get(Ruta.class, idruta);
		if(ruta!=null){
			Hibernate.initialize(ruta.getVuelos());
			Hibernate.initialize(ruta.getAeropuertoByAeropuertoDestino().getRutasForAeropuertoDestino());
			Hibernate.initialize(ruta.getAeropuertoByAeropuertoDestino().getRutasForAeropuertoOrigen());
			Hibernate.initialize(ruta.getAeropuertoByAeropuertoOrigen().getRutasForAeropuertoOrigen());
			Hibernate.initialize(ruta.getAeropuertoByAeropuertoOrigen().getRutasForAeropuertoDestino());
		}
		return ruta;
	}

	@Override
	public void borrarRuta(int idruta) {
		Ruta ruta=getRuta(idruta);
		if(ruta!=null){
			sessionFactory.getCurrentSession().delete(ruta);
		}		
	}

}
