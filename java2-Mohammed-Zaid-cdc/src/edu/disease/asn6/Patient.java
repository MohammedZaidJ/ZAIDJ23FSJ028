package edu.disease.asn6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import edu.disease.asn3.Exposures;

public class Patient implements Comparable<Patient>,Serializable{
	

	// copy from the edu.disease.asn1
	// in this creating comparable 
	// we add extra method 
	// to compare the object of lastName 
	
	private UUID patientId ;
	private String firstName;
	private String lastName;
	private List<Exposures> exposures = new ArrayList<>();
	private List<UUID> diseaselds = new ArrayList<>();
	private int diseaseldCount;
	private int exposuresCount;
	
	// constructor pass 2 arguments for getting arrays size for exposures and diseaseIds
	public Patient(int maxDiseases,int maxExposures) {
		if(maxDiseases<1 || maxExposures<1) {
			throw new IllegalArgumentException("Value should be greater than 0");
		}
		else {
			this.exposures = new ArrayList<>(maxExposures);
			this.diseaselds = new ArrayList<>(maxDiseases);
			this.diseaseldCount = maxDiseases;
			this.exposuresCount = maxExposures;
		}
	}
	
	// add element in array and checks index out of bounds Exceptions
	public void addDiseaseld(UUID id) {
		if(diseaseldCount>diseaselds.size()) {
			diseaselds.add(id);
		}
		else {
			throw new IndexOutOfBoundsException("diseaselds array is full");
		}
	}
	// add element in array and checks index out of bounds Exceptions
	public void addExposure(Exposures exp) {
		if(exposuresCount>exposures.size()) {
			exposures.add(exp);
		}
		else {
			throw new IndexOutOfBoundsException("exposures array is full");
		}
	}
	
	// getter and setter for all properties
	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public List<Exposures> getExposures() {
		return exposures;
	}

	public List<UUID> getDiseaselds() {
		return diseaselds;
	}

	

	@Override
	// it returns patientId form the hashCode address
	public int hashCode() {
		return Objects.hash(patientId);
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
		Patient other = (Patient) obj;
		return Objects.equals(patientId, other.patientId);
	}


	@Override
	// compare the other object of there lastName and then 
	// rearrange as ascending order
	// if lastName are equal for the two object
	// we compare the firstName of string
	public int compareTo(Patient o) {
		if(this.lastName.compareTo(o.getLastName())==0) {
			return this.getFirstName().compareTo(o.getFirstName());
		}
		return this.lastName.compareTo(o.getLastName());
	}

	@Override
	// this method is use to print 
	// return string 
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + exposures + ", diseaselds=" + diseaselds + ", diseaseldCount=" + diseaseldCount
				+ ", exposuresCount=" + exposuresCount + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
