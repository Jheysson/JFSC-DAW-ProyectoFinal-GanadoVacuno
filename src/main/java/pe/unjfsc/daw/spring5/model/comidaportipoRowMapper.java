package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class comidaportipoRowMapper implements RowMapper<comidaportipo>{

	@Override
	public comidaportipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		comidaportipo ocomi= new comidaportipo();	
		ocomi.setIdComiTipo(rs.getInt("idComiTipo"));
		ocomi.setIdTipoGana(rs.getString("idTipoGana"));
		ocomi.setIdTipoComi(rs.getString("idTipoComi"));
		ocomi.setRaciComi(rs.getDouble("raciComi"));
		ocomi.setIdSuple(rs.getString("idSuple"));
		ocomi.setRaciSuple(rs.getDouble("raciSuple"));
		ocomi.setFreComi(rs.getString("freComi"));
		ocomi.setEsta(rs.getInt("esta"));
		return ocomi;
	}

}
