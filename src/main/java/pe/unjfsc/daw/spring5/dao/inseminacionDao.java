package pe.unjfsc.daw.spring5.dao;
import java.util.List;

import pe.unjfsc.daw.spring5.model.inseminacion;

public interface inseminacionDao {
	public List<inseminacion> getAllInseminacion();
	 
	 public inseminacion findinseminacionByCodigo(int codiPropInse);
	 
	 public void addinseminacion(inseminacion pinse);
	 
	 public void updateinseminacion(inseminacion pinse);
	 
	 public void deleteinseminacion(int codiPropInse);
}
