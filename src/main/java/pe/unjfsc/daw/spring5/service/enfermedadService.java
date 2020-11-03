package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.enfermedad;

public interface enfermedadService {
	public List<enfermedad> getAllenfermedad();
	 
	 public enfermedad findenfermedadById(int id_Enfe);
}
