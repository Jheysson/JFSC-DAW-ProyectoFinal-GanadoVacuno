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
import pe.unjfsc.daw.spring5.model.GanadoVacunoMacho;
import pe.unjfsc.daw.spring5.model.natalidad;
import pe.unjfsc.daw.spring5.service.GanadoVacunoMachoService;
import pe.unjfsc.daw.spring5.service.GanadoVacunoService;

@Controller
public class CCGanadoMacho {
private static final Logger log = LoggerFactory.getLogger("CCNatalidad");
	
	@Autowired
	private GanadoVacunoMachoService ganadoVacunoMachoService;
	
	
	@RequestMapping(value = "ganadoVacuno/ListadoGanadoMacho.lhs")
	public ModelAndView listarGanado() {		
		ModelAndView model = new ModelAndView();
		List<GanadoVacunoMacho> list = ganadoVacunoMachoService.getGanadoVacunoMacho();
		model.addObject("listGanadoMacho",list);
		model.setViewName("listGanadoMacho");
		return model;
	}	
	@RequestMapping(value="ganadoVacuno/agregarGanadoMacho", method = RequestMethod.GET)
	public ModelAndView addGanadoMacho() {
		ModelAndView model = new ModelAndView();
		GanadoVacunoMacho pGanadoVacunoMacho = new GanadoVacunoMacho();
		model.addObject("ganadoMachoForm",pGanadoVacunoMacho);
		model.setViewName("ganadoMachoForm");
		return model;
	}
	@RequestMapping(value="ganadoMacho/save", method = RequestMethod.POST)
	public ModelAndView saveGanadoMacho(@ModelAttribute("ganadoMachoForm") GanadoVacunoMacho pGanadoVacunoMacho) {
		ganadoVacunoMachoService.addGanadoVacunoMacho(pGanadoVacunoMacho);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoMacho.lhs");		
	}
	@RequestMapping(value = "ganadoVacuno/updateGanadoMacho/{cuia}", method = RequestMethod.GET)
	public ModelAndView updateGanadoMacho(@PathVariable int cuia) {
		ModelAndView model = new ModelAndView();
		GanadoVacunoMacho pGanadoVacuno = ganadoVacunoMachoService.findGanadoVacunoByCuia(cuia);
		model.addObject("ganadoMachoFormUpdate",pGanadoVacuno);
		model.setViewName("ganadoMachoFormUpdate");
		return model;
	}
	@RequestMapping(value = "ganadoVacuno/updateGMacho", method = RequestMethod.POST)
	public ModelAndView editarGanadoMacho(@ModelAttribute("ganadoMachoFormUpdate") GanadoVacunoMacho pGanadoVacunoMacho) {
		ganadoVacunoMachoService.addGanadoVacunoMacho(pGanadoVacunoMacho);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoMacho.lhs");
	}
	
	@RequestMapping(value = "/ganadoVacuno/eliminarGanadoMacho/{cuia}", method = RequestMethod.GET)
	public ModelAndView deleteGanadoMacho(@PathVariable("cuia") int cuia) {
		ganadoVacunoMachoService.deleteGanadoVacunoMacho(cuia);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoMacho.lhs");
	}

}
