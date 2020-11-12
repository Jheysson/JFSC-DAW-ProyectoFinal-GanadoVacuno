package pe.unjfsc.daw.spring5.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.model.CDConstanteSQLNatalidad;
import pe.unjfsc.daw.spring5.model.natalidad;
import pe.unjfsc.daw.spring5.model.natalidadRowMapper;

@Transactional
@Repository
public class natalidadDaoImpl implements natalidadDao{
	
	private static final Logger log = LoggerFactory.getLogger("DAO IMPL NATALIDAD");
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<natalidad> getAllNatalidad() {
		RowMapper<natalidad> rowMapper = new natalidadRowMapper();
		List<natalidad> list = jdbcTemplate.query(CDConstanteSQLNatalidad.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public natalidad findnatalidadByCuia(int cuia) {
		RowMapper<natalidad> rowMapper = new BeanPropertyRowMapper<natalidad>(natalidad.class);
		natalidad pnatalidad = jdbcTemplate.queryForObject(CDConstanteSQLNatalidad.SQL_SELECT_BY_ID, rowMapper, cuia);
		return pnatalidad;
	
	}

	@Override
	public void addnatalidad(natalidad pnatalidad) {
		log.info("LLEGANDO SEXO: "+pnatalidad.getIdSexo());
		jdbcTemplate.update(CDConstanteSQLNatalidad.SQL_INSERT, 
				pnatalidad.getCuiaNata(),
				pnatalidad.getIdSexo(),
				pnatalidad.getIdGeno(),
				pnatalidad.getFechNaciNata(),
				pnatalidad.getPesoNata(),
				pnatalidad.getCuiaMadr(),
				pnatalidad.getCuiaPadr(),
				pnatalidad.getCodiProp(),
				pnatalidad.getObse(),
				pnatalidad.getFoto()
				);
		jdbcTemplate.update(CDConstanteSQLNatalidad.SQL_INSERT_REGISTRO_GANADO,
				pnatalidad.getCuiaNata(),
				"",
				pnatalidad.getIdSexo(),				
				4, //Estado activo N.A
				1, //Estado animal Normal,
				asignarTipo(pnatalidad.getIdSexo()),
				0, //Cantidad de partos,
				2, //Origen 2 = Autoctono
				pnatalidad.getIdGeno(),
				pnatalidad.getFechNaciNata(),
				calcularEdad(pnatalidad.getFechNaciNata()),
				calcularEtapa(calcularEdad(pnatalidad.getFechNaciNata()), pnatalidad.getIdSexo()),
				pnatalidad.getPesoNata(),
				0,
				pnatalidad.getCuiaMadr(),
				pnatalidad.getCuiaPadr(),
				pnatalidad.getCodiProp(),
				pnatalidad.getObse(),
				pnatalidad.getFoto()
				);
		
	}

	@Override
	public void updatenatalidad(natalidad pnatalidad) {
		jdbcTemplate.update(CDConstanteSQLNatalidad.SQL_UPDATE,
				pnatalidad.getIdSexo(),
				pnatalidad.getIdGeno(),
				pnatalidad.getFechNaciNata(),
				pnatalidad.getPesoNata(),
				pnatalidad.getCuiaMadr(),
				pnatalidad.getCuiaPadr(),
				pnatalidad.getCodiProp(),
				pnatalidad.getObse(),
				pnatalidad.getCuiaNata()
				);
		
	}

	@Override
	public void deletenatalidad(int cuia) {
		jdbcTemplate.update(CDConstanteSQLNatalidad.SQL_DELETE, cuia);
		
	}
	
	protected int calcularEdad(String fechNaci) {
		int edad = (int) ChronoUnit.MONTHS.between(LocalDate.parse(fechNaci), LocalDate.now());
		return edad;
	}
	
	protected String calcularEtapa(int edad, String sexo) {
		String etapa="";
		if (sexo.equals("1")) { //Hembra
			if(edad <= 4) {
				etapa = "Ternera";
			}else if(edad > 4 && edad <=12) {
				etapa = "Destete";
			}else if(edad > 12 && edad <=24) {
				etapa = "Becerra";
			}else if(edad >= 24) {
				etapa = "Vaca Adulta";
			}		
		}else { //Macho
			if(edad <= 4) {
				etapa = "Ternero";
			}else if(edad > 4 && edad <=12) {
				etapa = "Destete";
			}else if(edad > 12 && edad <=24) {
				etapa = "Becerro";
			}else if(edad >= 24) {
				etapa = "Toro Adulto";
			}		
		}		
		return etapa;
	}
	protected int asignarTipo(String sexo) {
		int tipo = 0;
		if (sexo.equals("1")) {
			tipo = 1; //Leche
		}else {
			tipo = 2; //Carne
		}
		return tipo;
	}
}
