package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;

public interface GanadoVacunoHembraService {
	public List<GanadoVacunoHembra> getGanadoVacunoHembra();
	
	public GanadoVacunoHembra findGanadoVacunoByCuia(int cuia);
	
	public void addGanadoVacunoHembra(GanadoVacunoHembra pGanadoVacunoHembra);
	
	public void updateGanadoVacunoHembra(GanadoVacunoHembra pGanadoVacunoHembra);
	
	public void deleteGanadoVacunoHembra(int cuia);
}
