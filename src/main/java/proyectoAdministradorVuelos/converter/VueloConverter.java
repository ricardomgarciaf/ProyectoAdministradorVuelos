package proyectoAdministradorVuelos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.model.Vuelo;
import proyectoAdministradorVuelos.service.VueloService;

@Component
public class VueloConverter implements Converter<Object, Vuelo>{

	@Autowired
	private VueloService vueloservice;

	@Override
	public Vuelo convert(Object element) {
		
		if(element instanceof Vuelo){
			return (Vuelo)element;
		}
		
		Integer id=Integer.parseInt((String)element);
		Vuelo vuelo=vueloservice.getVuelo(id);
		return vuelo;
	}
	
	
}
