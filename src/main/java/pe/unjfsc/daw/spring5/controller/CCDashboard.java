package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.unjfsc.daw.spring5.model.cantidadMesProduccionLeche;
import pe.unjfsc.daw.spring5.model.totalLecheProduccida;
import pe.unjfsc.daw.spring5.service.cantidadMesProduccionLecheService;
import pe.unjfsc.daw.spring5.service.totalLecheProduccidaService;

@RestController
public class CCDashboard {
	@Autowired
	private totalLecheProduccidaService ptotalLecheProduccidaService;
	
	@Autowired
	private cantidadMesProduccionLecheService pcantidadMesProduccionLecheService;
	
	@RequestMapping(value="/leche/total", method=RequestMethod.GET)
	public List<totalLecheProduccida> getDataFromDB() {
		return ptotalLecheProduccidaService.getAllAño();
	}
	
	@RequestMapping(value="/leche/mesAndCantidad", method=RequestMethod.GET)
	public List<cantidadMesProduccionLeche> getDataMesCantidad() {
		return pcantidadMesProduccionLecheService.getMesAndCantidad();
	}
}
