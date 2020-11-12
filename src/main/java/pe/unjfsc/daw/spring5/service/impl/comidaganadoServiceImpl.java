package pe.unjfsc.daw.spring5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.impl.comidaganadoDaoImpl;
import pe.unjfsc.daw.spring5.model.comidaganado;
import pe.unjfsc.daw.spring5.service.comidaganadoService;

@Service
public class comidaganadoServiceImpl implements comidaganadoService{
	
	@Autowired
	private comidaganadoDaoImpl ocomidaganadoDaoImpl;

	@Override
	public List<comidaganado> getAllcomidaganado() {
		return ocomidaganadoDaoImpl.getAllcomidaganado();
	}

	@Override
	public comidaganado findcomidaganadoById(int idComiGana) {
		return ocomidaganadoDaoImpl.findcomidaganadoById(idComiGana);
	}


}
