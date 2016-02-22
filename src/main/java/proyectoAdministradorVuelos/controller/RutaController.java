package proyectoAdministradorVuelos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.SocketUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proyectoAdministradorVuelos.model.Aeropuerto;
import proyectoAdministradorVuelos.model.Ruta;
import proyectoAdministradorVuelos.service.AeropuertoService;
import proyectoAdministradorVuelos.service.RutaService;

@Controller
public class RutaController {

	@Autowired
	private RutaService rutaservice;
	
	@Autowired
	private AeropuertoService aeropuertoservice;
	
	@RequestMapping(value = { "/rutas" }, method = RequestMethod.GET)
	public String listaRutas(ModelMap model) {
		List<Ruta> rutas = rutaservice.listaRutas();
		model.addAttribute("rutas", rutas);
		return "rutas";
	}

	@RequestMapping(value = { "/rutas/agregar" }, method = RequestMethod.GET)
	public String agregarRuta(ModelMap model) {
		Ruta ruta = new Ruta();
		model.addAttribute("ruta", ruta);
		model.addAttribute("editar", false);
		return "agregarRuta";
	}

	@RequestMapping(value = { "/rutas/agregar" }, method = RequestMethod.POST)
	public String guardarRuta(@Valid Ruta ruta, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "agregarRuta";
		}
		rutaservice.agregarRuta(ruta);
		return "redirect:/rutas";
	}

	@RequestMapping(value = { "/rutas/editar-{id}-ruta" }, method = RequestMethod.GET)
	public String editarRuta(@PathVariable String id, ModelMap model) {
		Ruta ruta = rutaservice.getRuta(Integer.valueOf(id));
		model.addAttribute("ruta", ruta);
		model.addAttribute("editar", true);
		return "agregarRuta";
	}

	@RequestMapping(value = { "/rutas/editar-{id}-ruta" }, method = RequestMethod.POST)
	public String modificarRuta(@Valid Ruta ruta, BindingResult result, ModelMap model, @PathVariable String id) {
		if (result.hasErrors()) {
			return "agregarRuta";
		}
		rutaservice.modificarRuta(ruta);
		return "redirect:/rutas";
	}

	@RequestMapping(value = { "/rutas/eliminar-{id}-ruta" }, method = RequestMethod.GET)
	public String borrarRuta(@PathVariable String id) {
		rutaservice.borrarRuta(Integer.valueOf(id));
		return "redirect:/rutas";
	}
	
	@ModelAttribute("aeropuertos")
    public List<Aeropuerto> inicializarAeropuertos() {
        return aeropuertoservice.listaAeropuertos();
    }

}
