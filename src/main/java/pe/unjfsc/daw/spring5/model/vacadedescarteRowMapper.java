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
		ovacadedescarte.setEsta(rs.getInt("esta"));
		return ovacadedescarte;
	}

}
