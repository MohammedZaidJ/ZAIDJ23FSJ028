package edu.disease.asn6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import edu.disease.asn3.Disease;

public class DiseaseFileRepository {
	
	
	//it saves the arrayList of patients and diseases
	public void save(List<Patient> patients,List<Disease> diseases) throws Exception {
		
		FileOutputStream fosP = new FileOutputStream("patients.dat");
		ObjectOutputStream oosP= new ObjectOutputStream(fosP);
		oosP.writeObject(patients);
		fosP.close();
		oosP.close();
		
		FileOutputStream fosD = new FileOutputStream("diseases.dat");
		ObjectOutputStream oosD= new ObjectOutputStream(fosD); 
		oosD.writeObject(diseases);
		fosD.close();
		oosD.close();
		
	}

	// it use deSerialized method to take the file 
	// patients and diseases
	public DiseaseAndPatient init(String floderPath) throws Exception {
		if(floderPath==null) {
			throw new IllegalArgumentException("file not found");
		}
		// openFile Patients
		FileInputStream fosP = new FileInputStream(floderPath+"patients.dat");
		ObjectInputStream oisP = new ObjectInputStream(fosP);
		// openFile Diseases
		FileInputStream fosD = new FileInputStream(floderPath+"diseases.dat");
		ObjectInputStream oisD = new ObjectInputStream(fosD);
		
		DiseaseAndPatient dp = new DiseaseAndPatient();
		dp.setDiseases((List<Disease>)oisD.readObject());
		dp.setPatients((List<Patient>)oisP.readObject());
		oisD.close();
		oisP.close();
		return dp;
	
	}
}



















