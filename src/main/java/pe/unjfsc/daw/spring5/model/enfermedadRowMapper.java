package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class enfermedadRowMapper implements RowMapper<enfermedad>{

	@Override
	public enfermedad mapRow(ResultSet rs, int rowNum) throws SQLException {
		enfermedad oenfe= new enfermedad();		
		oenfe.setId_Enfe(rs.getInt("id_Enfe"));
		oenfe.setNombEnfe(rs.getString("nombEnfe"));
		return oenfe;
	}

}
