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

import pe.unjfsc.daw.spring5.model.GanadoEnfermo;
import pe.unjfsc.daw.spring5.service.GanadoEnfermoService;

@Controller
public class CCGanadoEnfermo {
	private static final Logger log = LoggerFactory.getLogger("CCGanadoEnfermo");
	
	@Autowired
	private GanadoEnfermoService GanadoEnfermoService;
	
	
	@RequestMapping(value = "ganadoEnfermo/ListadoGanadoEnfermo")
	public ModelAndView ListadoGanadoEnfermo() {
    	ModelAndView model = new ModelAndView();
    	List<GanadoEnfermo> list = GanadoEnfermoService.getAllGanadoEnfermo();
    	model.addObject("listGanadoEnfermo",list);
    	model.setViewName("listGanadoEnfermo");
		return model;
	}

    
    @RequestMapping(value = "ganadoEnfermo/agregarGanadoEnfermo", method=RequestMethod.GET)
    public ModelAndView addGanadoEnfermo() {
    	ModelAndView model = new ModelAndView();
    	GanadoEnfermo pGanadoEnfermo = new GanadoEnfermo();
    	model.addObject("ganadoEnfermoForm",pGanadoEnfermo);
    	model.setViewName("ganadoEnfermoForm");
    	return model;
    }
    
    @RequestMapping(value="ganadoEnfermo/save", method=RequestMethod.POST)
	public ModelAndView saveGanadoEnfermo(@ModelAttribute("ganadoEnfermoForm") GanadoEnfermo pGanadoEnfermo) {
    	GanadoEnfermoService.addGanadoEnfermo
    	(pGanadoEnfermo);
    	log.info("save" + pGanadoEnfermo);
		return new ModelAndView("redirect:/ganadoEnfermo/ListadoGanadoEnfermo");    
    }
    
    @RequestMapping(value="ganadoEnfermo/updateGanadoEnfermo/{cuia}", method=RequestMethod.GET)
    public ModelAndView updateGanadoEnfermo(@PathVariable int cuia) {
    	ModelAndView model = new ModelAndView();
    	GanadoEnfermo pGanadoEnfermo = GanadoEnfermoService.findGanadoEnfermoByCuia(cuia);
    	  model.addObject("ganadoEnfermoFormUpdate", pGanadoEnfermo);
    	  model.setViewName("ganadoEnfermoFormUpdate");
    	  return model;
    	
    }
    
    @RequestMapping(value="ganadoEnfermo/update", method=RequestMethod.POST)
	public ModelAndView editarGanadoEnfermo(@ModelAttribute("ganadoEnfermoFormUpdate") GanadoEnfermo pGanadoEnfermo) {
    	GanadoEnfermoService.updateGanadoEnfermo(pGanadoEnfermo);
    	log.info("save" + pGanadoEnfermo);
		return new ModelAndView("redirect:/ganadoEnfermo/ListadoGanadoEnfermo");    
    }
    
    
    @RequestMapping(value="/ganadoEnfermo/eliminarGanadoEnfermo/{cuia}", method=RequestMethod.GET)
    public ModelAndView deleteGanadoEnfermo(@PathVariable("cuia") int cuia) {
    	GanadoEnfermoService.deleteGanadoEnfermo(cuia);
    	return new ModelAndView("redirect:/ganadoEnfermo/ListadoGanadoEnfermo"); 
    	
    }
	
	
	

}











