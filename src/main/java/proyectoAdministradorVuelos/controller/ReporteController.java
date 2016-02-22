package proyectoAdministradorVuelos.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import proyectoAdministradorVuelos.model.Avion;
import proyectoAdministradorVuelos.model.Parametros;
import proyectoAdministradorVuelos.model.Reporte;
import proyectoAdministradorVuelos.service.AvionService;
import proyectoAdministradorVuelos.service.VueloService;

@Controller
public class ReporteController {

	@Autowired
	private VueloService vueloservice;
	@Autowired
	private AvionService avionservice;
	
	@RequestMapping(value = { "/reporte" }, method = RequestMethod.GET)
	public String generarReporte(ModelMap model) {
		Parametros parametros= new Parametros();
		model.addAttribute("parametros", parametros);
		return "generarReporte";
	}
	
	@RequestMapping(value = { "/reporte" }, method = RequestMethod.POST)
	public String crearReporte(Parametros parametros, BindingResult result, ModelMap model) {
		if(result.hasErrors()){
			System.out.println(result.toString());
			return "generarReporte";
		}
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		Date dateInicial;
		try {
			dateInicial = format.parse(parametros.getFechaInicial());
			Date dateFinal = format.parse(parametros.getFechaFinal());
			java.sql.Date dateI= new java.sql.Date(dateInicial.getTime()); 
			java.sql.Date dateF= new java.sql.Date(dateFinal.getTime());
			List<Reporte> reportes=vueloservice.generarReporte(dateI, dateF, parametros.getAvion());
			model.addAttribute("reportes", reportes);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "reportegenerado";
	}
	
	@ModelAttribute("aviones")
    public List<Avion> inicializarAviones() {
        return avionservice.listaAviones();
    }
	
	
}
