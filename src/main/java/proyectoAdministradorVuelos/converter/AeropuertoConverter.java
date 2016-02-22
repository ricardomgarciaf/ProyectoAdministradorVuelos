package proyectoAdministradorVuelos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import proyectoAdministradorVuelos.model.Aeropuerto;
import proyectoAdministradorVuelos.service.AeropuertoService;

@Component
public class AeropuertoConverter implements Converter<Object,Aeropuerto>{

	@Autowired
	private AeropuertoService aeropuertoservice;
	
	@Override
	public Aeropuerto convert(Object element) {
		Integer id=Integer.parseInt((String)element);
		Aeropuerto aeropuerto=aeropuertoservice.getAeropuerto(id);
		return aeropuerto;
	}

}
