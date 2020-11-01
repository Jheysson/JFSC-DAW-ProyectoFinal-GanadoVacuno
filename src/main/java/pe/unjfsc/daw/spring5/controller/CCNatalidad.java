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

import pe.unjfsc.daw.spring5.model.natalidad;
import pe.unjfsc.daw.spring5.service.natalidadService;

@Controller
public class CCNatalidad {
	private static final Logger log = LoggerFactory.getLogger("CCNatalidad");
	
    @Autowired
    private natalidadService natalidadService;
    
    @RequestMapping("/")
    public String inicio() {
        return "index";
    }
    
    @RequestMapping(value = "natalidad/ListadoNatalidad")
	public ModelAndView ListadoNatalidad() {
    	ModelAndView model = new ModelAndView();
    	List<natalidad> list = natalidadService.getAllNatalidad();
    	model.addObject("listNatalidad",list);
    	model.setViewName("listNatalidad");
		return model;
	}
    
    @RequestMapping(value = "/ganadoEnfermo")
	public String ListadoGanadoEnfermo() {
		return "listGanadoEnfermo";
	}
    
    @RequestMapping(value = "natalidad/agregarNatalidad", method=RequestMethod.GET)
    public ModelAndView addNatalidad() {
    	ModelAndView model = new ModelAndView();
    	natalidad pnatalidad = new natalidad();
    	model.addObject("natalidadForm",pnatalidad);
    	model.setViewName("natalidadForm");
    	return model;
    }
    
    @RequestMapping(value="natalidad/save", method=RequestMethod.POST)
	public ModelAndView saveNatalidad(@ModelAttribute("natalidadForm") natalidad pnatalidad) {
    	natalidadService.addnatalidad(pnatalidad);
    	log.info("save" + pnatalidad);
		return new ModelAndView("redirect:/natalidad/ListadoNatalidad");    
    }
    
    @RequestMapping(value="natalidad/updateNatalidad/{cuia}", method=RequestMethod.GET)
    public ModelAndView updateNatalidad(@PathVariable int cuia) {
    	ModelAndView model = new ModelAndView();
    	natalidad pnatalidad = natalidadService.findnatalidadByCuia(cuia);
    	  model.addObject("natalidadFormUpdate", pnatalidad);
    	  model.setViewName("natalidadFormUpdate");
    	  return model;
    	
    }
    
    @RequestMapping(value="natalidad/update", method=RequestMethod.POST)
	public ModelAndView editarNatalidad(@ModelAttribute("natalidadFormUpdate") natalidad pnatalidad) {
    	natalidadService.updatenatalidad(pnatalidad);
    	log.info("save" + pnatalidad);
		return new ModelAndView("redirect:/natalidad/ListadoNatalidad");    
    }
    
    
    @RequestMapping(value="/natalidad/eliminarNatalidad/{cuia}", method=RequestMethod.GET)
    public ModelAndView deleteNatalidad(@PathVariable("cuia") int cuia) {
    	natalidadService.deletenatalidad(cuia);
    	return new ModelAndView("redirect:/natalidad/ListadoNatalidad"); 
    	
    }
}

