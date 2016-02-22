package proyectoAdministradorVuelos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import proyectoAdministradorVuelos.model.Ruta;
import proyectoAdministradorVuelos.service.RutaService;

@Component
public class RutaConverter implements Converter<Object,Ruta>{

	@Autowired
	private RutaService rutaservice;
	
	@Override
	public Ruta convert(Object element) {
		
		if(element instanceof Ruta){
			return (Ruta)element;
		}
		
		Integer id=Integer.parseInt((String)element);
		Ruta ruta=rutaservice.getRuta(id);
		return ruta;
	}

}
