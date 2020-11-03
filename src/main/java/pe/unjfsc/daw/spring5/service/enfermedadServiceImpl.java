package pe.unjfsc.daw.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unjfsc.daw.spring5.dao.enfermedadDaoImpl;
import pe.unjfsc.daw.spring5.model.enfermedad;


@Service
public class enfermedadServiceImpl implements enfermedadService{
	
	@Autowired
	private enfermedadDaoImpl oenfermedadDaoImpl;

	@Override
	public List<enfermedad> getAllenfermedad() {
		return oenfermedadDaoImpl.getAllenfermedad();
	}

	@Override
	public enfermedad findenfermedadById(int id_Enfe) {
		return oenfermedadDaoImpl.findenfermedadById(id_Enfe);
	}


}
