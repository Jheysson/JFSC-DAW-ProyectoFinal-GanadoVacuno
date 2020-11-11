package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.impl.GanadoEnfermoDaoImpl;
import pe.unjfsc.daw.spring5.model.GanadoEnfermo;

@Service
public class GanadoEnfermoServiceImpl implements GanadoEnfermoService {

	@Autowired
	private GanadoEnfermoDaoImpl oGanadoEnfermoDaoImpl;
	
	@Override
	public List<GanadoEnfermo> getAllGanadoEnfermo() {
		return oGanadoEnfermoDaoImpl.getAllGanadoEnfermo();
	}

	@Override
	public GanadoEnfermo findGanadoEnfermoByCuia(int cuia) {
		return oGanadoEnfermoDaoImpl.findGanadoEnfermoByCuia(cuia);
	}

	@Override
	public void addGanadoEnfermo(GanadoEnfermo pGanadoEnfermo) {
		oGanadoEnfermoDaoImpl.addGanadoEnfermo(pGanadoEnfermo);
		
	}

	@Override
	public void updateGanadoEnfermo(GanadoEnfermo pGanadoEnfermo) {
		oGanadoEnfermoDaoImpl.updateGanadoEnfermo(pGanadoEnfermo);
		
	}

	@Override
	public void deleteGanadoEnfermo(int cuia) {
		oGanadoEnfermoDaoImpl.deleteGanadoEnfermo(cuia);
		
	}

}
