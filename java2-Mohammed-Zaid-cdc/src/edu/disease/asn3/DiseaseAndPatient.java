package edu.disease.asn3;

import java.io.Serializable;

public class DiseaseAndPatient{
	// creating 2 arrays for patients , diseases
	// and then index count for array
	private Disease[] diseases;
	private Patient[] patients;
	
	// getter and setter for all properties
	public Disease[] getDiseases() {
		return diseases;
	}
	public void setDiseases(Disease[] diseases) {
		this.diseases = diseases;
	}
	public Patient[] getPatients() {
		return patients;
	}
	public void setPatients(Patient[] patients) {
		this.patients = patients;
	}
	
	
	
}
