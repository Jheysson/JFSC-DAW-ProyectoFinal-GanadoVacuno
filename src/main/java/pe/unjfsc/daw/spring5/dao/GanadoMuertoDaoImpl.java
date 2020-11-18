package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.dao.GanadoMuertoDao;
import pe.unjfsc.daw.spring5.model.CDConstanteSQLGanadoMuerto;
import pe.unjfsc.daw.spring5.model.GanadoMuerto;
import pe.unjfsc.daw.spring5.model.GanadoMuertoRowMapper;


@Transactional
@Repository
public class GanadoMuertoDaoImpl implements GanadoMuertoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<GanadoMuerto> getAllGanadoMuerto() {
		RowMapper<GanadoMuerto> rowMapper = new GanadoMuertoRowMapper();
		List<GanadoMuerto> list = jdbcTemplate.query(CDConstanteSQLGanadoMuerto.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public GanadoMuerto findGanadoMuertoByCuia(int cuia) {
		RowMapper<GanadoMuerto> rowMapper = new BeanPropertyRowMapper<GanadoMuerto>(GanadoMuerto.class);
		GanadoMuerto pGanadoMuerto=jdbcTemplate.queryForObject(CDConstanteSQLGanadoMuerto.SQL_SELECT_BY_ID, rowMapper,cuia);
		return pGanadoMuerto;
	}

	@Override
	public void addGanadoMuerto(GanadoMuerto pGanadoMuerto) {
		jdbcTemplate.update(CDConstanteSQLGanadoMuerto.SQL_INSERT,
				pGanadoMuerto.getCuiaGana(),
				pGanadoMuerto.getCausMuer());
		jdbcTemplate.update(CDConstanteSQLGanadoMuerto.SQL_ESTADOMUERTO,
				pGanadoMuerto.getCuiaGana());
	}

	

}
