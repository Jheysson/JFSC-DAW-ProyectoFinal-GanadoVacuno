package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.spring5.model.vacadedescarte;
import pe.unjfsc.daw.spring5.service.vacadedescarteService;

@Controller
@RequestMapping(value = "vacadedescarte")
public class CCVacaDeDescarte {

	@Autowired
	private vacadedescarteService pvacadedescarteService;
	
	 @RequestMapping(value = "/ListadoVacadeDescarte")
		public ModelAndView ListadoVacadeDescarte() {
	    	ModelAndView model = new ModelAndView();
	    	List<vacadedescarte> list = pvacadedescarteService.getAllVacadeDescarte();
	    	model.addObject("listVacadedescarte",list);
	    	model.setViewName("listVacadeDescarte");
			return model;
		}
	 
	 @PostMapping("/addVacadeDescarte")
	 public String addVacadeDescarte(vacadedescarte pvacadedescarte) {
		 pvacadedescarteService.addvacadedescarte(pvacadedescarte);
		 return "redirect:/vacadedescarte/ListadoVacadeDescarte";
	 }
	 
	 @RequestMapping(value="/eliminarvacadedescarte/{cuia}", method=RequestMethod.GET)
	    public String deleteVacadeDescarte(@PathVariable("cuia") int cuia) {
	    	pvacadedescarteService.deletevacadedescarte(cuia);
	    	return "redirect:/vacadedescarte/ListadoVacadeDescarte";
	    	
	}
}
