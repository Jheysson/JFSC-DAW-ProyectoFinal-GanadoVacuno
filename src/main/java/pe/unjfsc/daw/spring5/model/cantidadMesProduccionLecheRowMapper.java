package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class cantidadMesProduccionLecheRowMapper implements RowMapper<cantidadMesProduccionLeche>{

	@Override
	public cantidadMesProduccionLeche mapRow(ResultSet rs, int rowNum) throws SQLException {
		cantidadMesProduccionLeche pcantidadMesProduccionLeche = new cantidadMesProduccionLeche();
		pcantidadMesProduccionLeche.setCantidad(rs.getDouble("cantidad"));
		pcantidadMesProduccionLeche.setMes(rs.getString("mes"));
		return pcantidadMesProduccionLeche;
	}

}
