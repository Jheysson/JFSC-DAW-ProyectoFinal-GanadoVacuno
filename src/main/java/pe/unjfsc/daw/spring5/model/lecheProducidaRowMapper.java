package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class lecheProducidaRowMapper implements RowMapper<lecheProducidaDia> {
     
	@Override
	public lecheProducidaDia mapRow(ResultSet rs, int rowNum) throws SQLException {
		lecheProducidaDia objLecheProducida = new lecheProducidaDia();
		objLecheProducida.setIdLechProd(rs.getInt("idLechProd"));
		objLecheProducida.setCantiLitrLechProd(rs.getDouble("cantiLitrLechProd"));
	    objLecheProducida.setFechLechProd(rs.getString("fechLechProd"));
		objLecheProducida.setIdVacaProd(rs.getInt("idVacaProd"));
		return objLecheProducida;
	}

}