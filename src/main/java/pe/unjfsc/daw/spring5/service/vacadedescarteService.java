package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.vacadedescarte;

public interface vacadedescarteService {
	public List<vacadedescarte> getAllVacadeDescarte();
	 
	 public vacadedescarte findvacaDescarteByid(int id);
	 
	 public void addvacadedescarte(vacadedescarte pvacadedescarte);
	 
	 public void deletevacadedescarte(int id);
}
