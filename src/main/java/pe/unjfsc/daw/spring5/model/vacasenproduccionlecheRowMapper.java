package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class vacasenproduccionlecheRowMapper implements RowMapper<vacasenproduccionleche>{

	@Override
	public vacasenproduccionleche mapRow(ResultSet rs, int rowNum) throws SQLException {
		vacasenproduccionleche ovacasenproduccionleche = new vacasenproduccionleche();
		ovacasenproduccionleche.setIdVacaProd(rs.getInt("idVacaProd"));
		ovacasenproduccionleche.setCuiaGana(rs.getInt("cuiaGana"));
		ovacasenproduccionleche.setAliaGana(rs.getString("aliaGana"));
		ovacasenproduccionleche.setNombSuple(rs.getString("nombSuple"));
		ovacasenproduccionleche.setObservacion(rs.getString("observacion"));
		ovacasenproduccionleche.setIdSuple(rs.getInt("idSuple"));
		return ovacasenproduccionleche;
	}

}
