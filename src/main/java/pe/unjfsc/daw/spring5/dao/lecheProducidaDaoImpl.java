package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLNatalidad;
import pe.unjfsc.daw.spring5.model.CDConstanteSQLecheProducida;
import pe.unjfsc.daw.spring5.model.lecheProducidaDia;
import pe.unjfsc.daw.spring5.model.lecheProducidaRowMapper;
import pe.unjfsc.daw.spring5.model.natalidad;
import pe.unjfsc.daw.spring5.model.vacasenproduccionleche;

@Transactional
@Repository
public class lecheProducidaDaoImpl implements lecheProducidaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<lecheProducidaDia> getAllLecheProducida() {
		RowMapper<lecheProducidaDia> rowMapper = new lecheProducidaRowMapper();
		List<lecheProducidaDia> list = jdbcTemplate.query(CDConstanteSQLecheProducida.SQL_SELECT_ALL, rowMapper);
		return list;

	}

	@Override
	public lecheProducidaDia findLecheProducidaById(int id) {
		RowMapper<lecheProducidaDia> rowMapper = new BeanPropertyRowMapper<lecheProducidaDia>(lecheProducidaDia.class);
		lecheProducidaDia objLecheProducidaDia = jdbcTemplate
				.queryForObject(CDConstanteSQLecheProducida.SQL_SELECT_BY_ID, rowMapper, id);

		return objLecheProducidaDia;
	}
	
	
	@Override
	public vacasenproduccionleche finCUIAProductoraByCUIA(int cuia) {
		RowMapper<vacasenproduccionleche> rowMapperv = new BeanPropertyRowMapper<vacasenproduccionleche>(vacasenproduccionleche.class);
		vacasenproduccionleche objLecheProducidaDia = jdbcTemplate
				.queryForObject(CDConstanteSQLecheProducida.SQL_SELECT_BY_CUIA_LECHERA, rowMapperv, cuia);
		return objLecheProducidaDia;
	}
	

	@Override
	public void addLecheProducida(lecheProducidaDia pLecheProducida) {
		jdbcTemplate.update(CDConstanteSQLecheProducida.SQL_INSERT, 
				pLecheProducida.getCantiLitrLechProd(),
				pLecheProducida.getCuiaGana(),
		        pLecheProducida.getObservacion());
	}
//mod
	@Override
	public void updateLecheProducida(lecheProducidaDia pLecheProducida) {
		jdbcTemplate.update(CDConstanteSQLecheProducida.SQL_UPDATE,
				pLecheProducida.getCantiLitrLechProd(), 
				pLecheProducida.getObservacion(),
	         	pLecheProducida.getIdLechProd());
	}

	@Override
	public void deleteLecheProducida(int id) {
		jdbcTemplate.update(CDConstanteSQLecheProducida.SQL_DELETE, id);

	}

}
