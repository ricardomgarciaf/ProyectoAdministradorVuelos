package proyectoAdministradorVuelos.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyectoAdministradorVuelos.model.Aeropuerto;

@Repository("aeropuertoDao")
public class AeropuertoDAOImpl implements AeropuertoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void agregarAeropuerto(Aeropuerto aeropuerto) {
		sessionFactory.getCurrentSession().persist(aeropuerto);
	}

	@Override
	public List<Aeropuerto> listaAeropuertos() {
		List<Aeropuerto> aeropuertos=sessionFactory.getCurrentSession().createCriteria(Aeropuerto.class).list();
		for(Aeropuerto a:aeropuertos){
			Hibernate.initialize(a.getRutasForAeropuertoDestino());
			Hibernate.initialize(a.getRutasForAeropuertoOrigen());
		}
		return aeropuertos;
	}

	@Override
	public Aeropuerto getAeropuerto(int idaeropuerto) {
		Aeropuerto aeropuerto=sessionFactory.getCurrentSession().get(Aeropuerto.class, idaeropuerto);
		if(aeropuerto!=null){
			Hibernate.initialize(aeropuerto.getRutasForAeropuertoOrigen());
			Hibernate.initialize(aeropuerto.getRutasForAeropuertoDestino());
		}
		return aeropuerto;
	}

	@Override
	public void borrarAeropuerto(int idaeropuerto) {
		Aeropuerto aeropuerto=getAeropuerto(idaeropuerto);
		if(aeropuerto!=null){
			sessionFactory.getCurrentSession().delete(aeropuerto);
		}
	}

}
