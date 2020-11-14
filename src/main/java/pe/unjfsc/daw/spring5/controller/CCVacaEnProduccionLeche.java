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

import pe.unjfsc.daw.spring5.model.vacasenproduccionleche;
import pe.unjfsc.daw.spring5.service.VacaEnProducciondeLecheService;

@Controller
@RequestMapping(value = "vacasenproduccionleche")
public class CCVacaEnProduccionLeche {
	private static final Logger log = LoggerFactory.getLogger("CCVacaEnProduccionLeche");
	
	@Autowired
	private VacaEnProducciondeLecheService pVacaEnProducciondeLecheService;

	@RequestMapping(value = "/ListadoVacadeProducciondeLeche")
	public ModelAndView ListadoVacadeProduccionLeche() {
		ModelAndView model = new ModelAndView();
		List<vacasenproduccionleche> list = pVacaEnProducciondeLecheService.getAllVacadeProduccionLeche();
		model.addObject("listVacaProduccionLeche", list);
		model.setViewName("listVacaenProducciondeLeche");
		return model;
	}

	@PostMapping("/addVacadeProducciondeLeche")
	public String addVacadeProducciondeLeche(vacasenproduccionleche pvacasenproduccionleche) {
		pVacaEnProducciondeLecheService.addvacasenproduccionleche(pvacasenproduccionleche);
		return "redirect:/vacasenproduccionleche/ListadoVacadeProducciondeLeche";
	}
	
	
	@RequestMapping(value="/updatevacasenproduccionleche/{id}", method=RequestMethod.GET)
    public ModelAndView updateproduccionleche(@PathVariable int id) {
    	ModelAndView model = new ModelAndView();
    	vacasenproduccionleche pvacasenproduccionleche = pVacaEnProducciondeLecheService.findvacaDeProduccionLecheByid(id);
    	  model.addObject("VacaenProducciondeLecheFormUpdate", pvacasenproduccionleche);
    	  model.setViewName("VacaenProducciondeLecheFormUpdate");
    	  return model;
    	
    }
    
    @RequestMapping(value="/ActualizarVacadeProducciondeLeche", method=RequestMethod.POST)
	public ModelAndView editarproduccionleche(@ModelAttribute("VacaenProducciondeLecheFormUpdate") vacasenproduccionleche pvacasenproduccionleche) {
    	pVacaEnProducciondeLecheService.updatevacasenproduccionleche(pvacasenproduccionleche);
    	log.info(""+pvacasenproduccionleche.getObservacion());
		 log.info(""+pvacasenproduccionleche.getIdVacaProd());
		return new ModelAndView("redirect:/vacasenproduccionleche/ListadoVacadeProducciondeLeche");    
    }
	
	
	
	
	@RequestMapping(value="/eliminarvacasenproduccionleche/{id}", method=RequestMethod.GET)
    public String deletevacasenproduccionleche(@PathVariable("id") int id) {
		pVacaEnProducciondeLecheService.deletevacasenproduccionleche(id);
		return "redirect:/vacasenproduccionleche/ListadoVacadeProducciondeLeche";
    	
}
}
