package proyectoAdministradorVuelos.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.Transform;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.model.Reporte;
import proyectoAdministradorVuelos.model.Ruta;
import proyectoAdministradorVuelos.model.Vuelo;

@Repository("vueloDao")
public class VueloDAOImpl implements VueloDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void agregarVuelo(Vuelo vuelo) {
		sessionFactory.getCurrentSession().persist(vuelo);
	}

	@Override
	public List<Vuelo> listaVuelos() {
		List<Vuelo> vuelos=sessionFactory.getCurrentSession().createCriteria(Vuelo.class).list();
		for(Vuelo v:vuelos){
			Hibernate.initialize(v.getPasajeros());
			Hibernate.initialize(v.getAvion().getVuelos());
			Hibernate.initialize(v.getRuta().getAeropuertoByAeropuertoDestino().getRutasForAeropuertoDestino());
			Hibernate.initialize(v.getRuta().getAeropuertoByAeropuertoDestino().getRutasForAeropuertoOrigen());
			Hibernate.initialize(v.getRuta().getAeropuertoByAeropuertoOrigen().getRutasForAeropuertoOrigen());
			Hibernate.initialize(v.getRuta().getAeropuertoByAeropuertoOrigen().getRutasForAeropuertoDestino());
		}
		return vuelos;
	}

	@Override
	public Vuelo getVuelo(int idvuelo) {
		Vuelo vuelo=sessionFactory.getCurrentSession().get(Vuelo.class, idvuelo);
		if(vuelo!=null){
			Hibernate.initialize(vuelo.getPasajeros());
			Hibernate.initialize(vuelo.getAvion().getVuelos());
			Hibernate.initialize(vuelo.getRuta().getAeropuertoByAeropuertoDestino().getRutasForAeropuertoDestino());
			Hibernate.initialize(vuelo.getRuta().getAeropuertoByAeropuertoDestino().getRutasForAeropuertoOrigen());
			Hibernate.initialize(vuelo.getRuta().getAeropuertoByAeropuertoOrigen().getRutasForAeropuertoOrigen());
			Hibernate.initialize(vuelo.getRuta().getAeropuertoByAeropuertoOrigen().getRutasForAeropuertoDestino());
		}
		return vuelo;
	}

	@Override
	public void borrarVuelo(int idvuelo) {
		Vuelo vuelo=getVuelo(idvuelo);
		if(vuelo!=null){
			sessionFactory.getCurrentSession().delete(vuelo);
		}
	}

	@Override
	public List<Reporte> generarReporte(Date inicio, Date fin, Avion avion) {
		List<Reporte> reportes= new ArrayList<>();
		/*
		List<Reporte> reportes=sessionFactory.getCurrentSession().createCriteria(Vuelo.class)
		.add(Restrictions.eq("avion", avion))
		.add(Restrictions.ge("fecha", inicio))
		.add(Restrictions.lt("fecha", fin))
		.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("ruta").as("ruta"))
				.add(Projections.count("id"))
				).setResultTransformer(Transformers.aliasToBean(Reporte.class)).list();
		*/
		return reportes;
	}
	
	

}
