package edu.disease.asn2;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import edu.disease.asn1.Exposures;
/*
* @author  Mohammed Zaid
* @version 1.0
* @since   2023-08-15
*/
public class Patient implements Comparable<Patient>{
	

	// copy from the edu.disease.asn1
	// in this creating comparable 
	// we add extra method 
	// to compare the object of lastname 
	
	private UUID patientId ;
	private String firstName;
	private String lastName;
	private Exposures[] exposures;
	private UUID[] diseaselds;
	private int diseaseldCount=0;
	private int exposuresCount=0;
	
	// constructor pass 2 arguments for getting arrays size for exposures and diseaselds
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
	public void addDiseaseld(UUID id) {
		if(diseaseldCount<diseaselds.length) {
			diseaselds[diseaseldCount++]=id;
		}
		else {
			throw new IndexOutOfBoundsException("diseaselds array is full");
		}
	}
	// add element in array and checks index out of bounds Exceptions
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
	// this method is use to print 
	// return string 
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", exposures=" + Arrays.toString(exposures) + ", diseaselds=" + Arrays.toString(diseaselds) + "]";
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
	
	
	
}
