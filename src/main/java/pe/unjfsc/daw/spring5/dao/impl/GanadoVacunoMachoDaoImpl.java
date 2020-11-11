package pe.unjfsc.daw.spring5.dao.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.unjfsc.daw.spring5.dao.GanadoVacunoMachoDao;
import pe.unjfsc.daw.spring5.model.GanadoVacunoHembra;
import pe.unjfsc.daw.spring5.model.GanadoVacunoMacho;
import pe.unjfsc.daw.spring5.model.GanadoVacunoMachoRowMapper;
import pe.unjfsc.daw.spring5.model.consta.CDConstanteSQLGanadoVacuno;

@Transactional
@Repository
public class GanadoVacunoMachoDaoImpl implements GanadoVacunoMachoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<GanadoVacunoMacho> getGanadoVacunoMacho() {
		RowMapper<GanadoVacunoMacho> rowMapper = new GanadoVacunoMachoRowMapper();
		List<GanadoVacunoMacho> list = jdbcTemplate.query(CDConstanteSQLGanadoVacuno.SQL_SELECT_ALL_MACHOS, rowMapper);
		return list;
	}

	@Override
	public GanadoVacunoMacho findGanadoVacunoByCuia(int cuia) {
		RowMapper<GanadoVacunoMacho> rowMapper = new BeanPropertyRowMapper<GanadoVacunoMacho>(GanadoVacunoMacho.class);
		GanadoVacunoMacho pGanadoVacuno = jdbcTemplate.queryForObject(CDConstanteSQLGanadoVacuno.SQL_SELECT_BY_ID, rowMapper, cuia )	;	
		return pGanadoVacuno;
	}

	@Override
	public void addGanadoVacunoMacho(GanadoVacunoMacho pGanadoVacunoMacho) {
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_INSERT,
				pGanadoVacunoMacho.getCuiaGana(), 2, calcularEdad(pGanadoVacunoMacho.getFechNaciGana()),
				calcularEtapa(calcularEdad(pGanadoVacunoMacho.getFechNaciGana())),
				pGanadoVacunoMacho.getAliaGana(), pGanadoVacunoMacho.getFechNaciGana(), 
				pGanadoVacunoMacho.getPesoGana(), pGanadoVacunoMacho.getTallGana(), 
				4, 1, 0, 
				pGanadoVacunoMacho.getIdGeno(), 2, pGanadoVacunoMacho.getIdOrig(),
				pGanadoVacunoMacho.getCuiaMadr(), pGanadoVacunoMacho.getCuiaPadr(), pGanadoVacunoMacho.getCodiPropInse(), 
				pGanadoVacunoMacho.getObse(), 1,
				pGanadoVacunoMacho.getImagen());		
		
	}

	@Override
	public void updateGanadoVacunoMacho(GanadoVacunoMacho pGanadoVacunoMacho) {
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_UPDATE,
				2,
				pGanadoVacunoMacho.getIdGeno(),
				calcularEdad(pGanadoVacunoMacho.getFechNaciGana()),
				calcularEtapa(calcularEdad(pGanadoVacunoMacho.getFechNaciGana())),
				pGanadoVacunoMacho.getAliaGana(),
				pGanadoVacunoMacho.getFechNaciGana(),
				pGanadoVacunoMacho.getPesoGana(),
				pGanadoVacunoMacho.getTallGana(),
				4,
				0,
				pGanadoVacunoMacho.getIdGeno(),
				2,
				pGanadoVacunoMacho.getIdOrig(),
				pGanadoVacunoMacho.getCuiaMadr(),
				pGanadoVacunoMacho.getCuiaPadr(),
				pGanadoVacunoMacho.getCodiPropInse(),
				pGanadoVacunoMacho.getObse(),
				pGanadoVacunoMacho.getCuiaGana());
		
	}

	@Override
	public void deleteGanadoVacunoMacho(int cuia) {
		jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_DELETE,cuia);
		
	}
	@Override
	public void updateAllMachos() {
		List<GanadoVacunoMacho> listaMacho = new ArrayList<GanadoVacunoMacho>();
		listaMacho = getGanadoVacunoMacho();
		
		GanadoVacunoMacho oGanadoMacho = new GanadoVacunoMacho();
		
		Iterator<GanadoVacunoMacho> it = listaMacho.iterator();
		while(it.hasNext()) {
			oGanadoMacho = it.next();
			jdbcTemplate.update(CDConstanteSQLGanadoVacuno.SQL_UPDATE_ALL_MACHOS,
					calcularEdad(oGanadoMacho.getFechNaciGana()),
					calcularEtapa(calcularEdad(oGanadoMacho.getFechNaciGana())),				
					oGanadoMacho.getCuiaGana());			
		}
		
	}
	
	protected int calcularEdad(String fechNaci) {
		int edad = (int) ChronoUnit.MONTHS.between(LocalDate.parse(fechNaci), LocalDate.now());
		return edad;
	}
	
	protected String calcularEtapa(int edad) {
		String etapa="";
		if(edad <= 4) {
			etapa = "Ternero";
		}else if(edad > 4 && edad <=12) {
			etapa = "Destete";
		}else if(edad > 12 && edad <=24) {
			etapa = "Becerro";
		}else if(edad >= 24) {
			etapa = "Toro Adulto";
		}		
		return etapa;
	}

	

}
