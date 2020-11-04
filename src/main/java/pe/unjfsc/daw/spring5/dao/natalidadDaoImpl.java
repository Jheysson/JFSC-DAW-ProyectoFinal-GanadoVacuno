package pe.unjfsc.daw.spring5.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLNatalidad;
import pe.unjfsc.daw.spring5.model.natalidad;
import pe.unjfsc.daw.spring5.model.natalidadRowMapper;

@Transactional
@Repository
public class natalidadDaoImpl implements natalidadDao{
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<natalidad> getAllNatalidad() {
		RowMapper<natalidad> rowMapper = new natalidadRowMapper();
		List<natalidad> list = jdbcTemplate.query(CDConstanteSQLNatalidad.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public natalidad findnatalidadByCuia(int cuia) {
		RowMapper<natalidad> rowMapper = new BeanPropertyRowMapper<natalidad>(natalidad.class);
		natalidad pnatalidad = jdbcTemplate.queryForObject(CDConstanteSQLNatalidad.SQL_SELECT_BY_ID, rowMapper, cuia);
		return pnatalidad;
	
	}

	@Override
	public void addnatalidad(natalidad pnatalidad) {
		jdbcTemplate.update(CDConstanteSQLNatalidad.SQL_INSERT, 
				pnatalidad.getCuiaNata(),
				pnatalidad.getIdSexo(),
				pnatalidad.getIdGeno(),
				pnatalidad.getFechNaciNata(),
				pnatalidad.getPesoNata(),
				pnatalidad.getCuiaMadr(),
				pnatalidad.getCuiaPadr(),
				pnatalidad.getCodiProp(),
				pnatalidad.getObse(),
				pnatalidad.getFoto()
				);
		
	}

	@Override
	public void updatenatalidad(natalidad pnatalidad) {
		jdbcTemplate.update(CDConstanteSQLNatalidad.SQL_UPDATE,
				pnatalidad.getIdSexo(),
				pnatalidad.getIdGeno(),
				pnatalidad.getFechNaciNata(),
				pnatalidad.getPesoNata(),
				pnatalidad.getCuiaMadr(),
				pnatalidad.getCuiaPadr(),
				pnatalidad.getCodiProp(),
				pnatalidad.getObse(),
				pnatalidad.getCuiaNata()
				);
		
	}

	@Override
	public void deletenatalidad(int cuia) {
		jdbcTemplate.update(CDConstanteSQLNatalidad.SQL_DELETE, cuia);
		
	}

}
