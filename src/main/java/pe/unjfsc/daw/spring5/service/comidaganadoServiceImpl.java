package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.comidaganadoDaoImpl;
import pe.unjfsc.daw.spring5.dao.inseminacionDaoImpl;
import pe.unjfsc.daw.spring5.model.comidaganado;
import pe.unjfsc.daw.spring5.model.inseminacion;

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

	@Override
	public void addcomidaganado(comidaganado pcomi) {
		ocomidaganadoDaoImpl.addcomidaganado(pcomi);
		
	}

	@Override
	public void updatecomidaganado(comidaganado pcomi) {
		ocomidaganadoDaoImpl.updatecomidaganado(pcomi);
		
	}

	@Override
	public void deletecomidaganado(int idComiGana) {
		ocomidaganadoDaoImpl.deletecomidaganado(idComiGana);
		
	}

}
