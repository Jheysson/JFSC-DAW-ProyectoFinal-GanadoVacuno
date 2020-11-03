package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.GanadoEnfermo;
import pe.unjfsc.daw.spring5.model.CDConstanteSQLGanadoEnfermo;
import pe.unjfsc.daw.spring5.model.GanadoEnfermoRowMapper;

@Transactional
@Repository
public class GanadoEnfermoDaoImpl implements GanadoEnfermoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<GanadoEnfermo> getAllGanadoEnfermo() {
		RowMapper<GanadoEnfermo> rowMapper = new GanadoEnfermoRowMapper();
		List<GanadoEnfermo> list = jdbcTemplate.query(CDConstanteSQLGanadoEnfermo.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public GanadoEnfermo findGanadoEnfermoByCuia(int cuia) {
		RowMapper<GanadoEnfermo> rowMapper = new BeanPropertyRowMapper<GanadoEnfermo>(GanadoEnfermo.class);
		GanadoEnfermo pGanadoEnfermo = jdbcTemplate.queryForObject(CDConstanteSQLGanadoEnfermo.SQL_SELECT_BY_ID, rowMapper, cuia);
		return pGanadoEnfermo;
	}

	@Override
	public void addGanadoEnfermo(GanadoEnfermo pGanadoEnfermo) {
		jdbcTemplate.update(CDConstanteSQLGanadoEnfermo.SQL_INSERT,
				pGanadoEnfermo.getCuiaGana(),
				pGanadoEnfermo.getIdEnfe(),
				pGanadoEnfermo.getFechIngr(),
				pGanadoEnfermo.getObse()
				);
		
	}

	@Override
	public void updateGanadoEnfermo(GanadoEnfermo pGanadoEnfermo) {
		jdbcTemplate.update(CDConstanteSQLGanadoEnfermo.SQL_UPDATE,
				pGanadoEnfermo.getIdEnfe(),
				pGanadoEnfermo.getFechIngr(),
				pGanadoEnfermo.getObse(),
				pGanadoEnfermo.getCuiaGana()
				);
		
	}

	@Override
	public void deleteGanadoEnfermo(int cuia) {
		jdbcTemplate.update(CDConstanteSQLGanadoEnfermo.SQL_DELETE, cuia);
		
	}

}
