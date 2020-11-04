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

import pe.unjfsc.daw.spring5.model.GanadoVacuno;
import pe.unjfsc.daw.spring5.model.GanadoVacunoRowMapper;
import pe.unjfsc.daw.spring5.model.CDConstanteSQLGanadoVacuno;

@Transactional
@Repository
public class GanadoVacunoDaoImpl implements GanadoVacunoDao{
	private static final Logger log = LoggerFactory.getLogger("DAOIMPL");
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<GanadoVacuno> getAllGanadoVacuno() {
		RowMapper<GanadoVacuno> rowMapper = new GanadoVacunoRowMapper();
		List<GanadoVacuno> list = jdbcTemplate.query(CDConstanteSQLGanadoVacuno.SQL_SELECT_ALL, rowMapper);
		return list;
	}

	@Override
	public List<GanadoVacuno> getGanadoVacunoHembra() {
		RowMapper<GanadoVacuno> rowMapper = new GanadoVacunoRowMapper();
		List<GanadoVacuno> list = jdbcTemplate.query(CDConstanteSQLGanadoVacuno.SQL_SELECT_ALL_HEMBRAS, rowMapper);
		return list;
	}

	@Override
	public List<GanadoVacuno> getGanadoVacunoMacho() {
		RowMapper<GanadoVacuno> rowMapper = new GanadoVacunoRowMapper();
		List<GanadoVacuno> list = jdbcTemplate.query(CDConstanteSQLGanadoVacuno.SQL_SELECT_ALL_MACHOS, rowMapper);
		return list;
	}

	@Override
	public GanadoVacuno findGanadoVacunoByCuia(int cuia) {
		RowMapper<GanadoVacuno> rowMapper = new BeanPropertyRowMapper<GanadoVacuno>(GanadoVacuno.class);
		GanadoVacuno pGanadoVacuo = jdbcTemplate.queryForObject(CDConstanteSQLGanadoVacuno.SQL_SELECT_BY_ID, rowMapper, cuia )	;	
		return pGanadoVacuo;
	}
	
	@Override
	public GanadoVacuno findHembrasAptas(int cuia) {
		RowMapper<GanadoVacuno> rowMapper = new BeanPropertyRowMapper<GanadoVacuno>(GanadoVacuno.class);
		GanadoVacuno pGanadoVacuno = jdbcTemplate.queryForObject(CDConstanteSQLGanadoVacuno.SQL_FIND_HEMBRA_APTA,rowMapper, cuia);
		return pGanadoVacuno;
	}

	@Override
	public void addGanadoVacuno(GanadoVacuno pGanadoVacuno) {
		
	}
	@Override
	public void addGanadoVacunoHembra(GanadoVacuno pGanadoVacuno) {
		
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_INSERT,
				pGanadoVacuno.getCuiaGana(), 1, calcularEdad(pGanadoVacuno.getFechNaciGana()),
				calcularEtapa(calcularEdad(pGanadoVacuno.getFechNaciGana())),
				pGanadoVacuno.getAliaGana(), pGanadoVacuno.getFechNaciGana(), 
				pGanadoVacuno.getPesoGana(), pGanadoVacuno.getTallGana(), 
				pGanadoVacuno.getIdEstaActi(), 1, pGanadoVacuno.getCantPartGana(), 
				pGanadoVacuno.getIdGeno(), pGanadoVacuno.getIdTipoGana(), pGanadoVacuno.getIdOrig(),
				pGanadoVacuno.getCuiaMadr(), pGanadoVacuno.getCuiaPadr(), pGanadoVacuno.getCodiPropInse(), 
				pGanadoVacuno.getObse(), 1);
	}

	@Override
	public void addGanadoVacunoMacho(GanadoVacuno pGanadoVacuno) {
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_INSERT,
				pGanadoVacuno.getCuiaGana(), 2, calcularEdad(pGanadoVacuno.getFechNaciGana()),
				calcularEtapa(calcularEdad(pGanadoVacuno.getFechNaciGana())),
				pGanadoVacuno.getAliaGana(), pGanadoVacuno.getFechNaciGana(), 
				pGanadoVacuno.getPesoGana(), pGanadoVacuno.getTallGana(), 
				4, 1, 0, 
				pGanadoVacuno.getIdGeno(), 2, pGanadoVacuno.getIdOrig(),
				pGanadoVacuno.getCuiaMadr(), pGanadoVacuno.getCuiaPadr(), pGanadoVacuno.getCodiPropInse(), 
				pGanadoVacuno.getObse(), 1);		
	}

	@Override
	public void updateGanadoVacuno(GanadoVacuno pGanadoVacuno) {
		log.info("LLEGANDO PARA ACTUALIZAR: {}",pGanadoVacuno);
		if (pGanadoVacuno.getIdSexo()==1) {
			jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_UPDATE,
					1,
					pGanadoVacuno.getIdGeno(),
					calcularEdad(pGanadoVacuno.getFechNaciGana()),
					calcularEtapa(calcularEdad(pGanadoVacuno.getFechNaciGana())),
					pGanadoVacuno.getAliaGana(),
					pGanadoVacuno.getFechNaciGana(),
					pGanadoVacuno.getPesoGana(),
					pGanadoVacuno.getTallGana(),
					pGanadoVacuno.getIdEstaActi(),
					pGanadoVacuno.getCantPartGana(),
					pGanadoVacuno.getIdGeno(),
					pGanadoVacuno.getIdTipoGana(),
					pGanadoVacuno.getIdOrig(),
					pGanadoVacuno.getCuiaMadr(),
					pGanadoVacuno.getCuiaPadr(),
					pGanadoVacuno.getCodiPropInse(),
					pGanadoVacuno.getObse(),
					pGanadoVacuno.getCuiaGana());
			log.info("CONVIRTIENDO ACTUALIZAR: {}",pGanadoVacuno);
		}else {
			jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_UPDATE,
					2,
					pGanadoVacuno.getIdGeno(),
					calcularEdad(pGanadoVacuno.getFechNaciGana()),
					calcularEtapa(calcularEdad(pGanadoVacuno.getFechNaciGana())),
					pGanadoVacuno.getAliaGana(),
					pGanadoVacuno.getFechNaciGana(),
					pGanadoVacuno.getPesoGana(),
					pGanadoVacuno.getTallGana(),
					4,
					null,
					pGanadoVacuno.getIdGeno(),
					2,
					pGanadoVacuno.getIdOrig(),
					pGanadoVacuno.getCuiaMadr(),
					pGanadoVacuno.getCuiaPadr(),
					pGanadoVacuno.getCodiPropInse(),
					pGanadoVacuno.getObse(),
					pGanadoVacuno.getCuiaGana());
		}
		
	}

	@Override
	public void deleteGanadoVacuno(int cuia) {
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_DELETE,cuia);
		
	}
	protected int calcularEdad(String fechNaci) {
		int edad = (int) ChronoUnit.MONTHS.between(LocalDate.parse(fechNaci), LocalDate.now());
		return edad;
	}
	
	protected String calcularEtapa(int edad) {
		String etapa="";
		if(edad <= 4) {
			etapa = "Ternero(a)";
		}else if(edad > 4 && edad <=12) {
			etapa = "Destete";
		}else if(edad > 12 && edad <=24) {
			etapa = "Becerro(a)";
		}else if(edad >= 24) {
			etapa = "Adulto";
		}		
		return etapa;
	}

	

	
	
	

}
