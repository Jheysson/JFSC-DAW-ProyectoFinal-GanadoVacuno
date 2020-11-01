package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.GanadoVacuno;
import pe.unjfsc.daw.spring5.model.GanadoVacunoRowMapper;
import pe.unjfsc.daw.spring5.model.CDConstanteSQLGanadoVacuno;

@Transactional
@Repository
public class GanadoVacunoDaoImpl implements GanadoVacunoDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<GanadoVacuno> getAllGanadoVacuno() {
		RowMapper<GanadoVacuno> rowMapper = new GanadoVacunoRowMapper();
		List<GanadoVacuno> list = jdbcTemplate.query(CDConstanteSQLGanadoVacuno.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public List<GanadoVacuno> getGanadoVacunoHembra() {
		RowMapper<GanadoVacuno> rowMapper = new GanadoVacunoRowMapper();
		List<GanadoVacuno> list = jdbcTemplate.query(CDConstanteSQLGanadoVacuno.SQL_SELECT_ALL_HEMBRAS, rowMapper);
		return list;
	}

	@Override
	public List<GanadoVacuno> getGanadoVacunoMacho() {
		RowMapper<GanadoVacuno> rowMapper = new GanadoVacunoRowMapper();
		List<GanadoVacuno> list = jdbcTemplate.query(CDConstanteSQLGanadoVacuno.SQL_SELECT_ALL_MACHOS, rowMapper);
		return list;
	}

	@Override
	public GanadoVacuno findGanadoVacunoByCuia(int cuia) {
		RowMapper<GanadoVacuno> rowMapper = new BeanPropertyRowMapper<GanadoVacuno>(GanadoVacuno.class);
		GanadoVacuno pGanadoVacuo = jdbcTemplate.queryForObject(CDConstanteSQLGanadoVacuno.SQL_SELECT_BY_ID, rowMapper, cuia )	;	
		return pGanadoVacuo;
	}

	@Override
	public void addGanadoVacuno(GanadoVacuno pGanadoVacuno) {
		
		
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
