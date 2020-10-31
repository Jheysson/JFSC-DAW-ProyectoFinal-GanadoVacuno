package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLNatalidad {
	
	public static final String SQL_SCHEMA = "bd_ganadovacuno";
	public static final String SQL_TABLE = "natalidad";
	public static final String SQL_INSERT = "INSERT INTO natalidad (cuiaNata, idSexo, idGeno, fechNaciNata, pesoNata, cuiaMadr, cuiaPadr, codiProp, obse) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_UPDATE = "UPDATE " + SQL_TABLE + " SET idSexo = ?, idGeno = ?, fechNaciNata = ?, pesoNata = ?, cuiaMadr = ?, cuiaPadr = ?, codiProp = ?, obse = ? WHERE cuiaNata = ?";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " SET esta = 0 WHERE cuiaNata = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM natalidad WHERE esta = 1";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM natalidad WHERE cuiaNata = ?";
}
