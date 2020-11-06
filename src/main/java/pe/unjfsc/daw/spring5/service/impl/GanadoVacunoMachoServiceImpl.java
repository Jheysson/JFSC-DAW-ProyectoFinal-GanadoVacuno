package pe.unjfsc.daw.spring5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.impl.GanadoVacunoMachoDaoImpl;
import pe.unjfsc.daw.spring5.model.GanadoVacunoMacho;
import pe.unjfsc.daw.spring5.service.GanadoVacunoMachoService;

@Service
public class GanadoVacunoMachoServiceImpl implements GanadoVacunoMachoService{

	@Autowired
	private GanadoVacunoMachoDaoImpl pGanadoMacho;
	
	@Override
	public List<GanadoVacunoMacho> getGanadoVacunoMacho() {
		return pGanadoMacho.getGanadoVacunoMacho();
	}

	@Override
	public GanadoVacunoMacho findGanadoVacunoByCuia(int cuia) {
		return pGanadoMacho.findGanadoVacunoByCuia(cuia);
	}

	@Override
	public void addGanadoVacunoMacho(GanadoVacunoMacho pGanadoVacunoMacho) {
		pGanadoMacho.addGanadoVacunoMacho(pGanadoVacunoMacho);
		
	}

	@Override
	public void updateGanadoVacunoMacho(GanadoVacunoMacho pGanadoVacunoMacho) {
		pGanadoMacho.updateGanadoVacunoMacho(pGanadoVacunoMacho);
		
	}

	@Override
	public void deleteGanadoVacunoMacho(int cuia) {
		pGanadoMacho.deleteGanadoVacunoMacho(cuia);
		
	}

}
