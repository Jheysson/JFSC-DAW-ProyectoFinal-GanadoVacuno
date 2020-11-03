package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ganadoMuertoRowMapper implements RowMapper<ganadoMuerto>{

	@Override
	public ganadoMuerto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ganadoMuerto objGanadoMuerto=new ganadoMuerto();
		objGanadoMuerto.setIdGanaMuer(rs.getInt("idGanaMuer"));
		objGanadoMuerto.setCuiaGana(rs.getInt("cuiaGana"));
		objGanadoMuerto.setCausMuer(rs.getString("causMuer"));
		objGanadoMuerto.setEsta(rs.getInt("esta"));
		return objGanadoMuerto;
	}

}
