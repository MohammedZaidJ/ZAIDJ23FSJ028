package edu.disease.asn4;

import java.time.LocalDateTime;

import edu.disease.asn3.Patient;

public class PatientZero {
	
	private Patient patient;
	private LocalDateTime localDateTime;
	private boolean exposed;
	
	
	
	// getter and setter for all properties
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public boolean isExposed() {
		return exposed;
	}
	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}
	
	
	

}
