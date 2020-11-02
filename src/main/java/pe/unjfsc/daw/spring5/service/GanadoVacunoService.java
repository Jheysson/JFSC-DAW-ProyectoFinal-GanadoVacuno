package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;

public interface GanadoVacunoService {
	public List<GanadoVacuno> getAllGanadoVacuno();
	
	public List<GanadoVacuno> getGanadoVacunoHembra();
	
	public List<GanadoVacuno> getGanadoVacunoMacho();
	
	public GanadoVacuno findGanadoVacunoByCuia(int cuia);
	
	public void addGanadoVacuno(GanadoVacuno pGanadoVacuno);
	
	public void addGanadoVacunoHembra(GanadoVacuno pGanadoVacuno);
	
	public void addGanadoVacunoMacho(GanadoVacuno pGanadoVacuno);
	
	public void updateGanadoVacuno(GanadoVacuno pGanadoVacuno);
	
	public void deleteGanadoVacuno(int cuia);
}
