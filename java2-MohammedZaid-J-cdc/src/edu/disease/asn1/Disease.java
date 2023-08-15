package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;
/*
* @author  Mohammed Zaid
* @version 1.0
* @since   2023-08-15
*/
public class Disease {
	/**
	 * here we have disease class 
	 * its have two properties
	 * disease id
	 * name of the disease*/
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
	@Override
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
		Disease other = (Disease) obj;
		return Objects.equals(diseaseId, other.diseaseId);
	}
	@Override
	// this method is use to print 
	public String toString() {
		return "Disease [diseaseId=" + diseaseId + ", name=" + name + "]";
	}
	
	
	
}
