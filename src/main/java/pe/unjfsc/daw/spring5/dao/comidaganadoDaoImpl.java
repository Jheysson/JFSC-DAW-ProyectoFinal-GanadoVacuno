package pe.unjfsc.daw.spring5.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLComidaGanado;
import pe.unjfsc.daw.spring5.model.comidaganado;
import pe.unjfsc.daw.spring5.model.comidaganadoRowMapper;

@Transactional
@Repository
public class comidaganadoDaoImpl implements comidaganadoDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<comidaganado> getAllcomidaganado() {
		RowMapper<comidaganado> rowMapper = new comidaganadoRowMapper();
		List<comidaganado> list = jdbcTemplate.query(CDConstanteSQLComidaGanado.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public comidaganado findcomidaganadoById(int idComiGana) {
		RowMapper<comidaganado> rowMapper = new BeanPropertyRowMapper<comidaganado>(comidaganado.class);
		comidaganado pinse = jdbcTemplate.queryForObject(CDConstanteSQLComidaGanado.SQL_SELECT_BY_ID, rowMapper, idComiGana);
		return pinse;
	
	}

}
