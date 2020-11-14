package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.spring5.model.vacadedescarte;
import pe.unjfsc.daw.spring5.service.vacadedescarteService;

@Controller
public class CCVacaDeDescarte {
	private static final Logger log = LoggerFactory.getLogger("CCNatalidad");
	
	@Autowired
	private vacadedescarteService pvacadedescarteService;
	
	 @RequestMapping(value = "vacadedescarte/ListadoVacadeDescarte")
		public ModelAndView ListadoVacadeDescarte() {
	    	ModelAndView model = new ModelAndView();
	    	List<vacadedescarte> list = pvacadedescarteService.getAllVacadeDescarte();
	    	model.addObject("listVacadedescarte",list);
	    	model.setViewName("listVacadeDescarte");
			return model;
		}
	 
	 @PostMapping("vacadedescarte/addVacadeDescarte")
	 public String addVacadeDescarte(vacadedescarte pvacadedescarte) {
		 pvacadedescarteService.addvacadedescarte(pvacadedescarte);
		 return "redirect:/vacadedescarte/ListadoVacadeDescarte";
	 }
	 
	 @RequestMapping(value="vacadedescarte/updatevacadedescarte/{id}", method=RequestMethod.GET)
	    public ModelAndView updateproduccionleche(@PathVariable int id) {
	    	ModelAndView model = new ModelAndView();
	    	vacadedescarte pvacadedescarte = pvacadedescarteService.findvacaDescarteByid(id);
	    	  model.addObject("vacadedescarteUpdate", pvacadedescarte);
	    	  model.setViewName("vacadedescarteUpdate");
	    	  return model;
	    	
	    }
	 
	 @RequestMapping(value="vacadedescarte/Actualizarvacadedescarte", method=RequestMethod.POST)
		public ModelAndView editarVacadeDescarte(@ModelAttribute("vacadedescarteUpdate") vacadedescarte pvacadedescarte) {
		 pvacadedescarteService.updatevacadedescarte(pvacadedescarte);
		 log.info(""+pvacadedescarte.getObse());
		 log.info(""+pvacadedescarte.getIdVacaDesc());
			return new ModelAndView("redirect:/vacadedescarte/ListadoVacadeDescarte");    
	    }
	 
	 @RequestMapping(value="vacadedescarte/eliminarvacadedescarte/{cuia}", method=RequestMethod.GET)
	    public String deleteVacadeDescarte(@PathVariable("cuia") int cuia) {
	    	pvacadedescarteService.deletevacadedescarte(cuia);
	    	return "redirect:/vacadedescarte/ListadoVacadeDescarte";
	    	
	}
}
