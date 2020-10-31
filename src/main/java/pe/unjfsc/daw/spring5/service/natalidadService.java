package pe.unjfsc.daw.spring5.service;

import java.util.List;

import pe.unjfsc.daw.spring5.model.natalidad;

public interface natalidadService {
	public List<natalidad> getAllNatalidad();
	 
	 public natalidad findnatalidadByCuia(int cuia);
	 
	 public void addnatalidad(natalidad pnatalidad);
	 
	 public void updatenatalidad(natalidad pnatalidad);
	 
	 public void deletenatalidad(int cuia);
}
