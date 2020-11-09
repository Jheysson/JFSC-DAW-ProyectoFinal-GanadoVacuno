package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;
import pe.unjfsc.daw.spring5.model.vacasenproduccionleche;

public interface VacaEnProducciondeLecheService {
	public List<vacasenproduccionleche> getAllVacadeProduccionLeche();
	 
	 public vacasenproduccionleche findvacaDeProduccionLecheByid(int id);
	 
	public GanadoVacunoHembra findvacaDeProduccionLecheByCUIA(int cuia);
	 
	 public void addvacasenproduccionleche(vacasenproduccionleche pvacasenproduccionleche);
	 
	 public void updatevacasenproduccionleche(vacasenproduccionleche pvacasenproduccionleche);
	 
	 public void deletevacasenproduccionleche(int id);
}
