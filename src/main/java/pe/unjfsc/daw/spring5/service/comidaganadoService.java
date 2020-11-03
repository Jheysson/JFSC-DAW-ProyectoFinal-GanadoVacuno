package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.comidaganado;

public interface comidaganadoService {
	public List<comidaganado> getAllcomidaganado();
	 
	 public comidaganado findcomidaganadoById(int idComiGana);
	 
	 public void addcomidaganado(comidaganado pcomi);
	 
	 public void updatecomidaganado(comidaganado pcomi);
	 
	 public void deletecomidaganado(int idComiGana);
}
