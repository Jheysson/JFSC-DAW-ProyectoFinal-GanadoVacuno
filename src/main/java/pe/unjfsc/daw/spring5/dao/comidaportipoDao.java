package pe.unjfsc.daw.spring5.dao;
import java.util.List;

import pe.unjfsc.daw.spring5.model.comidaganado;
import pe.unjfsc.daw.spring5.model.comidaportipo;

public interface comidaportipoDao {
	
	public List<comidaportipo> getAllcomidaportipo(); 
	 public comidaportipo findcomidaganadoById(int idComiTipo);
	 
}
