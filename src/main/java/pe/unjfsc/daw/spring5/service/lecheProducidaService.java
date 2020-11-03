package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.lecheProducidaDia;

public interface lecheProducidaService {
	
	public List<lecheProducidaDia> getAllLecheProducida();
	 
	 public lecheProducidaDia findLecheProducidaById(int id);
	 
	 public void addLecheProducida(lecheProducidaDia pLecheProducida);
	 
	 public void updateLecheProducida(lecheProducidaDia pLecheProducida);
	 
	 public void deleteLecheProducida(int id);
}
