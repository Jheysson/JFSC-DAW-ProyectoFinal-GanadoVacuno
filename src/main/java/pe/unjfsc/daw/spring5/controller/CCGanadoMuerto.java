package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.unjfsc.daw.spring5.model.ganadoMuerto;
import pe.unjfsc.daw.spring5.service.ganadoMuertoService;

@Controller
@RequestMapping(value = "ganadoMuerto")
public class CCGanadoMuerto {

	@Autowired
	private ganadoMuertoService pganadoMuerto;
	
	 @RequestMapping(value = "/ListadoGanadoMuerto")
		public ModelAndView ListadoVacadeDescarte() {
	    	ModelAndView model = new ModelAndView();
	    	List<ganadoMuerto> list = pganadoMuerto.getAllGanadoMuerto();
	    	model.addObject("listGanadoMuerto",list);
	    	model.setViewName("listGanadoMuerto");
			return model;
		}
	 @PostMapping("/addGanadoMuerto")
	 public String addVacadeDescarte(ganadoMuerto objganadoMuerto) {
		pganadoMuerto.addGanadoMuerto(objganadoMuerto);
		 return "redirect:/ganadoMuerto/ListadoGanadoMuerto";
	 }
	 @RequestMapping(value="/eliminarganadoMuerto/{idGanaMuer}", method=RequestMethod.GET)
	    public String deleteGanadoMuerto(@PathVariable("idGanaMuer") int id) {
	    pganadoMuerto.deleteGanadoMuerto(id);	
	    	return "redirect:/ganadoMuerto/ListadoGanadoMuerto";
	 
}
}
