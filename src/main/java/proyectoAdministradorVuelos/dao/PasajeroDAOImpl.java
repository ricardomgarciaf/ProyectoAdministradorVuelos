package proyectoAdministradorVuelos.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyectoAdministradorVuelos.model.Pasajero;

@Repository("pasajeroDao")
public class PasajeroDAOImpl implements PasajeroDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void agregarPasajero(Pasajero pasajero) {
		sessionFactory.getCurrentSession().persist(pasajero);
	}

	@Override
	public List<Pasajero> listaPasajeros() {
		List<Pasajero> pasajeros=sessionFactory.getCurrentSession().createCriteria(Pasajero.class).list();
		for(Pasajero p:pasajeros){
			Hibernate.initialize(p.getVuelos());
		}
		return pasajeros;
	}

	@Override
	public Pasajero getPasajero(int idpasajero) {
		Pasajero pasajero=sessionFactory.getCurrentSession().get(Pasajero.class, idpasajero);
		if(pasajero!=null){
			Hibernate.initialize(pasajero.getVuelos());
		}
		return pasajero;
	}

	@Override
	public void borrarPasajero(int idpasajero) {
		Pasajero pasajero=getPasajero(idpasajero);
		if(pasajero!=null){
			sessionFactory.getCurrentSession().delete(pasajero);
		}
	}

}
