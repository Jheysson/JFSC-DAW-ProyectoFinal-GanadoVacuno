package pe.unjfsc.daw.spring5.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.dao.enfermedadDao;
import pe.unjfsc.daw.spring5.model.enfermedad;
import pe.unjfsc.daw.spring5.model.enfermedadRowMapper;
import pe.unjfsc.daw.spring5.model.consta.CDConstanteSQLEnfermedad;


@Transactional
@Repository
public class enfermedadDaoImpl implements enfermedadDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<enfermedad> getAllenfermedad() {
		RowMapper<enfermedad> rowMapper = new enfermedadRowMapper();
		List<enfermedad> list = jdbcTemplate.query(CDConstanteSQLEnfermedad.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public enfermedad findenfermedadById(int id_Enfe) {
		RowMapper<enfermedad> rowMapper = new BeanPropertyRowMapper<enfermedad>(enfermedad.class);
		enfermedad penfe = jdbcTemplate.queryForObject(CDConstanteSQLEnfermedad.SQL_SELECT_BY_ID, rowMapper, id_Enfe);
		return penfe;
	
	}

}
