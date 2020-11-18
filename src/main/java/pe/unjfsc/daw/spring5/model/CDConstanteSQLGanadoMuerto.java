package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLGanadoMuerto {
	
	public static final String SQL_TABLE = "ganadomuerto";
	public static final String SQL_INSERT = "INSERT INTO ganadomuerto(cuiaGana, causMuer) values (?,?)";
	public static final String SQL_ESTADOMUERTO = "UPDATE registroganado SET idEstaAnim = 3 WHERE cuiaGana = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM vistaganadomuerto";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM ganadomuerto WHERE cuiaGana = ?";
}
