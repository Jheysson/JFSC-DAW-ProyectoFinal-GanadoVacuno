package pe.unjfsc.daw.spring5.dao;
import java.util.List;

import pe.unjfsc.daw.spring5.model.comidaganado;

public interface comidaganadoDao {
	public List<comidaganado> getAllcomidaganado();
	 
	 public comidaganado findcomidaganadoById(int idComiGana);
	 
}
