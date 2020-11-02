package pe.unjfsc.daw.spring5.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLInseminacion;
import pe.unjfsc.daw.spring5.model.inseminacion;
import pe.unjfsc.daw.spring5.model.inseminacionRowMapper;

@Transactional
@Repository
public class inseminacionDaoImpl implements inseminacionDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<inseminacion> getAllInseminacion() {
		RowMapper<inseminacion> rowMapper = new inseminacionRowMapper();
		List<inseminacion> list = jdbcTemplate.query(CDConstanteSQLInseminacion.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public inseminacion findinseminacionByCodigo(int codiPropInse) {
		RowMapper<inseminacion> rowMapper = new BeanPropertyRowMapper<inseminacion>(inseminacion.class);
		inseminacion pinse = jdbcTemplate.queryForObject(CDConstanteSQLInseminacion.SQL_SELECT_BY_ID, rowMapper, codiPropInse);
		return pinse;
	
	}

	@Override
	public void addinseminacion(inseminacion pinse) {
		jdbcTemplate.update(CDConstanteSQLInseminacion.SQL_INSERT, 
				pinse.getCodiPropInse(),
				pinse.getIdGeno(),
				pinse.getPesoPropInse(),
				pinse.getTallPropInse(),
				pinse.getLugaPropInse(),
				pinse.getPrecPropInse(),
				pinse.getFechCompPropInse(),
				pinse.getObse()
				);
		
	}

	@Override
	public void updateinseminacion(inseminacion pinse) {
		jdbcTemplate.update(CDConstanteSQLInseminacion.SQL_UPDATE,
				pinse.getIdGeno(),
				pinse.getPesoPropInse(),
				pinse.getTallPropInse(),
				pinse.getLugaPropInse(),
				pinse.getPrecPropInse(),
				pinse.getFechCompPropInse(),
				pinse.getObse(),
				pinse.getCodiPropInse()
				);
		
	}

	@Override
	public void deleteinseminacion(int codiPropInse) {
		jdbcTemplate.update(CDConstanteSQLInseminacion.SQL_DELETE, codiPropInse);
		
	}

}
