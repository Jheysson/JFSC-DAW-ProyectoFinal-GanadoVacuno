package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.lecheProducidaDaoImpl;
import pe.unjfsc.daw.spring5.model.lecheProducidaDia;

@Service
public class lecheProducidaServiceImpl implements lecheProducidaService {

	@Autowired
	private lecheProducidaDaoImpl objLecheProducidaDaoImpl;
	
	@Override
	public List<lecheProducidaDia> getAllLecheProducida() {
		return objLecheProducidaDaoImpl.getAllLecheProducida();
	}

	@Override
	public lecheProducidaDia findLecheProducidaById(int id) {
		return  objLecheProducidaDaoImpl.findLecheProducidaById(id);
	}

	@Override
	public void addLecheProducida(lecheProducidaDia pLecheProducida) {
		objLecheProducidaDaoImpl.addLecheProducida(pLecheProducida);
		
	}

	@Override
	public void updateLecheProducida(lecheProducidaDia pLecheProducida) {
		objLecheProducidaDaoImpl.updateLecheProducida(pLecheProducida);
		
	}

	@Override
	public void deleteLecheProducida(int id) {
		objLecheProducidaDaoImpl.deleteLecheProducida(id);
		
	}

}
