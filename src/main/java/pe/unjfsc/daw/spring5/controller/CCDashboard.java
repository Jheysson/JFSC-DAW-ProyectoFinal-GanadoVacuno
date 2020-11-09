package pe.unjfsc.daw.spring5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.unjfsc.daw.spring5.model.lecheProducidaDia;
import pe.unjfsc.daw.spring5.service.lecheProducidaService;

@RestController
public class CCDashboard {
	@Autowired
	private lecheProducidaService plecheProducidaService;
	
	@RequestMapping(value="/dashboard/linechartdata", method=RequestMethod.GET)
	public List<lecheProducidaDia> getDataFromDB() {
		return plecheProducidaService.getAllLecheProducida();
	}
}
