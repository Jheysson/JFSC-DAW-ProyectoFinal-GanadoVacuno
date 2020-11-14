package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;
import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;
import pe.unjfsc.daw.spring5.model.GanadoVacunoMacho;
import pe.unjfsc.daw.spring5.model.cantidadMesProduccionLeche;
import pe.unjfsc.daw.spring5.model.totalLecheProduccida;
import pe.unjfsc.daw.spring5.service.GanadoVacunoHembraService;
import pe.unjfsc.daw.spring5.service.GanadoVacunoMachoService;
import pe.unjfsc.daw.spring5.service.GanadoVacunoService;
import pe.unjfsc.daw.spring5.service.cantidadMesProduccionLecheService;
import pe.unjfsc.daw.spring5.service.totalLecheProduccidaService;

@RestController
public class CCDashboard {
	@Autowired
	private totalLecheProduccidaService ptotalLecheProduccidaService;
	
	@Autowired
	private cantidadMesProduccionLecheService pcantidadMesProduccionLecheService;
	
	@Autowired
	private GanadoVacunoService pGanadoVacunoService;
	
	@Autowired
	private GanadoVacunoHembraService pGanadoVacunoHembraService;
	
	@Autowired
	private GanadoVacunoMachoService pGanadoVacunoMachoService;
	
	@RequestMapping(value="/leche/total", method=RequestMethod.GET)
	public List<totalLecheProduccida> getDataFromDB() {
		return ptotalLecheProduccidaService.getAllAño();
	}
	
	@RequestMapping(value="/leche/mesAndCantidad", method=RequestMethod.GET)
	public List<cantidadMesProduccionLeche> getDataMesCantidad() {
		return pcantidadMesProduccionLecheService.getMesAndCantidad();
	}
	
	@RequestMapping(value="/leche/mesAndCantidad1", method=RequestMethod.GET)
	public List<cantidadMesProduccionLeche> getDataMesCantidad1() {
		return pcantidadMesProduccionLecheService.getMesAndCantidad();
	}
	
	@RequestMapping(value="/TotaldeRegistros", method=RequestMethod.GET)
	public List<GanadoVacuno> getDataRegistros() {
		return pGanadoVacunoService.getAllGanadoVacuno();
	}
	
	@RequestMapping(value="/TotaldeRegistrosMacho", method=RequestMethod.GET)
	public List<GanadoVacunoMacho> getDataRegistrosMacho() {
		return pGanadoVacunoMachoService.getGanadoVacunoMacho();
	}
	
	@RequestMapping(value="/TotaldeRegistrosHembra", method=RequestMethod.GET)
	public List<GanadoVacunoHembra> getDataRegistrosHembra() {
		return pGanadoVacunoHembraService.getGanadoVacunoHembra();
	}
}
