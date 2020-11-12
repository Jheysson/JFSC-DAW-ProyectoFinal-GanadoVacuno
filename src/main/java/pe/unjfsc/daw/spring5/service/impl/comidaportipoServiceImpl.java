package pe.unjfsc.daw.spring5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.impl.comidaportipoDaoImpl;
import pe.unjfsc.daw.spring5.model.comidaportipo;
import pe.unjfsc.daw.spring5.service.comidaportipoService;

@Service
public class comidaportipoServiceImpl implements comidaportipoService{
	
	@Autowired
	private comidaportipoDaoImpl ocomidaganadoDaoImpl;

	@Override
	public List<comidaportipo> getAllcomidaportipo() {
		return ocomidaganadoDaoImpl.getAllcomidaportipo();
	}

	@Override
	public comidaportipo findcomidaganadoById(int idComiTipo) {
		return ocomidaganadoDaoImpl.findcomidaganadoById(idComiTipo);
	}


}
