package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;

public interface GanadoVacunoDao {
	public List<GanadoVacuno> getAllGanadoVacuno();
	
	public List<GanadoVacuno> getGanadoVacunoHembra();
	
	public List<GanadoVacuno> getGanadoVacunoMacho();
	
	public GanadoVacuno findGanadoVacunoByCuia(int cuia);
	
	public void addGanadoVacuno(GanadoVacuno pGanadoVacuno);
	
	public void updateGanadoVacuno(GanadoVacuno pGanadoVacuno);
	
	public void deleteGanadoVacuno(int cuia);

}
