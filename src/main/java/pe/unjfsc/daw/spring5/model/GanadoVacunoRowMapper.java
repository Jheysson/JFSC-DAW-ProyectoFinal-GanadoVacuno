package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GanadoVacunoRowMapper implements RowMapper<GanadoVacuno>{

	@Override
	public GanadoVacuno mapRow(ResultSet rs, int rowNum) throws SQLException {
		GanadoVacuno oGanadoVacuno = new GanadoVacuno();
		oGanadoVacuno.setCuiaGana(rs.getInt("cuiaGana"));
		oGanadoVacuno.setIdSexo(rs.getInt("idSexo"));
		oGanadoVacuno.setEdadGana(rs.getInt("edadGana"));
		oGanadoVacuno.setEtapaGana(rs.getString("etapaGana"));
		oGanadoVacuno.setAliaGana(rs.getString("aliaGana"));
		oGanadoVacuno.setFechNaciGana(rs.getString("fechNaciGana"));
		oGanadoVacuno.setPesoGana(rs.getDouble("pesoGana"));
		oGanadoVacuno.setTallGana(rs.getDouble("tallGana"));
		oGanadoVacuno.setIdEstaActi(rs.getInt("idEstaActi"));
		oGanadoVacuno.setIdEstaAnim(rs.getInt("idEstaAnim"));
		oGanadoVacuno.setCantiPartGana(rs.getInt("cantiPartGana"));
		return oGanadoVacuno;
	}

}
