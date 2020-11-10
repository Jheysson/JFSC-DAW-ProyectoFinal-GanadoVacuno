package pe.unjfsc.daw.spring5.controller;

import java.util.List;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;
import pe.unjfsc.daw.spring5.service.GanadoVacunoHembraService;

@Controller
public class CCGanadoHembra {
	
	//private static final Logger log = LoggerFactory.getLogger("CCNatalidad");
	
	@Autowired
	private GanadoVacunoHembraService ganadoVacunoHembraService;
	
	
	@RequestMapping(value = "ganadoVacuno/ListadoGanadoHembra.lhs")
	public ModelAndView listarGanado() {		
		ModelAndView model = new ModelAndView();
		List<GanadoVacunoHembra> list = ganadoVacunoHembraService.getGanadoVacunoHembra();
		model.addObject("listGanadoHembra",list);
		model.setViewName("listGanadoHembra");
		return model;
	}	
	
	@RequestMapping(value = "listarHembras")
	public ModelAndView listarGanadoMadres() {
		ModelAndView model = new ModelAndView();
		List<GanadoVacunoHembra> list = ganadoVacunoHembraService.getGanadoVacunoHembra();
		model.addObject("listGanadoHembra",list);
		model.setViewName("listGanadoHembra");
		return model;
	}
	
	
	@RequestMapping(value="ganadoVacuno/agregarGanadoHembra", method = RequestMethod.GET)
	public ModelAndView addGanadoHembra() {
		ModelAndView model = new ModelAndView();
		GanadoVacunoHembra pGanadoVacunoHembra = new GanadoVacunoHembra();
		model.addObject("ganadoHembraForm",pGanadoVacunoHembra);
		model.setViewName("ganadoHembraForm");
		return model;
	}
	@RequestMapping(value="ganadoHembra/save", method = RequestMethod.POST)
	public ModelAndView saveGanadoHembra(@ModelAttribute("ganadoHembraForm") GanadoVacunoHembra pGanadoVacunoHembra) {
		ganadoVacunoHembraService.addGanadoVacunoHembra(pGanadoVacunoHembra);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoHembra.lhs");		
	}
	
	
	
	@RequestMapping(value = "ganadoVacuno/updateGanadoHembra/{cuia}", method = RequestMethod.GET)
	public ModelAndView updateGanadoHembra(@PathVariable int cuia) {
		ModelAndView model = new ModelAndView();
		GanadoVacunoHembra pGanadoVacunoHembra = ganadoVacunoHembraService.findGanadoVacunoByCuia(cuia);
		model.addObject("ganadoHembraFormUpdate",pGanadoVacunoHembra);
		model.setViewName("ganadoHembraFormUpdate");
		return model;
	}
	
	@RequestMapping(value = "ganadoVacuno/updateGHembra", method = RequestMethod.POST)
	public ModelAndView editarGanadoHembra(@ModelAttribute("ganadoHembraFormUpdate") GanadoVacunoHembra pGanadoVacunoHembra) {
		ganadoVacunoHembraService.updateGanadoVacunoHembra(pGanadoVacunoHembra);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoHembra.lhs");
	}
	
	@RequestMapping(value = "/ganadoVacuno/eliminarGanadoHembra/{cuia}", method = RequestMethod.GET)
	public ModelAndView deleteGanadoHembra(@PathVariable("cuia") int cuia) {
		ganadoVacunoHembraService.deleteGanadoVacunoHembra(cuia);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoHembra.lhs");
	}
	@RequestMapping(value = "/ganadoVacuno/UpdateAllHembras", method = RequestMethod.GET)
	public ModelAndView updateAllHembras() {
		ganadoVacunoHembraService.updateAllHembras();
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoHembra.lhs");
	}
	
	//public ResponseEntity<Boolean> validadHembraApta(@PathVariable("cuia") int cuia) {
	/*@RequestMapping(value ="/consultar", method = RequestMethod.POST)
	
	
	public ResponseEntity<Boolean> validadHembraApta(@RequestBody int cuia) {
		boolean apta = false;
		GanadoVacuno pGanadoVacuno = ganadoVacunoService.findHembrasAptas(cuia);
		log.info("HEMBRA APTA ENCONTRADA: {}", pGanadoVacuno);
		if (pGanadoVacuno == null) {
			apta = false;
		}else {
			apta = true;
		}
		//return apta;
	    return new ResponseEntity<Boolean>(apta, HttpStatus.OK);

	}
	/*
	@RequestMapping(value="/natalidad/eliminarNatalidad/{cuia}", method=RequestMethod.GET)
    public ModelAndView deleteNatalidad(@PathVariable("cuia") int cuia) {
    	natalidadService.deletenatalidad(cuia);
    	return new ModelAndView("redirect:/natalidad/ListadoNatalidad"); 
    	
    }
	 * */

}
