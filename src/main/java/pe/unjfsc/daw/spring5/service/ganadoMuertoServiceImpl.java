package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.ganadoMuertoDaoImpl;
import pe.unjfsc.daw.spring5.model.ganadoMuerto;

@Service
public class ganadoMuertoServiceImpl implements ganadoMuertoService {

	@Autowired
	private ganadoMuertoDaoImpl objGanadoMuertoDaoImpl;

	@Override
	public List<ganadoMuerto> getAllGanadoMuerto() {
		return objGanadoMuertoDaoImpl.getAllGanadoMuerto();
	}

	@Override
	public ganadoMuerto findGanadoMuertoByid(int id) {
		return objGanadoMuertoDaoImpl.findGanadoMuertoByid(id);
	}

	@Override
	public void addGanadoMuerto(ganadoMuerto pGanadoMuerto) {
		objGanadoMuertoDaoImpl.addGanadoMuerto(pGanadoMuerto);
	}

	@Override
	public void deleteGanadoMuerto(int id) {
		objGanadoMuertoDaoImpl.deleteGanadoMuerto(id);
	}

}
