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
		oGanadoEnfermo.setNombEnfe(rs.getString("nombEnfe"));
		oGanadoEnfermo.setAliaGana(rs.getString("aliaGana"));
		oGanadoEnfermo.setIdGeno(rs.getString("idGeno"));
		oGanadoEnfermo.setFechNaciGana(rs.getString("fechNaciGana"));
		oGanadoEnfermo.setEdadGana(rs.getInt("edadGana"));
		oGanadoEnfermo.setFechIngr(rs.getString("fechIngr"));
		oGanadoEnfermo.setObse(rs.getString("obse"));
		
		return oGanadoEnfermo;
	}
	

}
