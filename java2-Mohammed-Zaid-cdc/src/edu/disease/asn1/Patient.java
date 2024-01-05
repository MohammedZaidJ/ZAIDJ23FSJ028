package edu.disease.asn1;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Patient {

	private UUID patientId ;
	private String firstName;
	private String lastName;
	// class array
	private Exposures[] exposures;
	// Universally Unique Identifier array to create random number 
	private UUID[] diseaselds;
	/// to count index of an array
	private int diseaseldCount=0;
	private int exposuresCount=0;
	
	// constructor pass 2 arguments for getting arrays size for exposures and diseaselds
	// in this we have the Exception throw to show that always array length greater than 1
	// here we passing illegalArgumentException error
	public Patient(int maxDiseases,int maxExposures) {
		if(maxDiseases<1 || maxExposures<1) {
			throw new IllegalArgumentException("Value should be greater than 0");
		}
		else {
			this.exposures = new Exposures[maxExposures];
			this.diseaselds = new UUID[maxDiseases];
		}
	}
	
	// add element in array and checks index out of bounds Exceptions
	// in this we have an exception for index out of bounds to check whether the array full or not
	public void addDiseaseld(UUID id) {
		if(diseaseldCount<diseaselds.length) {
			diseaselds[diseaseldCount++]=id;
		}
		else {
			throw new IndexOutOfBoundsException("diseaselds array is full");
		}
	}
	// add element in array and checks index out of bounds Exceptions
	// in this we have an exception for index out of bounds to check whether the array full or not
	public void addExposure(Exposures exp) {
		if(exposuresCount<exposures.length) {
			exposures[exposuresCount++]=exp;
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

	public Exposures[] getExposures() {
		return exposures;
	}

	public UUID[] getDiseaselds() {
		return diseaselds;
	}

	

	@Override
	// it returns patientId form the hashCode  class address
	public int hashCode() {
		return Objects.hash(patientId);
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
		Patient other = (Patient) obj;
		return Objects.equals(patientId, other.patientId);
	}

	@Override
	// this method is use to print all the properties of the class
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaselds=" + Arrays.toString(diseaselds) + "]";
	}
	
	
	
}
