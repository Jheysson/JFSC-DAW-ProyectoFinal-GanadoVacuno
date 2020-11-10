package pe.unjfsc.daw.spring5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.impl.GanadoVacunoHembraDaoImpl;
import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;
import pe.unjfsc.daw.spring5.service.GanadoVacunoHembraService;

@Service
public class GanadoVacunoHembraServiceImpl implements GanadoVacunoHembraService{

	@Autowired
	private GanadoVacunoHembraDaoImpl pGanadoHembra;
	
	@Override
	public List<GanadoVacunoHembra> getGanadoVacunoHembra() {
		return pGanadoHembra.getGanadoVacunoHembra();
	}

	@Override
	public GanadoVacunoHembra findGanadoVacunoByCuia(int cuia) {
		return pGanadoHembra.findGanadoVacunoByCuia(cuia);
	}

	@Override
	public void addGanadoVacunoHembra(GanadoVacunoHembra pGanadoVacunoHembra) {
		pGanadoHembra.addGanadoVacunoHembra(pGanadoVacunoHembra);
		
	}

	@Override
	public void updateGanadoVacunoHembra(GanadoVacunoHembra pGanadoVacunoHembra) {
		pGanadoHembra.updateGanadoVacunoHembra(pGanadoVacunoHembra);
		
	}

	@Override
	public void deleteGanadoVacunoHembra(int cuia) {
		pGanadoHembra.deleteGanadoVacunoHembra(cuia);
		
	}

	@Override
	public void updateAllHembras() {
		pGanadoHembra.updateAllHembras();
		
	}

}
