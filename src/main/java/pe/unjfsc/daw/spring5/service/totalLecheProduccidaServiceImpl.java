package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.totalLecheProduccidaDaoImpl;
import pe.unjfsc.daw.spring5.model.totalLecheProduccida;

@Service
public class totalLecheProduccidaServiceImpl implements totalLecheProduccidaService{

	@Autowired
	private totalLecheProduccidaDaoImpl ototalLecheProduccidaDaoImpl;
	
	@Override
	public List<totalLecheProduccida> getAllAño() {
		
		return ototalLecheProduccidaDaoImpl.getAllAño();
	}

	
}
