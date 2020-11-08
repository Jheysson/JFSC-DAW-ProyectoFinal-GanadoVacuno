package pe.unjfsc.daw.spring5.dao;

import java.util.List;
import pe.unjfsc.daw.spring5.model.vacasenproduccionleche;


public interface VacaEnProduccionLecheDao {
	public List<vacasenproduccionleche> getAllVacadeProduccionLeche();
	 
	 public vacasenproduccionleche findvacaDeProduccionLecheByid(int id);
	// public vacasenproduccionleche findvacaDeProduccionLecheByCUIA(int cuia);

	 
	 public void addvacasenproduccionleche(vacasenproduccionleche pvacasenproduccionleche);
	 
	 public void updatevacasenproduccionleche(vacasenproduccionleche pvacasenproduccionleche);
	 
	 public void deletevacasenproduccionleche(int id);
}
