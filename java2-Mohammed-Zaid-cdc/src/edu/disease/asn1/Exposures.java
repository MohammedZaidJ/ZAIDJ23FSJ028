package edu.disease.asn1;
import java.util.Objects;
import java.util.UUID;
import java.time.LocalDateTime;  

public class Exposures {	
	/**
	 * <h1> Center for Disease Control</h1>
	 * In this we creating a class name Exposure
	 * UUID - Universally Unique Identifier
	 * 
	 * */
	private UUID patientId;
	private LocalDateTime dateTime;
	private String exposureType;
	
	
	// constructor
	public Exposures(UUID patientId) {
		this.setPatientId(patientId);
	}
	
	// getter and setter for all properties
	public UUID getPatientId() {
		return patientId;
	}
	public void setPatientId(UUID patientId) {
		this.patientId=patientId;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime=dateTime;
	}
	public String getExposureType() {
		return exposureType;
	}
	public void setExposureType(String exposureType) {
		if(exposureType=="D" || exposureType=="I") {
			this.exposureType=exposureType;
		}
		else {
			throw new IllegalArgumentException("Value should be ethier D or I ");
		}
	}
	// returning class Identity or Address of hashCode 
	public int hashCode() {
		return Objects.hash(dateTime, patientId);
	}
	/**In this method checking whether the object is equal or not
	 * first condition -  checking whether object are same 
	 * second condition  - arug object not null
	 * third condition  -    checking whether object are form the same class
	 * fourth condition -  patientId, dateTme are same for the both object or not
	 * */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposures other = (Exposures) obj;
		return Objects.equals(this.getDateTime(), other.getDateTime()) && Objects.equals(this.getPatientId(), other.getPatientId());
	} 
	//this is use to print the class properties
	public String toString() {
		return "Exposures [patientId=" + patientId + ", dateTime=" + dateTime + ", exposureType=" + exposureType + "]\n";
	}
	
	
}
