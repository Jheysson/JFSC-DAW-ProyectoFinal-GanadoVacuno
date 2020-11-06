package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GanadoVacunoHembraRowMapper implements RowMapper<GanadoVacunoHembra>{

	@Override
	public GanadoVacunoHembra mapRow(ResultSet rs, int rowNum) throws SQLException {
		GanadoVacunoHembra oGanadoHembra = new GanadoVacunoHembra();
		oGanadoHembra.setCuiaGana(rs.getInt("cuiaGana"));
		oGanadoHembra.setEdadGana(rs.getInt("edadGana"));
		oGanadoHembra.setEtapaGana(rs.getString("etapaGana"));
		oGanadoHembra.setAliaGana(rs.getString("aliaGana"));
		oGanadoHembra.setFechNaciGana(rs.getString("fechNaciGana"));
		oGanadoHembra.setPesoGana(rs.getDouble("pesoGana"));
		oGanadoHembra.setTallGana(rs.getDouble("tallGana"));
		oGanadoHembra.setIdEstaActi("idEstaActi");
		oGanadoHembra.setIdEstaAnim(rs.getString("idEstaAnim"));
		oGanadoHembra.setCantPartGana(rs.getInt("cantPartGana"));
		oGanadoHembra.setIdGeno(rs.getString("idGeno"));
		oGanadoHembra.setIdTipoGana(rs.getString("idTipoGana"));
		oGanadoHembra.setIdOrig(rs.getString("idOrig"));
		oGanadoHembra.setCuiaMadr(rs.getInt("cuiaMadr"));
		oGanadoHembra.setCuiaPadr(rs.getInt("cuiaPadr"));
		oGanadoHembra.setCodiPropInse(rs.getInt("codiPropInse"));
		oGanadoHembra.setObse(rs.getString("obse"));
		return oGanadoHembra;
	}

}
