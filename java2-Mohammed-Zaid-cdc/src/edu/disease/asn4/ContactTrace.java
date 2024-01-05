package edu.disease.asn4;


import edu.disease.asn3.DiseaseControlManagerImpl;
import edu.disease.asn3.Exposures;
import edu.disease.asn3.Patient;

public class ContactTrace {
	
	DiseaseControlManagerImpl diseaseControlManagerImpl;
	public ContactTrace(DiseaseControlManagerImpl diseaseControlManagerImpl) {
		this.diseaseControlManagerImpl=diseaseControlManagerImpl;
	}
	
	public PatientZero FindPatientZero(Patient patient) {
		PatientZero patientZero  = null;
		Exposures earliestExposure = null;
			if(patient==null || patient.getExposures()==null) {
				return null;
			}
			for(Exposures exp: patient.getExposures()) {
				
				
				if(exp.getExposureType()=="D") {
					Patient exposedPatient = diseaseControlManagerImpl.getPatient(exp.getPatientId());
					
					patientZero = new PatientZero();
					patientZero.setLocalDateTime(exp.getDateTime());
					patientZero.setExposed(true);
					patientZero.setPatient(exposedPatient);
					
					PatientZero FoundExposedPatient = FindPatientZero(exposedPatient);
					
					if(FoundExposedPatient != null && FoundExposedPatient.getLocalDateTime().isBefore(patientZero.getLocalDateTime())) {
						patientZero = new PatientZero();
						patientZero.setLocalDateTime(FoundExposedPatient.getLocalDateTime());
						patientZero.setExposed(true);
						patientZero.setPatient(FoundExposedPatient.getPatient());
					}
					
					
					System.out.println("yes");
//					System.out.println(patient.getFirstName() + "  expo pat... " + exposedPatient.getFirstName());
						
					
				}
			}
			
		return patientZero;
	}

}
