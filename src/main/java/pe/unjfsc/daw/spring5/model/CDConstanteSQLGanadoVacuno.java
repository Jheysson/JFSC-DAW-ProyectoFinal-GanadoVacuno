package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLGanadoVacuno {
	public static final String SQL_TABLE = "registroganado";
	public static final String SQL_SELECT_ALL = "SELECT * FROM registroganado WHERE esta = 1";
	public static final String SQL_SELECT_ALL_HEMBRAS = "SELECT * FROM registroganado  WHERE esta = 1 and idSexo = 1";
	public static final String SQL_SELECT_ALL_MACHOS = "SELECT * FROM registroganado  WHERE esta = 1 and idSexo = 2";
	public static final String SQL_INSERT = "INSERT INTO registroGanado (cuiaGana, idSexo, edadGana, etapaGana, aliaGana,"
			+ " fechNaciGana, pesoGana, tallGana, idEstaActi, idEstaAnim, cantPartGana, "
			+ "idGeno, idTipoGana, idOrig, cuiaMadr, cuiaPadr, codiPropInse, obse, esta) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM registroganado WHERE cuiaGana = ?";
	public static final String SQL_UPDATE = "UPDATE " + SQL_TABLE + "idSexo = ?, idGeno = ?, edadGana = ?, etapaGana = ?, aliaGana = ?, fechNaciGana = ?, pesoGana= ?, tallGana= ?"
			+ ",idEstaActi = ?,cantPartGana = ?, idGeno = ?, idTipoGana = ?, idOrig = ?"
			+ ", cuiaMard = ?, cuiaPadr = ?, codiPropInse = ?, obse = ?, WHERE cuiaNata = ?";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " SET esta = 0 WHERE cuiaGana = ?";
}
