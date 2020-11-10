package pe.unjfsc.daw.spring5.dao.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.dao.GanadoVacunoHembraDao;
import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;
import pe.unjfsc.daw.spring5.model.GanadoVacunoHembraRowMapper;
import pe.unjfsc.daw.spring5.model.consta.CDConstanteSQLGanadoVacuno;

@Transactional
@Repository
public class GanadoVacunoHembraDaoImpl implements GanadoVacunoHembraDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static final Logger log = LoggerFactory.getLogger("DAO IMPL HEMBRA");
	
	@Override
	public List<GanadoVacunoHembra> getGanadoVacunoHembra() {
		RowMapper<GanadoVacunoHembra> rowMapper = new GanadoVacunoHembraRowMapper();
		List<GanadoVacunoHembra> list = jdbcTemplate.query(CDConstanteSQLGanadoVacuno.SQL_SELECT_ALL_HEMBRAS, rowMapper);
		return list;
	}

	@Override
	public GanadoVacunoHembra findGanadoVacunoByCuia(int cuia) {
		RowMapper<GanadoVacunoHembra> rowMapper = new BeanPropertyRowMapper<GanadoVacunoHembra>(GanadoVacunoHembra.class);
		GanadoVacunoHembra pGanadoVacuo = jdbcTemplate.queryForObject(CDConstanteSQLGanadoVacuno.SQL_SELECT_BY_ID, rowMapper, cuia )	;	
		return pGanadoVacuo;
	}

	@Override
	public void addGanadoVacunoHembra(GanadoVacunoHembra pGanadoVacunoHembra) {
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_INSERT,
				pGanadoVacunoHembra.getCuiaGana(), 1, calcularEdad(pGanadoVacunoHembra.getFechNaciGana()),
				calcularEtapa(calcularEdad(pGanadoVacunoHembra.getFechNaciGana())),
				pGanadoVacunoHembra.getAliaGana(), pGanadoVacunoHembra.getFechNaciGana(), 
				pGanadoVacunoHembra.getPesoGana(), pGanadoVacunoHembra.getTallGana(), 
				pGanadoVacunoHembra.getIdEstaActi(), 1, pGanadoVacunoHembra.getCantPartGana(), 
				pGanadoVacunoHembra.getIdGeno(), pGanadoVacunoHembra.getIdTipoGana(), pGanadoVacunoHembra.getIdOrig(),
				pGanadoVacunoHembra.getCuiaMadr(), pGanadoVacunoHembra.getCuiaPadr(), pGanadoVacunoHembra.getCodiPropInse(), 
				pGanadoVacunoHembra.getObse(), 1);
		
	}

	@Override
	public void updateGanadoVacunoHembra(GanadoVacunoHembra pGanadoVacunoHembra) {
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_UPDATE,
				1,
				pGanadoVacunoHembra.getIdGeno(),
				calcularEdad(pGanadoVacunoHembra.getFechNaciGana()),
				calcularEtapa(calcularEdad(pGanadoVacunoHembra.getFechNaciGana())),
				pGanadoVacunoHembra.getAliaGana(),
				pGanadoVacunoHembra.getFechNaciGana(),
				pGanadoVacunoHembra.getPesoGana(),
				pGanadoVacunoHembra.getTallGana(),
				pGanadoVacunoHembra.getIdEstaActi(),
				pGanadoVacunoHembra.getCantPartGana(),
				pGanadoVacunoHembra.getIdGeno(),
				pGanadoVacunoHembra.getIdTipoGana(),
				pGanadoVacunoHembra.getIdOrig(),
				pGanadoVacunoHembra.getCuiaMadr(),
				pGanadoVacunoHembra.getCuiaPadr(),
				pGanadoVacunoHembra.getCodiPropInse(),
				pGanadoVacunoHembra.getObse(),
				pGanadoVacunoHembra.getCuiaGana());
		
		
	}

	@Override
	public void deleteGanadoVacunoHembra(int cuia) {
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_DELETE,cuia);
		
	}
	@Override
	public void updateAllHembras() {
		List<GanadoVacunoHembra> listaHembra = new ArrayList<GanadoVacunoHembra>();
		listaHembra = getGanadoVacunoHembra();
		
		GanadoVacunoHembra oGanadoHembra = new GanadoVacunoHembra();
		
		Iterator<GanadoVacunoHembra> it = listaHembra.iterator();
		while(it.hasNext()) {
			oGanadoHembra = it.next();
			jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_UPDATE_ALL_HEMBRAS,
					calcularEdad(oGanadoHembra.getFechNaciGana()),
					calcularEtapa(calcularEdad(oGanadoHembra.getFechNaciGana())),				
					oGanadoHembra.getCuiaGana());
			log.info(":{}",oGanadoHembra);
		}
		
	}

	protected int calcularEdad(String fechNaci) {
		int edad = (int) ChronoUnit.MONTHS.between(LocalDate.parse(fechNaci), LocalDate.now());
		return edad;
	}
	
	protected String calcularEtapa(int edad) {
		String etapa="";
		if(edad <= 4) {
			etapa = "Ternera";
		}else if(edad > 4 && edad <=12) {
			etapa = "Destete";
		}else if(edad > 12 && edad <=24) {
			etapa = "Becerra";
		}else if(edad >= 24) {
			etapa = "Vaca Adulta";
		}		
		return etapa;
	}

	
}
