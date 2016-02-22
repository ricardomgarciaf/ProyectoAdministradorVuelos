package proyectoAdministradorVuelos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import proyectoAdministradorVuelos.model.Pasajero;
import proyectoAdministradorVuelos.service.PasajeroService;

@Component
public class PasajeroConverter implements Converter<Object,Pasajero>{

	@Autowired
	private PasajeroService pasajeroservice;

	@Override
	public Pasajero convert(Object element) {
		
		if(element instanceof Pasajero){
			return (Pasajero)element;
		}
		
		Integer id=Integer.parseInt((String)element);
		Pasajero pasajero=pasajeroservice.getPasajero(id);
		return pasajero;
	}
	
}
