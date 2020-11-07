package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GanadoVacunoMachoRowMapper implements RowMapper<GanadoVacunoMacho>{

	@Override
	public GanadoVacunoMacho mapRow(ResultSet rs, int rowNum) throws SQLException {
		GanadoVacunoMacho oGanadoMacho = new GanadoVacunoMacho();
		oGanadoMacho.setCuiaGana(rs.getInt("cuiaGana"));
		oGanadoMacho.setEdadGana(rs.getInt("edadGana"));
		oGanadoMacho.setEtapaGana(rs.getString("etapaGana"));
		oGanadoMacho.setAliaGana(rs.getString("aliaGana"));
		oGanadoMacho.setFechNaciGana(rs.getString("fechNaciGana"));
		oGanadoMacho.setPesoGana(rs.getDouble("pesoGana"));
		oGanadoMacho.setTallGana(rs.getDouble("tallGana"));		
		oGanadoMacho.setIdEstaAnim(rs.getString("idEstaAnim"));		
		oGanadoMacho.setIdGeno(rs.getString("idGeno"));
		oGanadoMacho.setIdTipoGana(rs.getString("idTipoGana"));
		oGanadoMacho.setIdOrig(rs.getString("idOrig"));
		oGanadoMacho.setCuiaMadr(rs.getInt("cuiaMadr"));
		oGanadoMacho.setCuiaPadr(rs.getInt("cuiaPadr"));
		oGanadoMacho.setCodiPropInse(rs.getInt("codiPropInse"));
		oGanadoMacho.setObse(rs.getString("obse"));
		return oGanadoMacho;
	}

}
