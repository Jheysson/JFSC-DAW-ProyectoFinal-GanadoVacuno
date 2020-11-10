package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.spring5.model.comidaportipo;
import pe.unjfsc.daw.spring5.service.comidaportipoService;

@Controller

public class CCComidaPorTipo {
	private static final Logger log = LoggerFactory.getLogger("CCComidaGanado");
	
    @Autowired
    private comidaportipoService comidaganadoService;
    
    
    @RequestMapping(value = "comidaportipo/ListadoPorTipo")
	public ModelAndView ListadoInseminacion() {
    	ModelAndView model = new ModelAndView();
    	List<comidaportipo> list = comidaganadoService.getAllcomidaportipo();
    	model.addObject("listComidaportipo",list);
    	model.setViewName("listComidaportipo");
		return model;
	}
    
    
   
}

