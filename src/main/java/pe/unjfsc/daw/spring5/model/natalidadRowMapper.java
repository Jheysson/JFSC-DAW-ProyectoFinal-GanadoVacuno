package pe.unjfsc.daw.spring5.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class natalidadRowMapper implements RowMapper<natalidad>{

	@Override
	public natalidad mapRow(ResultSet rs, int rowNum) throws SQLException {
		natalidad onatalidad = new natalidad();		
		onatalidad.setCuiaNata(rs.getInt("cuiaNata"));
		onatalidad.setIdSexo(rs.getInt("idSexo"));
		onatalidad.setIdGeno(rs.getInt("idGeno"));
		onatalidad.setFechNaciNata(rs.getString("fechNaciNata"));
		onatalidad.setPesoNata(rs.getDouble("pesoNata"));
		onatalidad.setCuiaMadr(rs.getInt("cuiaMadr"));
		onatalidad.setCuiaPadr(rs.getInt("cuiaPadr"));
		onatalidad.setCodiProp(rs.getInt("codiProp"));
		onatalidad.setObse(rs.getString("obse"));
		onatalidad.setEsta(rs.getInt("esta"));	
		return onatalidad;
	}

}
