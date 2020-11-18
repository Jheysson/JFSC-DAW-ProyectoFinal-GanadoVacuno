package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.GanadoMuertoDaoImpl;
import pe.unjfsc.daw.spring5.model.GanadoMuerto;

@Service
public class GanadoMuertoServiceImpl implements GanadoMuertoService {

	@Autowired
	private GanadoMuertoDaoImpl oGanadoMuertoDaoImpl;

	@Override
	public List<GanadoMuerto> getAllGanadoMuerto() {
		return oGanadoMuertoDaoImpl.getAllGanadoMuerto();
	}

	@Override
	public GanadoMuerto findGanadoMuertoByCuia(int cuia) {
		return oGanadoMuertoDaoImpl.findGanadoMuertoByCuia(cuia);
	}

	@Override
	public void addGanadoMuerto(GanadoMuerto pGanadoMuerto) {
		oGanadoMuertoDaoImpl.addGanadoMuerto(pGanadoMuerto);
	}

	

}
