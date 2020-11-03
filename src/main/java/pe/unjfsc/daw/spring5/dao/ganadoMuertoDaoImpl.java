package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLGanadoMuerto;
import pe.unjfsc.daw.spring5.model.ganadoMuerto;
import pe.unjfsc.daw.spring5.model.ganadoMuertoRowMapper;


@Transactional
@Repository
public class ganadoMuertoDaoImpl implements gandoMuertoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ganadoMuerto> getAllGanadoMuerto() {
		RowMapper<ganadoMuerto> rowMapper = new ganadoMuertoRowMapper();
		List<ganadoMuerto> list = jdbcTemplate.query(CDConstanteSQLGanadoMuerto.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public ganadoMuerto findGanadoMuertoByid(int id) {
		RowMapper<ganadoMuerto> rowMapper = new ganadoMuertoRowMapper();
		ganadoMuerto objGanadoMuerto=jdbcTemplate.queryForObject(CDConstanteSQLGanadoMuerto.SQL_SELECT_BY_ID, rowMapper,id);
		return objGanadoMuerto;
	}

	@Override
	public void addGanadoMuerto(ganadoMuerto pGanadoMuerto) {
		jdbcTemplate.update(CDConstanteSQLGanadoMuerto.SQL_INSERT,
				pGanadoMuerto.getCuiaGana(),
				pGanadoMuerto.getCausMuer());
	}

	@Override
	public void deleteGanadoMuerto(int id) {
		jdbcTemplate.update(CDConstanteSQLGanadoMuerto.SQL_DELETE,id);
	}

}
