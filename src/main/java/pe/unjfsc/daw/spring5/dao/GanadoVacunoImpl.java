package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;

@Transactional
@Repository
public class GanadoVacunoImpl implements GanadoVacunoDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<GanadoVacuno> getAllGanadoVacuno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GanadoVacuno> getGanadoVacunoHembra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GanadoVacuno> getGanadoVacunoMacho() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GanadoVacuno findGanadoVacunoByCuia(int cuia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGanadoVacuno(GanadoVacuno pGanadoVacuno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGanadoVacuno(GanadoVacuno pGanadoVacuno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGanadoVacuno(int cuia) {
		// TODO Auto-generated method stub
		
	}

}
