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

import pe.unjfsc.daw.spring5.model.lecheProducidaDia;
import pe.unjfsc.daw.spring5.service.lecheProducidaService;

@Controller
public class CCLecheProducida {
	private static final Logger log = LoggerFactory.getLogger("CCLecheProducida");

	
	@Autowired
	private lecheProducidaService objLecheProducidaService;
	
	
		@RequestMapping(value = "lecheProducida/ListProducionLeche")
		public ModelAndView listadoLecheProducida() {
			ModelAndView model=new  ModelAndView();
			List<lecheProducidaDia> list = objLecheProducidaService.getAllLecheProducida();
			model.addObject("listLecheProducida",list);
			model.setViewName("listLecheProducida");
			return model;
		}
		
		
		@RequestMapping(value="lecheProducida/agregarLecheProducida", method=RequestMethod.GET)
		public ModelAndView addProduccionLeche() {
			ModelAndView model = new ModelAndView();
			lecheProducidaDia objLecheProducida=new lecheProducidaDia();
			model.addObject("lecheProducidaForm", objLecheProducida);
			model.setViewName("lecheProducidaForm");
			return model;
		}
		
		
		@RequestMapping(value="lecheProducida/save", method=RequestMethod.POST)
		public ModelAndView saveLecheProducida(@ModelAttribute("lecheProducidaForm") lecheProducidaDia objLecheProducidaDia) {
			objLecheProducidaService.addLecheProducida(objLecheProducidaDia);
	    	log.info("[DZS] Guardar ==> : {}" + objLecheProducidaDia);
			return new ModelAndView("redirect:/lecheProducida/ListProducionLeche");
		}
		
		
		@RequestMapping(value="lecheProducida/updateLecheProducida/{idLechProd}", method=RequestMethod.GET)
		public ModelAndView updateLecheProducida(@PathVariable int idLechProd) {
			ModelAndView model = new ModelAndView();
			lecheProducidaDia objLeProducidaDia= objLecheProducidaService.findLecheProducidaById(idLechProd);
			model.addObject("lecheProducidaFormUpdate", objLeProducidaDia);
			model.setViewName("lecheProducidaFormUpdate");
			return model;
		}
		
		@RequestMapping(value = "lecheProducida/update", method=RequestMethod.POST)
		public ModelAndView updateLecheProducida(@ModelAttribute("lecheProducidaFormUpdate") lecheProducidaDia objProducidaDia ) {
			objLecheProducidaService.updateLecheProducida(objProducidaDia);
	    	log.info("[DZS] ACTUALIZAR ==>" + objProducidaDia);

			return new ModelAndView("redirect:/lecheProducida/ListProducionLeche");
		}
	
		@RequestMapping(value = "lecheProducida/eliminarLecheProducida/{idLechProd}", method=RequestMethod.GET)
		public ModelAndView deleteLecheProducida(@PathVariable int idLechProd) {
			objLecheProducidaService.deleteLecheProducida(idLechProd);
			return new ModelAndView("redirect:/lecheProducida/ListProducionLeche");
		}

}










