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

import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.service.AvionService;

@Controller
public class AvionController {

	@Autowired
	private AvionService avionservice;

	@RequestMapping(value = { "/aviones" }, method = RequestMethod.GET)
	public String listaAviones(ModelMap model) {
		List<Avion> aviones = avionservice.listaAviones();
		model.addAttribute("aviones", aviones);
		return "aviones";
	}

	@RequestMapping(value = { "/aviones/agregar" }, method = RequestMethod.GET)
	public String agregarAvion(ModelMap model) {
		Avion avion = new Avion();
		model.addAttribute("avion", avion);
		model.addAttribute("editar", false);
		return "agregarAvion";
	}

	@RequestMapping(value = { "/aviones/agregar" }, method = RequestMethod.POST)
	public String guardarAvion(@Valid Avion avion, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "agregarAvion";
		}
		avionservice.agregarAvion(avion);
		return "redirect:/aviones";
	}

	@RequestMapping(value = { "/aviones/editar-{id}-avion" }, method = RequestMethod.GET)
	public String editarAvion(@PathVariable String id, ModelMap model) {
		Avion avion = avionservice.getAvion(Integer.valueOf(id));
		model.addAttribute("avion", avion);
		model.addAttribute("editar", true);
		return "agregarAvion";
	}

	@RequestMapping(value = { "/aviones/editar-{id}-avion" }, method = RequestMethod.POST)
	public String modificarAvion(@Valid Avion avion, BindingResult result, ModelMap model, @PathVariable String id) {
		if (result.hasErrors()) {
			return "agregarAvion";
		}
		avionservice.modificarAvion(avion);
		return "redirect:/aviones";
	}

	@RequestMapping(value = { "/aviones/eliminar-{id}-avion" }, method = RequestMethod.GET)
	public String borrarAvion(@PathVariable String id) {
		avionservice.borrarAvion(Integer.valueOf(id));
		return "redirect:/aviones";
	}

}
