package pe.unjfsc.daw.spring5.model.consta;

public class CDConstanteSQLGanadoVacuno {
	public static final String SQL_TABLE = "registroganado";
	public static final String SQL_SELECT_ALL = "SELECT * FROM vallganadovacuno";
	public static final String SQL_SELECT_ALL_HEMBRAS = "SELECT * FROM vGanadoHembra";
	public static final String SQL_SELECT_ALL_MACHOS = "SELECT * FROM vGanadoMacho";
	public static final String SQL_INSERT = "INSERT INTO registroGanado (cuiaGana, idSexo, edadGana, etapaGana, aliaGana,"
			+ " fechNaciGana, pesoGana, tallGana, idEstaActi, idEstaAnim, cantPartGana, "
			+ "idGeno, idTipoGana, idOrig, cuiaMadr, cuiaPadr, codiPropInse, obse, esta) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM registroganado WHERE cuiaGana = ?";
	public static final String SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET idSexo = ?, idGeno = ?, edadGana = ?, etapaGana = ?, aliaGana = ?, fechNaciGana = ?, pesoGana= ?, tallGana= ?"
			+ ",idEstaActi = ?,cantPartGana = ?, idGeno = ?, idTipoGana = ?, idOrig = ?"
			+ ", cuiaMadr = ?, cuiaPadr = ?, codiPropInse = ?, obse = ? WHERE cuiaGana = ?";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " SET esta = 0 WHERE cuiaGana = ?";
	public static final String SQL_UPDATE_ALL_HEMBRAS = "UPDATE "+SQL_TABLE+" SET edadGana = ?, etapaGana = ? WHERE cuiaGana = ?";
	public static final String SQL_UPDATE_ALL_MACHOS = "UPDATE "+SQL_TABLE+" SET edadGana = ?, etapaGana = ? WHERE cuiaGana = ?";
	
	public static final String SQL_FIND_HEMBRA_APTA = "SELECT * FROM registroganado WHERE edadGana>20 and idSexo=1 and cuiaGana = ?";
}
