package edu.disease.asn6;

import java.util.ArrayList;
import java.util.List;

import edu.disease.asn3.Disease;

public class DiseaseAndPatient{
	// creating 2 arrays for patients , diseases
	// and then index count for array
	private List<Disease> diseases = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();
	
	
	
	public List<Disease> getDiseases() {
		return diseases;
	}
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
	
}
