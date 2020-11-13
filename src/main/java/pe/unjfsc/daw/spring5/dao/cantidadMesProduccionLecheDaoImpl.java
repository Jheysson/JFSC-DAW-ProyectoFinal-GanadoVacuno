package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLcantidadMesProduccionLeche;
import pe.unjfsc.daw.spring5.model.cantidadMesProduccionLeche;
import pe.unjfsc.daw.spring5.model.cantidadMesProduccionLecheRowMapper;

@Transactional
@Repository
public class cantidadMesProduccionLecheDaoImpl implements cantidadMesProduccionLecheDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<cantidadMesProduccionLeche> getMesAndCantidad() {
		RowMapper<cantidadMesProduccionLeche> rowMapper = new cantidadMesProduccionLecheRowMapper();
		List<cantidadMesProduccionLeche> list = jdbcTemplate.query(CDConstanteSQLcantidadMesProduccionLeche.SQL_SELECT_ALL, rowMapper);
		return list;
	}

}
