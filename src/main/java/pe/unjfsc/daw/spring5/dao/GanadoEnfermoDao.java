package pe.unjfsc.daw.spring5.dao;

import java.util.List;

import pe.unjfsc.daw.spring5.model.GanadoEnfermo;

public interface GanadoEnfermoDao {
		public List<GanadoEnfermo> getAllGanadoEnfermo();
		
		public GanadoEnfermo findGanadoEnfermoByCuia (int cuia);
			
		public void addGanadoEnfermo (GanadoEnfermo pGanadoEnfermo);
		
		public void updateGanadoEnfermo (GanadoEnfermo pGanadoEnfermo);
		
		public void deleteGanadoEnfermo (int cuia);

}
