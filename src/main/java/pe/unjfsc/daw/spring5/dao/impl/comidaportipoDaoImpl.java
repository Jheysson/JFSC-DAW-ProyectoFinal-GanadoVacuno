package pe.unjfsc.daw.spring5.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.dao.comidaportipoDao;
import pe.unjfsc.daw.spring5.model.comidaportipo;
import pe.unjfsc.daw.spring5.model.comidaportipoRowMapper;
import pe.unjfsc.daw.spring5.model.consta.CDConstanteSQLComidaPorTipo;

@Transactional
@Repository
public class comidaportipoDaoImpl implements comidaportipoDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<comidaportipo> getAllcomidaportipo() {
		RowMapper<comidaportipo> rowMapper = new comidaportipoRowMapper();
		List<comidaportipo> list = jdbcTemplate.query(CDConstanteSQLComidaPorTipo.SQL_SELECT_ALL, rowMapper);
		return list;
	}
	
	@Override
	public comidaportipo findcomidaganadoById(int idComiTipo) {
		RowMapper<comidaportipo> rowMapper = new BeanPropertyRowMapper<comidaportipo>(comidaportipo.class);
		comidaportipo pinse1 = jdbcTemplate.queryForObject(CDConstanteSQLComidaPorTipo.SQL_SELECT_BY_ID, rowMapper, idComiTipo);
		return pinse1;
	
	}

}
