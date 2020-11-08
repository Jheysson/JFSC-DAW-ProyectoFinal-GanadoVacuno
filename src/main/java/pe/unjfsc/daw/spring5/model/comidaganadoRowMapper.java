package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class comidaganadoRowMapper implements RowMapper<comidaganado>{

	@Override
	public comidaganado mapRow(ResultSet rs, int rowNum) throws SQLException {
		comidaganado ocomi= new comidaganado();	
		ocomi.setIdComiGana(rs.getInt("idComiGana"));
		ocomi.setIdEtapa(rs.getString("idEtapa"));
		ocomi.setIdTipoComi(rs.getString("idTipoComi"));
		ocomi.setIdSuple(rs.getString("idSuple"));
		ocomi.setRaciComi(rs.getDouble("raciComi"));
		ocomi.setFreComi(rs.getString("freComi"));
		ocomi.setEsta(rs.getInt("esta"));
		return ocomi;
	}

}
