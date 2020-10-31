package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.natalidadDaoImpl;
import pe.unjfsc.daw.spring5.model.natalidad;

@Service
public class natalidadServiceImpl implements natalidadService{
	
	@Autowired
	private natalidadDaoImpl onatalidadDaoImpl;

	@Override
	public List<natalidad> getAllNatalidad() {
		return onatalidadDaoImpl.getAllNatalidad();
	}

	@Override
	public natalidad findnatalidadByCuia(int cuia) {
		return onatalidadDaoImpl.findnatalidadByCuia(cuia);
	}

	@Override
	public void addnatalidad(natalidad pnatalidad) {
		onatalidadDaoImpl.addnatalidad(pnatalidad);
		
	}

	@Override
	public void updatenatalidad(natalidad pnatalidad) {
		onatalidadDaoImpl.updatenatalidad(pnatalidad);
		
	}

	@Override
	public void deletenatalidad(int cuia) {
		onatalidadDaoImpl.deletenatalidad(cuia);
		
	}

}
