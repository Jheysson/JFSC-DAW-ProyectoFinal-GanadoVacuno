package pe.unjfsc.daw.spring5.dao;
import java.util.List;

import pe.unjfsc.daw.spring5.model.enfermedad;

public interface enfermedadDao {
	public List<enfermedad> getAllenfermedad();
	 
	 public enfermedad findenfermedadById(int id_Enfe);
	 
}
