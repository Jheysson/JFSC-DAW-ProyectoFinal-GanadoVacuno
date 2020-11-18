package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import pe.unjfsc.daw.spring5.model.GanadoMuerto;


public interface GanadoMuertoDao {
	public List<GanadoMuerto> getAllGanadoMuerto();
	 
	 public GanadoMuerto findGanadoMuertoByCuia(int cuia);
	 
	 public void addGanadoMuerto(GanadoMuerto pGanadoMuerto);
	 
}
