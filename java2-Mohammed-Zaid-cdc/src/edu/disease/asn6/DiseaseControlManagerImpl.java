package edu.disease.asn6;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import edu.disease.asn3.Disease;
import edu.disease.asn3.Exposures;
import edu.disease.asn3.InfectiousDisease;
import edu.disease.asn3.NonInfectiousDisease;


public class DiseaseControlManagerImpl implements DiseaseControlManager  {
	
	// here we inherited interface form the Disease Control Manager
	// creating 2 arrays for patients , diseases
	// and then index count for array
	private List<Disease> diseases ;
	private List<Patient> patients ;
	private int dCount;
	private int pCount;
	
	// in this we pass exception IllegalArgumentException for getting the array size
	// always array size should be greater then 1
	public DiseaseControlManagerImpl(int maxPatient,int maxDisease) {
		if(maxPatient<1 || maxDisease<1) {
			throw new IllegalArgumentException("Value should be greater than 0");
		}
		else {
			this.diseases =  new ArrayList<>(maxDisease);
			this.patients = new ArrayList<>(maxPatient);
			this.dCount = maxDisease;
			this.pCount = maxPatient;
		}
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public List<Patient> getPatients() {
		return patients;
	}


	// in this we pass exception IllegalStateException for getting the array size
	// index out of bounds
	// array get full to store the object
	@Override
	public Disease addDisease(String name, boolean infectious) {
		Disease disease = infectious? new InfectiousDisease(): new NonInfectiousDisease();
		disease.setDiseaseId(UUID.randomUUID());
		disease.setName(name);
		if(dCount>diseases.size()){
			diseases.add(disease);
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
		
		if(pCount>patients.size()) {
				patients.add(patient);
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
		System.out.println("Patient ... "+patient);
		System.out.println("Disease ... "+disease);
		if(disease ==null || patient == null ) {	
			throw new IllegalArgumentException("ID not found");
		}
		patient.addDiseaseld(disease.getDiseaseId());
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
		} 
		patient.addExposure(exposure);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
