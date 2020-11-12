package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.vacadedescarteDaoImpl;
import pe.unjfsc.daw.spring5.model.vacadedescarte;

@Service
public class vacadedescarteServiceImpl implements vacadedescarteService{
	
	@Autowired
	private vacadedescarteDaoImpl ovacadedescarteDaoImpl;

	@Override
	public List<vacadedescarte> getAllVacadeDescarte() {
		return ovacadedescarteDaoImpl.getAllVacadeDescarte();
	}

	@Override
	public vacadedescarte findvacaDescarteByid(int id) {
		return ovacadedescarteDaoImpl.findvacaDescarteByid(id);
	}

	@Override
	public void addvacadedescarte(vacadedescarte pvacadedescarte) {
		ovacadedescarteDaoImpl.addvacadedescarte(pvacadedescarte);
		
	}

	@Override
	public void updatevacadedescarte(vacadedescarte pvacadedescarte) {
		ovacadedescarteDaoImpl.updatevacadedescarte(pvacadedescarte);
		
	}
	
	@Override
	public void deletevacadedescarte(int id) {
		ovacadedescarteDaoImpl.deletevacadedescarte(id);
		
	}

}
