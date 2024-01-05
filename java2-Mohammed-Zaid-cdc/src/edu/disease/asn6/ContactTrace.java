package edu.disease.asn6;


import edu.disease.asn3.DiseaseControlManagerImpl;
import edu.disease.asn3.Exposures;
import edu.disease.asn3.Patient;
import edu.disease.asn4.PatientZero;

public class ContactTrace {
	
	DiseaseControlManagerImpl diseaseControlManagerImpl;
	
	// constructor
	public ContactTrace(DiseaseControlManagerImpl diseaseControlManagerImpl) {
		this.diseaseControlManagerImpl=diseaseControlManagerImpl;
	}
	
	
	// this method is use to find the patient zero how effect by disease first and exposure to other
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
	
					
				}
			}
			
		return patientZero;
	}

}
