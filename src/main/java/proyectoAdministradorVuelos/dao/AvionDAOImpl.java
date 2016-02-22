package proyectoAdministradorVuelos.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyectoAdministradorVuelos.model.Avion;

@Repository("avionDao")
public class AvionDAOImpl implements AvionDAO {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public void agregarAvion(Avion avion) {
		sessionFactory.getCurrentSession().persist(avion);
	}

	@Override
	public List<Avion> listaAviones() {
		List<Avion> aviones=sessionFactory.getCurrentSession().createCriteria(Avion.class).list();
		for(Avion a:aviones){
			Hibernate.initialize(a.getVuelos());
		}
		return aviones;
	}

	@Override
	public Avion getAvion(int idavion) {
		Avion avion=sessionFactory.getCurrentSession().get(Avion.class, idavion);
		if(avion!=null){
			Hibernate.initialize(avion.getVuelos());
		}
		return avion;
	}

	@Override
	public void borrarAvion(int idavion) {
		Avion avion=getAvion(idavion);
		if(avion!=null){
			sessionFactory.getCurrentSession().delete(avion);
		}
	}

}
