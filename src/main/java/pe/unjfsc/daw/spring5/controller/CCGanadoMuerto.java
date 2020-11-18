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

import pe.unjfsc.daw.spring5.model.GanadoMuerto;
import pe.unjfsc.daw.spring5.service.GanadoMuertoService;

@Controller
public class CCGanadoMuerto {
	private static final Logger log = LoggerFactory.getLogger("CCGanadoMuerto");
	
	@Autowired
	private GanadoMuertoService GanadoMuertoService;
	
	 @RequestMapping(value = "ganadoMuerto/ListadoGanadoMuerto")
		public ModelAndView ListadoGanadoMuerto() {
	    	ModelAndView model = new ModelAndView();
	    	List<GanadoMuerto> list = GanadoMuertoService.getAllGanadoMuerto();
	    	model.addObject("listGanadoMuerto",list);
	    	model.setViewName("listGanadoMuerto");
			return model;
		}
	 @RequestMapping(value = "ganadoMuerto/agregarGanadoMuerto", method=RequestMethod.GET)
	 public ModelAndView addGanadoMuerto() {
		 ModelAndView model = new ModelAndView();
		 GanadoMuerto pGanadoMuerto = new GanadoMuerto();
		 model.addObject("ganadoMuertoForm", pGanadoMuerto);
		 model.setViewName("ganadoMuertoForm");
		 return model;
	 }
	 
	 @RequestMapping(value="ganadoMuerto/save", method=RequestMethod.POST)
	 public ModelAndView saveGanadoMuerto(@ModelAttribute("ganadoMuertoForm") GanadoMuerto pGanadoMuerto) {
		 GanadoMuertoService.addGanadoMuerto
		 (pGanadoMuerto);
		 log.info("save" + pGanadoMuerto);
		 return new ModelAndView("redirect:/ganadoMuerto/ListadoGanadoMuerto");
	 }
	 
}
