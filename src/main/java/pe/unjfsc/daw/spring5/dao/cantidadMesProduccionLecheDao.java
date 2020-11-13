package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import pe.unjfsc.daw.spring5.model.cantidadMesProduccionLeche;


public interface cantidadMesProduccionLecheDao {
	
	public List<cantidadMesProduccionLeche> getMesAndCantidad();
}
