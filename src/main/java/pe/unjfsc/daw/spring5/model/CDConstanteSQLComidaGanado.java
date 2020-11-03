package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLComidaGanado {
	
	public static final String SQL_TABLE = "comidaganado";
	public static final String SQL_INSERT = "INSERT INTO comidaganado(idComiGana, comiGanaDiri, comiRaci, idTipoComi) VALUES (?, ?, ?, ?)";
	public static final String SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET comiGanaDiri = ?, comiRaci = ?, idTipoComi = ? WHERE idComiGana = ?";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " idComiGana = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM comidaganado";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM comidaganado WHERE idComiGana = ?";
}
