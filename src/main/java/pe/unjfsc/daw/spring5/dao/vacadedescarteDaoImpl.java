package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLVacadeDescarte;
import pe.unjfsc.daw.spring5.model.vacadedescarte;
import pe.unjfsc.daw.spring5.model.vacadedescarteRowMapper;

@Transactional
@Repository
public class vacadedescarteDaoImpl implements vacadedescarteDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;

	@Override
	public List<vacadedescarte> getAllVacadeDescarte() {
		RowMapper<vacadedescarte> rowMapper = new vacadedescarteRowMapper();
		List<vacadedescarte> list = jdbcTemplate.query(CDConstanteSQLVacadeDescarte.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public vacadedescarte findvacaDescarteByid(int id) {
		RowMapper<vacadedescarte> rowMapper = new BeanPropertyRowMapper<vacadedescarte>(vacadedescarte.class);
		vacadedescarte pvacadedescarte = jdbcTemplate.queryForObject(CDConstanteSQLVacadeDescarte.SQL_SELECT_BY_ID, rowMapper ,id);
		return pvacadedescarte;
	}

	@Override
	public void addvacadedescarte(vacadedescarte pvacadedescarte) {
		jdbcTemplate.update(CDConstanteSQLVacadeDescarte.SQL_INSERT,
				pvacadedescarte.getCuiaGana(),
				pvacadedescarte.getObse()
				);
		
	}

	@Override
	public void deletevacadedescarte(int id) {
		jdbcTemplate.update(CDConstanteSQLVacadeDescarte.SQL_DELETE, id);
		
	}

	@Override
	public void updatevacadedescarte(vacadedescarte pvacadedescarte) {
		jdbcTemplate.update(CDConstanteSQLVacadeDescarte.SQL_UPDATE,
				pvacadedescarte.getObse(),
				pvacadedescarte.getIdVacaDesc()
				);
		
	}
}
