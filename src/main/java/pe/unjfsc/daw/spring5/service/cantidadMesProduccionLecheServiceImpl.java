package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.cantidadMesProduccionLecheDaoImpl;
import pe.unjfsc.daw.spring5.model.cantidadMesProduccionLeche;

@Service
public class cantidadMesProduccionLecheServiceImpl implements cantidadMesProduccionLecheService{
	
	@Autowired
	private cantidadMesProduccionLecheDaoImpl ocantidadMesProduccionLecheDaoImpl;
	
	@Override
	public List<cantidadMesProduccionLeche> getMesAndCantidad() {
		return ocantidadMesProduccionLecheDaoImpl.getMesAndCantidad();
	}

}
