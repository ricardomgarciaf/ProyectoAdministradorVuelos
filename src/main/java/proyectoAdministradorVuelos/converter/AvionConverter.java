package proyectoAdministradorVuelos.converter;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.service.AvionService;

@Component
public class AvionConverter implements Converter<Object,Avion>{

	@Autowired
	private AvionService avionservice;
	
	@Override
	public Avion convert(Object element) {
		
		if(element instanceof Avion){
			return (Avion)element;
		}
		
		Integer id=Integer.parseInt((String)element);
		Avion avion=avionservice.getAvion(id);
		return avion;
	}

}
