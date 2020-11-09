package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GanadoEnfermoRowMapper implements RowMapper<GanadoEnfermo> {

	@Override
	public GanadoEnfermo mapRow(ResultSet rs, int rowNum) throws SQLException {
		GanadoEnfermo oGanadoEnfermo = new GanadoEnfermo();
		oGanadoEnfermo.setCuiaGana(rs.getInt("cuiaGana"));
		oGanadoEnfermo.setIdEnfe(rs.getString("idEnfe"));
		oGanadoEnfermo.setFechIngr(rs.getString("fechIngr"));
		oGanadoEnfermo.setObse(rs.getString("obse"));
		oGanadoEnfermo.setEsta(rs.getInt("esta"));
		
		return oGanadoEnfermo;
	}
	

}
