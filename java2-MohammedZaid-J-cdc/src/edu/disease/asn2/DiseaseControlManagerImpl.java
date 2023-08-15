package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposures;
/*
* @author  Mohammed Zaid
* @version 1.0
* @since   2023-08-15
*/
public class DiseaseControlManagerImpl implements DiseaseControlManager  {
	
	// here we inherited interface form the Disease Control Manager
	// creating 2 arrays for patients , diseases
	// and then index count for array
	private Disease[] diseases;
	private Patient[] patients;
	private int dCount =0;
	private int pCount =0;
	
	// in this we pass exception IllegalArgumentException for getting the array size
	// always array size should be greater then 1
	public DiseaseControlManagerImpl(int maxPatient,int maxDisease) {
		if(maxPatient<1 || maxDisease<1) {
			throw new IllegalArgumentException("Value should be greater than 0");
		}
		else {
			this.diseases = new Disease[maxDisease];
			this.patients = new Patient[maxPatient];
		}
	}

	// in this we pass exception IllegalStateException for getting the array size
	// index out of bounds
	// array get full to store the object
	@Override
	public Disease addDisease(String name, boolean infectious) {
		Disease disease = infectious? new InfectiousDisease(): new NonInfectiousDisease();
		disease.setDiseaseId(UUID.randomUUID());
		disease.setName(name);
		if(dCount<diseases.length) {
			diseases[dCount++]=disease;
		}
		else {
			throw new IllegalStateException("disease array is full");
		}
		return disease;
	}

	// in this we getting object of an Disease
	// else it return null
	@Override
	public Disease getDisease(UUID diseaseld) {
		for(Disease d : diseases) {
			if (d.getDiseaseId().equals(diseaseld)) {
				return d;
			}
		}
		return null;
	}


	// in this we pass exception IllegalStateException for getting the array size
	// index out of bounds
	// array get full to store the object
	@Override
	public Patient addPatient(String firstName, String lastName, int maxDisease, int maxExposure) {
		Patient patient = new Patient(maxDisease, maxExposure);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setPatientId(UUID.randomUUID());
		if(pCount<patients.length) {
			patients[pCount++]=patient;
		}
		else {
			throw new IllegalStateException("patient array is full");
		}
		return patient;
	}

	// in this we getting object of an patient
	// else it return null
	@Override
	public Patient getPatient(UUID patientId) {
		for(Patient p : patients) {
			if (p.getPatientId().equals(patientId)) {
				return p;
			}
		}
		return null;
	}

	// in this we adding the disease to patient id object
	// it throws exception for IllegalArgumentException
	// id not found in the arrays
	// it check the both arrays
	// else it add disease to patient 
	@Override
	public void addDiseaseToPatient(UUID patientId, UUID diseaseld) {
		Disease disease = getDisease(diseaseld);
		Patient patient = getPatient(patientId);
		
		if(disease ==null || patient == null ) {
			throw new IllegalArgumentException("ID not found");
		} else {
			patient.addDiseaseld(disease.getDiseaseId());
		}
	}


	// in this we adding the exposure to patient id object
	// it throws exception for IllegalArgumentException
	// id not found in the arrays
	// it check the both arrays
	// else it add exposure to patient 
	@Override
	public void addExposureToPatient(UUID patientId, Exposures exposure) {
		Patient patient = getPatient(patientId);
		
		if(patient == null ) {
			throw new IllegalArgumentException("Patient ID not found");
		} else {
			patient.addExposure(exposure);
		}
	}

}
