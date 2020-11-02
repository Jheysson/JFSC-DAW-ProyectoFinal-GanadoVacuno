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
		ovacasenproduccionleche.setIdSuple(rs.getInt("idSuple"));
		ovacasenproduccionleche.setEsta(rs.getInt("esta"));
		return ovacasenproduccionleche;
	}

}
