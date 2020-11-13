package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class totalLecheProduccidaRowMapper implements RowMapper<totalLecheProduccida>{

	@Override
	public totalLecheProduccida mapRow(ResultSet rs, int rowNum) throws SQLException {
		totalLecheProduccida ptotalLecheProduccida = new totalLecheProduccida();
		ptotalLecheProduccida.setTotal(rs.getDouble("total"));
		return ptotalLecheProduccida;
	}

}
