package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GanadoMuertoRowMapper implements RowMapper<GanadoMuerto>{

	@Override
	public GanadoMuerto mapRow(ResultSet rs, int rowNum) throws SQLException {
		GanadoMuerto oGanadoMuerto=new GanadoMuerto();
		oGanadoMuerto.setIdGanaMuer(rs.getInt("idGanaMuer"));
		oGanadoMuerto.setCuiaGana(rs.getInt("cuiaGana"));
		oGanadoMuerto.setAliaGana(rs.getString("aliaGana"));
		oGanadoMuerto.setFechNaciGana(rs.getString("fechNaciGana"));
		oGanadoMuerto.setEdadGana(rs.getInt("edadGana"));
		oGanadoMuerto.setIdGeno(rs.getInt("idGeno"));
		oGanadoMuerto.setNombEtapa(rs.getString("nombEtapa"));
		oGanadoMuerto.setCausMuer(rs.getString("causMuer"));
		
		return oGanadoMuerto;
	}

}

