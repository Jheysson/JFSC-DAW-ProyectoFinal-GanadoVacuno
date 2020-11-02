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

import pe.unjfsc.daw.spring5.model.inseminacion;
import pe.unjfsc.daw.spring5.service.inseminacionService;

@Controller

public class CCInseminacion {
	private static final Logger log = LoggerFactory.getLogger("CCInseminacion");
	
    @Autowired
    private inseminacionService inseminacionService;
    
    
    @RequestMapping(value = "inseminacion/ListadoInseminacion")
	public ModelAndView ListadoInseminacion() {
    	ModelAndView model = new ModelAndView();
    	List<inseminacion> list = inseminacionService.getAllInseminacion();
    	model.addObject("listInseminacion",list);
    	model.setViewName("listInseminacion");
		return model;
	}
    
    
    
    @RequestMapping(value = "inseminacion/agregarInseminacion", method=RequestMethod.GET)
    public ModelAndView addInseminacion() {
    	ModelAndView model = new ModelAndView();
    	inseminacion pinse = new inseminacion();
    	model.addObject("inseminacionForm",pinse);
    	model.setViewName("inseminacionForm");
    	return model;
    }
    
    @RequestMapping(value="inseminacion/save", method=RequestMethod.POST)
	public ModelAndView saveInseminacion(@ModelAttribute("inseminacionForm") inseminacion pinse) {
    	inseminacionService.addinseminacion(pinse);
    	log.info("save" + pinse);
		return new ModelAndView("redirect:/inseminacion/ListadoInseminacion");    
    }
    
    @RequestMapping(value="inseminacion/updateInseminacion/{codiPropInse}", method=RequestMethod.GET)
    public ModelAndView updateInseminacion(@PathVariable int codiPropInse) {
    	ModelAndView model = new ModelAndView();
    	inseminacion pinse = inseminacionService.findinseminacionByCodigo(codiPropInse);
    	  model.addObject("inseminacionFormUpdate", pinse);
    	  model.setViewName("inseminacionFormUpdate");
    	  return model;
    	
    }
    
    @RequestMapping(value="inseminacion/update", method=RequestMethod.POST)
	public ModelAndView editarInseminacion(@ModelAttribute("inseminacionFormUpdate") inseminacion pinse) {
    	inseminacionService.updateinseminacion(pinse);
    	log.info("save" + pinse);
		return new ModelAndView("redirect:/inseminacion/ListadoInseminacion");    
    }
    
    
    @RequestMapping(value="/inseminacion/eliminarInseminacion/{codiPropInse}", method=RequestMethod.GET)
    public ModelAndView deleteInseminacion(@PathVariable("codiPropInse") int codiPropInse) {
    	inseminacionService.deleteinseminacion(codiPropInse);
    	return new ModelAndView("redirect:/inseminacion/ListadoInseminacion"); 
    	
    }
}

