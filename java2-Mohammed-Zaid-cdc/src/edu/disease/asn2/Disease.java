package edu.disease.asn2;

import java.util.Objects;
import java.util.UUID;


public abstract class Disease {
	// copy from the edu.disease.asn1
	// in this creating abstract class
    // in this creating an empty abstract method called getExamples 
	
	private UUID diseaseId;
	private String name;
	
	
	// getter and setter for all properties
	public UUID getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(UUID diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	// it returns patientId form the hashCode address
	public int hashCode() {
		return Objects.hash(diseaseId);
	}
	@Override/**In this method checking whether the object is equal or not
	 * first condition -  checking whether object are same 
	 * second condition  - arug object not null
	 * third condition  -    checking whether object are form the same class
	 * fourth condition -  patientId, dateTme are same for the both object or not
	 * return boolean
	 * */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disease other = (Disease) obj;
		return Objects.equals(diseaseId, other.diseaseId);
	}
	@Override
	// this method is use to print 
	// return string
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
	}
	
	// return string array
	public abstract String[] getExamples();
}













