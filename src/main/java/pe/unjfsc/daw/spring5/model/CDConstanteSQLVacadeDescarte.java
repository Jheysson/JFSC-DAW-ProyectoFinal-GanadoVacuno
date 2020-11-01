package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLVacadeDescarte {
	public static final String SQL_SCHEMA = "bd_ganadovacuno";
	public static final String SQL_TABLE = "vacadedescarte";
	public static final String SQL_INSERT = "INSERT INTO vacadedescarte (cuiaGana) VALUES (?)";
	public static final String SQL_DELETE = "UPDATE " + SQL_TABLE + " SET esta = 0 WHERE idVacaDesc = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM vacadedescarte WHERE esta = 1";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM vacadedescarte WHERE idVacaDesc = ?";
}
