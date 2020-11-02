package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;
import pe.unjfsc.daw.spring5.model.natalidad;
import pe.unjfsc.daw.spring5.service.GanadoVacunoService;

@Controller
public class CCGanadoHembra {
	
	private static final Logger log = LoggerFactory.getLogger("CCNatalidad");
	
	@Autowired
	private GanadoVacunoService ganadoVacunoService;
	
	
	@RequestMapping(value = "ganadoVacuno/ListadoGanadoHembra.lhs")
	public ModelAndView listarGanado() {		
		ModelAndView model = new ModelAndView();
		List<GanadoVacuno> list = ganadoVacunoService.getGanadoVacunoHembra();
		model.addObject("listGanadoHembra",list);
		model.setViewName("listGanadoHembra");
		return model;
	}	
	@RequestMapping(value="ganadoVacuno/agregarGanadoHembra", method = RequestMethod.GET)
	public ModelAndView addGanadoHembra() {
		ModelAndView model = new ModelAndView();
		GanadoVacuno pGanadoVacuno = new GanadoVacuno();
		model.addObject("ganadoHembraForm",pGanadoVacuno);
		model.setViewName("ganadoHembraForm");
		return model;
	}
	@RequestMapping(value="ganadoHembra/save", method = RequestMethod.POST)
	public ModelAndView saveGanadoHembra(@ModelAttribute("ganadoHembraForm") GanadoVacuno pGanadoVacuno) {
		ganadoVacunoService.addGanadoVacunoHembra(pGanadoVacuno);
		return new ModelAndView("redirect:ganadoVacuno/ListadoGanadoHembra.lhs");		
	}

}
