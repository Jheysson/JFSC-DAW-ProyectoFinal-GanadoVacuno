package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import pe.unjfsc.daw.spring5.model.ganadoMuerto;


public interface gandoMuertoDao {
	public List<ganadoMuerto> getAllGanadoMuerto();
	 
	 public ganadoMuerto findGanadoMuertoByid(int id);
	 
	 public void addGanadoMuerto(ganadoMuerto pGanadoMuerto);
	 
	 public void deleteGanadoMuerto(int id);
}
