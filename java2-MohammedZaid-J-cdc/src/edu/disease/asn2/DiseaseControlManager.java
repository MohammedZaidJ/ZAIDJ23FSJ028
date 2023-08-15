package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposures;
/*
* @author  Mohammed Zaid
* @version 1.0
* @since   2023-08-15
*/
public interface DiseaseControlManager {
	// here we create an interface for Disease Control Manager
	// pass some methods
	
	//add disease to array
	// return Disease obj
	// pass 2 arguments
	// name of the disease
	// boolean 
	public Disease addDisease(String name,boolean infectious);

	//get disease from array
	// return Disease obj
	// pass 1 arguments
	// checking array having an disease id 
	public Disease getDisease(UUID diseaseld);
	
	//add patient to array
	// return Patient obj
	// pass 4 arguments
	// name of the first and last
	// maximum no. of disease array size
	// maximum no. of Exposure class array size
	public Patient addPatient(String firstName,String lastName,int maxDisease,int maxExposure);
	
	// get patient from array
	// return Patient obj 
	// pass 1 arguments
	// checking array having an patient id 
	public Patient getPatient(UUID patientId);
	
	// adding the disease to patient id
	// return null
	// passing 2 argument
	public void addDiseaseToPatient(UUID patientId,UUID diseaseld);
	

	// adding the Exposure to patient id
	// return null
	// passing 2 argument
	public void addExposureToPatient(UUID patientId,Exposures exposure);
	
	
	
}
