package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLGanadoEnfermo {
	
	public static final String SQL_SCHEMA = "daw2";
	public static final String SQL_TABLE = "ganadoenfermo";
	public static final String SQL_INSERT = "INSERT INTO ganadoenfermo (cuiaGana, idEnfe, fechIngr, obse) VALUES (?, ?, ?, ?)";
	public static final String SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET idEnfe = ?, fechIngr = ?, obse = ? WHERE cuiaGana = ?";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " SET esta = 0 WHERE cuiaGana = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM vistaganadoenfermo";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM ganadoenfermo WHERE cuiaGana = ?";

}
