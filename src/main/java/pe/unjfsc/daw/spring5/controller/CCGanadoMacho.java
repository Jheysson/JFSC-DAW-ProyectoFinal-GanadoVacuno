package pe.unjfsc.daw.spring5.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pe.unjfsc.daw.spring5.model.GanadoVacunoMacho;
import pe.unjfsc.daw.spring5.service.GanadoVacunoMachoService;


@Controller
public class CCGanadoMacho {
	
	@Autowired
	private GanadoVacunoMachoService ganadoVacunoMachoService;
	
	
	@RequestMapping(value = "ganadoVacuno/ListadoGanadoMacho")
	public ModelAndView listarGanado() {		
		ModelAndView model = new ModelAndView();
		List<GanadoVacunoMacho> list = ganadoVacunoMachoService.getGanadoVacunoMacho();
		model.addObject("listGanadoMacho",list);
		model.setViewName("listGanadoMacho");
		return model;
	}	
	@RequestMapping(value="ganadoVacuno/agregarGanadoMacho", method = RequestMethod.GET)
	public ModelAndView addGanadoMacho() {
		ModelAndView model = new ModelAndView();
		GanadoVacunoMacho pGanadoVacunoMacho = new GanadoVacunoMacho();
		model.addObject("ganadoMachoForm",pGanadoVacunoMacho);
		model.setViewName("ganadoMachoForm");
		return model;
	}
	@RequestMapping(value="ganadoMacho/save", method = RequestMethod.POST)
	public ModelAndView saveGanadoMacho(@RequestParam(name="file", required=false) MultipartFile imagen, GanadoVacunoMacho pGanadoVacunoMacho) {
		if (!imagen.isEmpty()) {
			String ruta = "C://temp//uploads";
			try {
				byte[] bytes = imagen.getBytes();
				Path rutaAbsoluta = Paths.get(ruta+"//"+imagen.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				pGanadoVacunoMacho.setImagen(imagen.getOriginalFilename());
			} catch (Exception e) {
			}
			ganadoVacunoMachoService.addGanadoVacunoMacho(pGanadoVacunoMacho);
		}else {
			ganadoVacunoMachoService.addGanadoVacunoMacho(pGanadoVacunoMacho);
		}
		
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoMacho");		
	}
	@RequestMapping(value = "ganadoVacuno/updateGanadoMacho/{cuia}", method = RequestMethod.GET)
	public ModelAndView updateGanadoMacho(@PathVariable int cuia) {
		ModelAndView model = new ModelAndView();
		GanadoVacunoMacho pGanadoVacuno = ganadoVacunoMachoService.findGanadoVacunoByCuia(cuia);
		model.addObject("ganadoMachoFormUpdate",pGanadoVacuno);
		model.setViewName("ganadoMachoFormUpdate");
		return model;
	}
	@RequestMapping(value = "ganadoVacuno/updateGMacho", method = RequestMethod.POST)
	public ModelAndView editarGanadoMacho(@ModelAttribute("ganadoMachoFormUpdate") GanadoVacunoMacho pGanadoVacunoMacho) {
		ganadoVacunoMachoService.updateGanadoVacunoMacho(pGanadoVacunoMacho);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoMacho");
	}
	
	@RequestMapping(value = "/ganadoVacuno/eliminarGanadoMacho/{cuia}", method = RequestMethod.GET)
	public ModelAndView deleteGanadoMacho(@PathVariable("cuia") int cuia) {
		ganadoVacunoMachoService.deleteGanadoVacunoMacho(cuia);
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoMacho");
	}
	///ganadoVacuno/UpdateAllMachos
	@RequestMapping(value = "/ganadoVacuno/UpdateAllMachos", method = RequestMethod.GET)
	public ModelAndView updateAllMachos() {
		ganadoVacunoMachoService.updateAllMachos();
		return new ModelAndView("redirect:/ganadoVacuno/ListadoGanadoMacho");
	}

}
