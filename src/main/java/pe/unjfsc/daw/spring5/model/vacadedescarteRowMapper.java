package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class vacadedescarteRowMapper implements RowMapper<vacadedescarte>{

	@Override
	public vacadedescarte mapRow(ResultSet rs, int rowNum) throws SQLException {
		vacadedescarte ovacadedescarte = new vacadedescarte();
		ovacadedescarte.setIdVacaDesc(rs.getInt("idVacaDesc"));
		ovacadedescarte.setCuiaGana(rs.getInt("cuiaGana"));
		ovacadedescarte.setAliaGana(rs.getString("aliaGana"));
		ovacadedescarte.setFechNaciGana(rs.getString("fechNaciGana"));
		ovacadedescarte.setEdadGana(rs.getInt("edadGana"));
		ovacadedescarte.setEtapaGana(rs.getString("etapaGana"));
		ovacadedescarte.setObse(rs.getString("obse"));
		ovacadedescarte.setEsta(rs.getInt("esta"));
		return ovacadedescarte;
	}

}
