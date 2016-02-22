package proyectoAdministradorVuelos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proyectoAdministradorVuelos.model.Pasajero;
import proyectoAdministradorVuelos.service.PasajeroService;

@Controller
public class PasajeroController {

	@Autowired
	private PasajeroService pasajeroservice;
	
	@RequestMapping(value = { "/pasajeros" }, method = RequestMethod.GET)
	public String listaPasajeros(ModelMap model) {
		List<Pasajero> pasajeros = pasajeroservice.listaPasajeros();
		model.addAttribute("pasajeros", pasajeros);
		return "pasajeros";
	}

	@RequestMapping(value = { "/pasajeros/agregar" }, method = RequestMethod.GET)
	public String agregarPasajero(ModelMap model) {
		Pasajero pasajero = new Pasajero();
		model.addAttribute("pasajero", pasajero);
		model.addAttribute("editar", false);
		return "agregarPasajero";
	}

	@RequestMapping(value = { "/pasajeros/agregar" }, method = RequestMethod.POST)
	public String guardarPasajero(@Valid Pasajero pasajero, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "agregarPasajero";
		}
		pasajeroservice.agregarPasajero(pasajero);
		return "redirect:/pasajeros";
	}

	@RequestMapping(value = { "/pasajeros/editar-{id}-pasajero" }, method = RequestMethod.GET)
	public String editarPasajero(@PathVariable String id, ModelMap model) {
		Pasajero pasajero = pasajeroservice.getPasajero(Integer.valueOf(id));
		model.addAttribute("pasajero", pasajero);
		model.addAttribute("editar", true);
		return "agregarPasajero";
	}

	@RequestMapping(value = { "/pasajeros/editar-{id}-pasajero" }, method = RequestMethod.POST)
	public String modificarPasajero(@Valid Pasajero pasajero, BindingResult result, ModelMap model, @PathVariable String id) {
		if (result.hasErrors()) {
			return "agregarPasajero";
		}
		pasajeroservice.modificarPasajero(pasajero);
		return "redirect:/pasajeros";
	}

	@RequestMapping(value = { "/pasajeros/eliminar-{id}-pasajero" }, method = RequestMethod.GET)
	public String borrarPasajero(@PathVariable String id) {
		pasajeroservice.borrarPasajero(Integer.valueOf(id));
		return "redirect:/pasajeros";
	}

}
