package pe.unjfsc.daw.spring5.model;

public class CDConstanteSQLecheProducida {
	
	public static final String SQL_SCHEMA = "bd_ganadovacuno";
	public static final String SQL_TABLE = "lecheproducidadia";
	
	public static final String SQL_INSERT = "INSERT INTO lecheproducidadia(cantiLitrLechProd,idVacaProd,observacion) values (?,?,?)";
    public static final String SQL_UPDATE = "UPDATE lecheproducidadia SET cantiLitrLechProd =?, observacion=?  WHERE idLechProd = ?";
	public static final String SQL_DELETE = "DELETE FROM lecheproducidadia WHERE idLechProd = ? ";
	
	//mod
	public static final String SQL_SELECT_ALL = "SELECT * FROM vlecheProducida";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM vlecheProducida WHERE idLechProd = ?";
	public static final String SQL_SELECT_BY_CUIA_LECHERA = "SELECT * FROM vacasenproduccionleche WHERE cuiaGana = ?";
	
	//PARA DASHBOARD
	public static final String SQL_SELECT_ALL_DASHBOARD = "SELECT * FROM vlecheProducida";
}


