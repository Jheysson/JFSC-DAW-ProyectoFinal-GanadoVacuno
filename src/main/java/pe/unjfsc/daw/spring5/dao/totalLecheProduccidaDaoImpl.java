package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLtotalLecheProduccida;
import pe.unjfsc.daw.spring5.model.totalLecheProduccida;
import pe.unjfsc.daw.spring5.model.totalLecheProduccidaRowMapper;

@Transactional
@Repository
public class totalLecheProduccidaDaoImpl implements totalLecheProduccidaDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<totalLecheProduccida> getAllAño() {
		RowMapper<totalLecheProduccida> rowMapper = new totalLecheProduccidaRowMapper();
		List<totalLecheProduccida> list = jdbcTemplate.query(CDConstanteSQLtotalLecheProduccida.SQL_SELECT_ALL, rowMapper);
		return list;
	}

}
