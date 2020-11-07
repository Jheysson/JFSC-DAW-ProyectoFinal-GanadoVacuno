package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class inseminacionRowMapper implements RowMapper<inseminacion>{

	@Override
	public inseminacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		inseminacion oinse= new inseminacion();		
		oinse.setCodiPropInse(rs.getInt("codiPropInse"));
		oinse.setIdGeno(rs.getString("idGeno"));
		oinse.setPesoPropInse(rs.getDouble("pesoPropInse"));
		oinse.setTallPropInse(rs.getDouble("tallPropInse"));
		oinse.setLugaPropInse(rs.getString("lugaPropInse"));
		oinse.setPrecPropInse(rs.getDouble("precPropInse"));
		oinse.setFechCompPropInse(rs.getString("fechCompPropInse"));
		oinse.setObse(rs.getString("obse"));
		oinse.setEsta(rs.getInt("esta"));
		return oinse;
	}

}
