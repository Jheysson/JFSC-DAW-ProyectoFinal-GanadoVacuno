package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class comidaganadoRowMapper implements RowMapper<comidaganado>{

	@Override
	public comidaganado mapRow(ResultSet rs, int rowNum) throws SQLException {
		comidaganado ocomi= new comidaganado();		
		ocomi.setIdComiGana(rs.getInt("idComiGana"));
		ocomi.setComiGanaDiri(rs.getString("comiGanaDiri"));
		ocomi.setComiRaci(rs.getDouble("comiRaci"));
		ocomi.setIdTipoComi(rs.getInt("idTipoComi"));
		return ocomi;
	}

}
