package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import pe.unjfsc.daw.spring5.model.GanadoVacunoMacho;

public interface GanadoVacunoMachoDao {
	public List<GanadoVacunoMacho> getGanadoVacunoMacho();
	
	public GanadoVacunoMacho findGanadoVacunoByCuia(int cuia);
	
	public void addGanadoVacunoMacho(GanadoVacunoMacho pGanadoVacunoMacho);
	
	public void updateGanadoVacunoMacho(GanadoVacunoMacho pGanadoVacunoMacho);
	
	public void deleteGanadoVacunoMacho(int cuia);
	
	public void updateAllMachos();
}
