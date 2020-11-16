package pe.unjfsc.daw.spring5.controller;


import java.util.List;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;
import pe.unjfsc.daw.spring5.service.GanadoVacunoService;

@Controller
public class CCGanadoVacuno {
	
	@Autowired
	private GanadoVacunoService ganadoVacunoService;
	
	
	@RequestMapping(value = "ganadoVacuno/ListadoGanadoVacuno")
	public ModelAndView listarGanado() {		
		ModelAndView model = new ModelAndView();
		List<GanadoVacuno> list = ganadoVacunoService.getAllGanadoVacuno();
		model.addObject("listGanadoVacuno",list);
		model.setViewName("listGanadoVacuno");
		return model;
	}	
}
