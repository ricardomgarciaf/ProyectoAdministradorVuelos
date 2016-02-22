package proyectoAdministradorVuelos.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proyectoAdministradorVuelos.model.Aeropuerto;
import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.model.Pasajero;
import proyectoAdministradorVuelos.model.Ruta;
import proyectoAdministradorVuelos.model.Vuelo;
import proyectoAdministradorVuelos.service.AvionService;
import proyectoAdministradorVuelos.service.PasajeroService;
import proyectoAdministradorVuelos.service.RutaService;
import proyectoAdministradorVuelos.service.VueloService;

@Controller
public class VueloController {

	@Autowired
	private VueloService vueloservice;
	
	@Autowired
	private AvionService avionservice;
	
	@Autowired
	private RutaService rutaservice;
	
	
	@RequestMapping(value = { "/vuelos" }, method = RequestMethod.GET)
	public String listaVuelos(ModelMap model) {
		List<Vuelo> vuelos = vueloservice.listaVuelos();
		model.addAttribute("vuelos", vuelos);
		return "vuelos";
	}

	@RequestMapping(value = { "/vuelos/agregar" }, method = RequestMethod.GET)
	public String agregarVuelo(ModelMap model) {
		Vuelo vuelo = new Vuelo();
		model.addAttribute("vuelo", vuelo);
		model.addAttribute("editar", false);
		return "agregarVuelo";
	}

	@RequestMapping(value = { "/vuelos/agregar" }, method = RequestMethod.POST)
	public String guardarVuelo(@Valid Vuelo vuelo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "agregarVuelo";
		}
		try{
		vueloservice.agregarVuelo(vuelo);
		}catch(ConstraintViolationException ex){
			return "registroVueloFallido";
		}
		
		return "redirect:/vuelos";
	}

	@RequestMapping(value = { "/vuelos/editar-{id}-vuelo" }, method = RequestMethod.GET)
	public String editarVuelo(@PathVariable String id, ModelMap model) {
		Vuelo vuelo = vueloservice.getVuelo(Integer.valueOf(id));
		model.addAttribute("vuelo", vuelo);
		model.addAttribute("editar", true);
		return "agregarVuelo";
	}

	@RequestMapping(value = { "/vuelos/editar-{id}-vuelo" }, method = RequestMethod.POST)
	public String modificarVuelo(@Valid Vuelo vuelo, BindingResult result, ModelMap model, @PathVariable String id) {
		if (result.hasErrors()) {
			return "agregarVuelo";
		}
		vueloservice.modificarVuelo(vuelo);
		return "redirect:/vuelos";
	}

	@RequestMapping(value = { "/vuelos/eliminar-{id}-vuelo" }, method = RequestMethod.GET)
	public String borrarVuelo(@PathVariable String id) {
		vueloservice.borrarVuelo(Integer.valueOf(id));
		return "redirect:/vuelos";
	}
	
	@ModelAttribute("aviones")
    public List<Avion> inicializarAviones() {
        return avionservice.listaAviones();
    }
	
	@ModelAttribute("rutas")
    public List<Ruta> inicializarRutas() {
        return rutaservice.listaRutas();
    }
	
}
