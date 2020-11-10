package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.comidaportipo;

public interface comidaportipoService {
	public List<comidaportipo> getAllcomidaportipo();
	 
	 public comidaportipo findcomidaganadoById(int idComiTipo);
}
