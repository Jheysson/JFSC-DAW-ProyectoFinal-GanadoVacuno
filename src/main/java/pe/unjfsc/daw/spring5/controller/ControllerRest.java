package pe.unjfsc.daw.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;
import pe.unjfsc.daw.spring5.model.lecheProducidaDia;
import pe.unjfsc.daw.spring5.model.natalidad;
import pe.unjfsc.daw.spring5.model.vacasenproduccionleche;
import pe.unjfsc.daw.spring5.service.GanadoVacunoService;
import pe.unjfsc.daw.spring5.service.lecheProducidaService;
import pe.unjfsc.daw.spring5.service.natalidadService;

@org.springframework.web.bind.annotation.RestController
public class ControllerRest {
	@Autowired
    private natalidadService natalidadService;
	
	@Autowired
	private GanadoVacunoService ganadoVacunoService;
	
	@Autowired
	private lecheProducidaService lecheProducidaService;
	
	
	
	@RequestMapping(value="/buscar/verificarMadre/{cuia}", method=RequestMethod.GET)
    public natalidad getNatalidad(@PathVariable("cuia") int cuia) {
		return natalidadService.findnatalidadByCuia(cuia);
    }
    	
	@RequestMapping(value="/buscar/verificarMadreGanadoVacuno/{cuia}", method=RequestMethod.GET)
    public GanadoVacuno getGanadoVacuno(@PathVariable("cuia") int cuia) {
		return ganadoVacunoService.findGanadoVacunoByCuia(cuia);
    }
	
	@RequestMapping(value="/buscar/verificarVacaLechera/{cuiaGana}", method=RequestMethod.GET)
    public vacasenproduccionleche getLecheProducida(@PathVariable("cuiaGana") int cuia) {
		return lecheProducidaService.findLecheProducidaByCUIA(cuia);
    }
}
