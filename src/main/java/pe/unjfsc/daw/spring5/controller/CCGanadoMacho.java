package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;
import pe.unjfsc.daw.spring5.model.natalidad;
import pe.unjfsc.daw.spring5.service.GanadoVacunoService;

@Controller
public class CCGanadoMacho {
private static final Logger log = LoggerFactory.getLogger("CCNatalidad");
	
	@Autowired
	private GanadoVacunoService ganadoVacunoService;
	
	
	@RequestMapping(value = "ganadoVacuno/ListadoGanadoMacho.lhs")
	public ModelAndView listarGanado() {		
		ModelAndView model = new ModelAndView();
		List<GanadoVacuno> list = ganadoVacunoService.getGanadoVacunoMacho();
		model.addObject("listGanadoMacho",list);
		model.setViewName("listGanadoMacho");
		return model;
	}	
	@RequestMapping(value="ganadoVacuno/agregarGanadoMacho", method = RequestMethod.GET)
	public ModelAndView addGanadoMacho() {
		ModelAndView model = new ModelAndView();
		GanadoVacuno pGanadoVacuno = new GanadoVacuno();
		model.addObject("ganadoMachoForm",pGanadoVacuno);
		model.setViewName("ganadoMachoForm");
		return model;
	}
	@RequestMapping(value="ganadoMacho/save", method = RequestMethod.POST)
	public ModelAndView saveGanadoMacho(@ModelAttribute("ganadoMachoForm") GanadoVacuno pGanadoVacuno) {
		ganadoVacunoService.addGanadoVacunoMacho(pGanadoVacuno);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoMacho.lhs");		
	}
	
	
	/*
	@RequestMapping(value="natalidad/updateNatalidad/{cuia}", method=RequestMethod.GET)
    public ModelAndView updateNatalidad(@PathVariable int cuia) {
    	ModelAndView model = new ModelAndView();
    	natalidad pnatalidad = natalidadService.findnatalidadByCuia(cuia);
    	  model.addObject("natalidadFormUpdate", pnatalidad);
    	  model.setViewName("natalidadFormUpdate");
    	  return model;
    	
    }
    
    @RequestMapping(value="natalidad/update", method=RequestMethod.POST)
	public ModelAndView editarNatalidad(@ModelAttribute("natalidadFormUpdate") natalidad pnatalidad) {
    	natalidadService.updatenatalidad(pnatalidad);
    	log.info("save" + pnatalidad);
		return new ModelAndView("redirect:/natalidad/ListadoNatalidad");    
    }
	 * */
}
