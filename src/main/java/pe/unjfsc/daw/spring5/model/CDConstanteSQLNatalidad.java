package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLNatalidad {
	
	public static final String SQL_SCHEMA = "bd_ganadovacuno";
	public static final String SQL_TABLE = "natalidad";
	public static final String SQL_INSERT = "INSERT INTO natalidad (cuiaNata, idSexo, idGeno, fechNaciNata, pesoNata, cuiaMadr, cuiaPadr, codiProp, obse, imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_UPDATE = "UPDATE natalidad SET idSexo = ?, idGeno = ?, fechNaciNata = ?, pesoNata = ?, cuiaMadr = ?, cuiaPadr = ?, codiProp = ?, obse = ? WHERE natalidad.cuiaNata = ?";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " SET esta = 0 WHERE cuiaNata = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM vistanatalidad";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM natalidad WHERE cuiaNata = ?";
	
	//Insertar a registroganado
	public static final String SQL_TABLE_REGISTRO_GANADO = "registroganado";
	public static final String SQL_INSERT_REGISTRO_GANADO = "INSERT INTO "+SQL_TABLE_REGISTRO_GANADO+" (cuiaGana, aliaGana, idSexo, idEstaActi, idEstaAnim, idTipoGana, cantPartGana, idOrig, idGeno, fechNaciGana, edadGana, etapaGana, pesoGana, tallGana, cuiaMadr, cuiaPadr, codiPropInse, obse, imagen)"
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	
	
	//Aumentar la cantidad de partos 
	public static final String SQL_CHANGE_SUM_PARTOS = "UPDATE registroganado SET cantPartGana = cantPartGana + 1 WHERE registroganado.cuiaGana = ?";
}
