package proyectoAdministradorVuelos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proyectoAdministradorVuelos.model.Pasajero;
import proyectoAdministradorVuelos.model.Reserva;
import proyectoAdministradorVuelos.model.Vuelo;
import proyectoAdministradorVuelos.service.PasajeroService;
import proyectoAdministradorVuelos.service.VueloService;

@Controller
public class ReservaController {

	@Autowired
	private PasajeroService pasajeroservice;
	
	@Autowired
	private VueloService vueloservice;
	
	@RequestMapping(value = { "/reservas" }, method = RequestMethod.GET)
	public String reservarVuelo(ModelMap model) {
		Reserva reserva = new Reserva();
		model.addAttribute("reserva", reserva);
		return "reservarVuelo";
	}
	
	@RequestMapping(value = { "/reservas" }, method = RequestMethod.POST)
	public String guardarReserva(Reserva reserva, BindingResult result, ModelMap model) {
		if(result.hasErrors()){
			System.out.println(result.toString());
			return "reservarVuelo";
		}
		
		boolean reservado=vueloservice.reservarVuelo(reserva.getVuelo().getId(), reserva.getPasajero());
		if(reservado){
			return "reservaExitosa";
		}else{
			return "reservaFallida";
		}
	}
	
	
	@ModelAttribute("ids")
    public List<Pasajero> inicializarIDs() {
        return pasajeroservice.listaPasajeros();
    }
	
	@ModelAttribute("vuelos")
    public List<Vuelo> inicializarVuelos() {
        return vueloservice.listaVuelos();
    }
	
}
