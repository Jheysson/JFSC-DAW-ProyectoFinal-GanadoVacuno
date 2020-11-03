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

import pe.unjfsc.daw.spring5.model.comidaganado;
import pe.unjfsc.daw.spring5.model.inseminacion;
import pe.unjfsc.daw.spring5.service.comidaganadoService;
import pe.unjfsc.daw.spring5.service.inseminacionService;

@Controller

public class CCComidaGanado {
	private static final Logger log = LoggerFactory.getLogger("CCComidaGanado");
	
    @Autowired
    private comidaganadoService comidaganadoService;
    
    
    @RequestMapping(value = "comidaganado/ListadoComidaGanado")
	public ModelAndView ListadoInseminacion() {
    	ModelAndView model = new ModelAndView();
    	List<comidaganado> list = comidaganadoService.getAllcomidaganado();
    	model.addObject("listComidaGanado",list);
    	model.setViewName("listComidaGanado");
		return model;
	}
    
    
    
    
    
    
}

