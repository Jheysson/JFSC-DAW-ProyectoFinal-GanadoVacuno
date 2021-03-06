package pe.unjfsc.daw.spring5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.impl.GanadoVacunoDaoImpl;
import pe.unjfsc.daw.spring5.model.GanadoVacuno;
import pe.unjfsc.daw.spring5.service.GanadoVacunoService;

@Service
public class GanadoVacunoServiceImpl implements GanadoVacunoService{

	@Autowired
	private GanadoVacunoDaoImpl oGanadoVacunoDaoImpl;
	
	@Override
	public List<GanadoVacuno> getAllGanadoVacuno() {
		return oGanadoVacunoDaoImpl.getAllGanadoVacuno();
	}

	@Override
	public List<GanadoVacuno> getGanadoVacunoHembra() {
		return oGanadoVacunoDaoImpl.getGanadoVacunoHembra();
	}

	@Override
	public List<GanadoVacuno> getGanadoVacunoMacho() {
		return oGanadoVacunoDaoImpl.getGanadoVacunoMacho();
	}

	@Override
	public GanadoVacuno findGanadoVacunoByCuia(int cuia) {
		return oGanadoVacunoDaoImpl.findGanadoVacunoByCuia(cuia);
	}
	@Override
	public GanadoVacuno findHembrasAptas(int cuia) {
		return oGanadoVacunoDaoImpl.findHembrasAptas(cuia);
	}

	@Override
	public void addGanadoVacuno(GanadoVacuno pGanadoVacuno) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addGanadoVacunoHembra(GanadoVacuno pGanadoVacuno) {
		oGanadoVacunoDaoImpl.addGanadoVacunoHembra(pGanadoVacuno);
		
	}

	@Override
	public void addGanadoVacunoMacho(GanadoVacuno pGanadoVacuno) {
		oGanadoVacunoDaoImpl.addGanadoVacunoMacho(pGanadoVacuno);
		
	}

	@Override
	public void updateGanadoVacuno(GanadoVacuno pGanadoVacuno) {
		oGanadoVacunoDaoImpl.updateGanadoVacuno(pGanadoVacuno);
		
	}

	@Override
	public void deleteGanadoVacuno(int cuia) {
		oGanadoVacunoDaoImpl.deleteGanadoVacuno(cuia);
		
	}

	

	

}
