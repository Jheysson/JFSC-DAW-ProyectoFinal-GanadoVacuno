package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import pe.unjfsc.daw.spring5.model.vacadedescarte;


public interface vacadedescarteDao {
	public List<vacadedescarte> getAllVacadeDescarte();
	 
	 public vacadedescarte findvacaDescarteByid(int id);
	 
	 public void addvacadedescarte(vacadedescarte pvacadedescarte);
	 
	 public void updatevacadedescarte(vacadedescarte pvacadedescarte);
	 
	 public void deletevacadedescarte(int id);
}
