package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLGanadoMuerto {
	public static final String SQL_SCHEMA = "bd_ganadovacuno";
	public static final String SQL_TABLE = "ganadomuerto";
	
	public static final String SQL_INSERT = "INSERT INTO ganadomuerto(cuiaGana,causMuer) values (?,?)";
    //public static final String SQL_UPDATE = "UPDATE ganadomuerto SET cantiLitrLechProd =?, idVacaProd = ? WHERE idLechProd = ?";
	public static final String SQL_DELETE = "UPDATE ganadomuerto SET esta=0 WHERE idGanaMuer = ? ";
	
	
	public static final String SQL_SELECT_ALL = "SELECT * FROM ganadomuerto WHERE esta=1";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM ganadomuerto WHERE idGanaMuer = ?";
}
