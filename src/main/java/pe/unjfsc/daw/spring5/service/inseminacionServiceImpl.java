package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.inseminacionDaoImpl;
import pe.unjfsc.daw.spring5.model.inseminacion;

@Service
public class inseminacionServiceImpl implements inseminacionService{
	
	@Autowired
	private inseminacionDaoImpl oinseminacionDaoImpl;

	@Override
	public List<inseminacion> getAllInseminacion() {
		return oinseminacionDaoImpl.getAllInseminacion();
	}

	@Override
	public inseminacion findinseminacionByCodigo(int codiPropInse) {
		return oinseminacionDaoImpl.findinseminacionByCodigo(codiPropInse);
	}

	@Override
	public void addinseminacion(inseminacion pinse) {
		oinseminacionDaoImpl.addinseminacion(pinse);
		
	}

	@Override
	public void updateinseminacion(inseminacion pinse) {
		oinseminacionDaoImpl.updateinseminacion(pinse);
		
	}

	@Override
	public void deleteinseminacion(int codiPropInse) {
		oinseminacionDaoImpl.deleteinseminacion(codiPropInse);
		
	}

}
