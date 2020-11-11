package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLVacaEnProduccionLeche {
	public static final String SQL_SCHEMA = "bd_ganadovacuno";
	public static final String SQL_TABLE = "vacasenproduccionleche";
	public static final String SQL_INSERT = "INSERT INTO vacasenproduccionleche (cuiaGana,idSuple,observacion) VALUES (?,?,?)";
	public static final String SQL_UPDATE = "UPDATE vacasenproduccionleche SET   idSuple = ?, observacion = ? WHERE idVacaProd = ?";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " SET esta = 0 WHERE idVacaProd = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM vvacaproduccionleche ";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM vvacaproduccionleche WHERE idVacaProd = ?";
	

	public static final String SQL_SELECT_BY_CUIA_GANADO = "SELECT * FROM registroganado WHERE cuiaGana = ?";

	
}
