package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLInseminacion {
	
	public static final String SQL_TABLE = "propietarioinseminacion";
	public static final String SQL_INSERT = "INSERT INTO propietarioinseminacion(codiPropInse, idGeno, pesoPropInse, tallPropInse, lugaPropInse, precPropInse, fechCompPropInse, obse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET idGeno = ?, pesoPropInse = ?, tallPropInse = ?, lugaPropInse = ?, precPropInse = ?, fechCompPropInse = ?, obse = ? WHERE codiPropInse = ?";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " SET esta = 0 WHERE codiPropInse = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM propietarioinseminacion WHERE esta = 1";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM propietarioinseminacion WHERE codiPropInse = ?";
}
