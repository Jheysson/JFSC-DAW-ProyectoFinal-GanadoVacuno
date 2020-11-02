package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.inseminacion;

public interface inseminacionService {
	public List<inseminacion> getAllInseminacion();
	 
	 public inseminacion findinseminacionByCodigo(int codiPropInse);
	 
	 public void addinseminacion(inseminacion pinse);
	 
	 public void updateinseminacion(inseminacion pinse);
	 
	 public void deleteinseminacion(int codiPropInse);
}
