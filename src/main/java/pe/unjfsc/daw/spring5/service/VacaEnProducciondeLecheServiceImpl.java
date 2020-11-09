package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.VacaEnProduccionLecheDaoImpl;
import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;
import pe.unjfsc.daw.spring5.model.vacasenproduccionleche;
@Service
public class VacaEnProducciondeLecheServiceImpl implements VacaEnProducciondeLecheService{
	
	@Autowired
	private VacaEnProduccionLecheDaoImpl oVacaEnProduccionLecheDaoImpl;
	@Override
	public List<vacasenproduccionleche> getAllVacadeProduccionLeche() {
		return oVacaEnProduccionLecheDaoImpl.getAllVacadeProduccionLeche();
	}

	@Override
	public vacasenproduccionleche findvacaDeProduccionLecheByid(int id) {
		return oVacaEnProduccionLecheDaoImpl.findvacaDeProduccionLecheByid(id);
	}

	@Override
	public void addvacasenproduccionleche(vacasenproduccionleche pvacasenproduccionleche) {
		oVacaEnProduccionLecheDaoImpl.addvacasenproduccionleche(pvacasenproduccionleche);
		
	}

	@Override
	public void deletevacasenproduccionleche(int id) {
		oVacaEnProduccionLecheDaoImpl.deletevacasenproduccionleche(id);
		
	}

	@Override
	public void updatevacasenproduccionleche(vacasenproduccionleche pvacasenproduccionleche) {
		oVacaEnProduccionLecheDaoImpl.updatevacasenproduccionleche(pvacasenproduccionleche);
		
	}

	@Override
	public GanadoVacunoHembra findvacaDeProduccionLecheByCUIA(int cuia) {
          return oVacaEnProduccionLecheDaoImpl.findvacaDeProduccionLecheByCUIA(cuia);
	}

}
