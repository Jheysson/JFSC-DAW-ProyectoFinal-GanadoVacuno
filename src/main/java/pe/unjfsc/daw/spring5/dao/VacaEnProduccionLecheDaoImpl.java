package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLVacaEnProduccionLeche;
import pe.unjfsc.daw.spring5.model.CDConstanteSQLecheProducida;
import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;
import pe.unjfsc.daw.spring5.model.vacasenproduccionleche;
import pe.unjfsc.daw.spring5.model.vacasenproduccionlecheRowMapper;

@Transactional
@Repository
public class VacaEnProduccionLecheDaoImpl implements VacaEnProduccionLecheDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<vacasenproduccionleche> getAllVacadeProduccionLeche() {
		RowMapper<vacasenproduccionleche> rowMapper = new vacasenproduccionlecheRowMapper();
		List<vacasenproduccionleche> list = jdbcTemplate.query(CDConstanteSQLVacaEnProduccionLeche.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public vacasenproduccionleche findvacaDeProduccionLecheByid(int id) {
		RowMapper<vacasenproduccionleche> rowMapper = new BeanPropertyRowMapper<vacasenproduccionleche>(vacasenproduccionleche.class);
		vacasenproduccionleche pvacasenproduccionleche = jdbcTemplate.queryForObject(CDConstanteSQLVacaEnProduccionLeche.SQL_SELECT_BY_ID, rowMapper, id);
		return pvacasenproduccionleche;
	}
	
	@Override
	public GanadoVacunoHembra findvacaDeProduccionLecheByCUIA(int cuia) {
		RowMapper<GanadoVacunoHembra> rowMapper = new BeanPropertyRowMapper<GanadoVacunoHembra>(GanadoVacunoHembra.class);
		GanadoVacunoHembra pvacasenproduccionleche = jdbcTemplate.queryForObject(CDConstanteSQLVacaEnProduccionLeche.SQL_SELECT_BY_CUIA_GANADO, rowMapper, cuia);
		return pvacasenproduccionleche;
	}

	@Override
	public void addvacasenproduccionleche(vacasenproduccionleche pvacasenproduccionleche) {
		jdbcTemplate.update(CDConstanteSQLVacaEnProduccionLeche.SQL_INSERT,
				pvacasenproduccionleche.getCuiaGana(),
				pvacasenproduccionleche.getIdSuple(),
				pvacasenproduccionleche.getObservacion()
				);
		jdbcTemplate.update(CDConstanteSQLVacaEnProduccionLeche.SQL_CAMBIAR_ESTADO_GANADO,
				pvacasenproduccionleche.getCuiaGana());
		
	}

	@Override
	public void deletevacasenproduccionleche(int id) {
		jdbcTemplate.update(CDConstanteSQLVacaEnProduccionLeche.SQL_DELETE, id);
		
	}

	@Override
	public void updatevacasenproduccionleche(vacasenproduccionleche pvacasenproduccionleche) {
		jdbcTemplate.update(CDConstanteSQLVacaEnProduccionLeche.SQL_UPDATE,
				pvacasenproduccionleche.getIdSuple(),
				pvacasenproduccionleche.getObservacion(),
				pvacasenproduccionleche.getIdVacaProd()
				);
		
	}

	

}
