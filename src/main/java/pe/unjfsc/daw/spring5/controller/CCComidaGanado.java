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
import pe.unjfsc.daw.spring5.service.comidaganadoService;

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
    
    
    
    @RequestMapping(value = "comidaganado/agregarComidaGanado", method=RequestMethod.GET)
    public ModelAndView addcomidaganado() {
    	ModelAndView model = new ModelAndView();
    	comidaganado pcomi = new comidaganado();
    	model.addObject("comidaganadoForm",pcomi);
    	model.setViewName("comidaganadoForm");
    	return model;
    }
    
    @RequestMapping(value="comidaganado/save", method=RequestMethod.POST)
	public ModelAndView saveComidaGanado(@ModelAttribute("comidaganadoForm") comidaganado pcomi) {
    	//comidaganadoService.addcomidaganado(pcomi);
    	log.info("save" + pcomi);
		return new ModelAndView("redirect:/comidaganado/ListadoComidaGanado");    
    }
    
    @RequestMapping(value="comidaganado/updateComidaGanado/{idComiGana}", method=RequestMethod.GET)
    public ModelAndView updatecomidaganado(@PathVariable int idComiGana) {
    	ModelAndView model = new ModelAndView();
    	comidaganado pcomi = comidaganadoService.findcomidaganadoById(idComiGana);
    	  model.addObject("comidaganadoFormUpdate", pcomi);
    	  model.setViewName("comidaganadoFormUpdate");
    	  return model;
    	
    }
    
    @RequestMapping(value="comidaganado/update", method=RequestMethod.POST)
	public ModelAndView editarComidaGanado(@ModelAttribute("comidaganadoFormUpdate") comidaganado pcomi) {
    //	comidaganadoService.updatecomidaganado(pcomi);
    	log.info("save" + pcomi);
		return new ModelAndView("redirect:/comidaganado/ListadoComidaGanado");    
    }
    
    
    @RequestMapping(value="/comidaganado/eliminarComidaGanado/{idComiGana}", method=RequestMethod.GET)
    public ModelAndView deleteComidaGanado(@PathVariable("idComiGana") int idComiGana) {
    	//comidaganadoService.deletecomidaganado(idComiGana);
    	return new ModelAndView("redirect:/comidaganado/ListadoComidaGanado"); 
    	
    }
}

