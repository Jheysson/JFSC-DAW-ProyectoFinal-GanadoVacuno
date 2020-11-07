package pe.unjfsc.daw.spring5.controller;


import java.util.List;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.spring5.model.enfermedad;
import pe.unjfsc.daw.spring5.service.enfermedadService;

@Controller

public class CCEnfermedad {
	//private static final Logger log = LoggerFactory.getLogger("CCEnfermedad");
	
    @Autowired
    private enfermedadService enfermedadService;
    
    
    @RequestMapping(value = "enfermedad/ListadoEnfermedad")
	public ModelAndView ListadoEnfermedad() {
    	ModelAndView model = new ModelAndView();
    	List<enfermedad> list = enfermedadService.getAllenfermedad();
    	model.addObject("listEnfermedad",list);
    	model.setViewName("listEnfermedad");
		return model;
	}
    
    
    
    
    
    
}

