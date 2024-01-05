package edu.disease.asn2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.UUID;

import org.junit.Test;

import edu.disease.asn1.Exposures;

public class DiseaseControlManagerTest {

	@Test
	//in this throws exception IllegalArgumentException
	public void testArraySize01() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			DiseaseControlManager dcm= new DiseaseControlManagerImpl(1, 0);
	    });
		String message ="Value should be greater than 0";
		assertEquals(message,exception.getMessage());
	}
	
	@Test
	//in this throws exception IllegalArgumentException
	public void testArraySize02() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			DiseaseControlManager dcm= new DiseaseControlManagerImpl(0, 1);
	    });
		String message ="Value should be greater than 0";
		assertEquals(message,exception.getMessage());
	}
	@Test
	// add Disease To Patient 
	public void testAddDiseaseToPatient() {
		DiseaseControlManager dcm= new DiseaseControlManagerImpl(1, 1);
		Patient p = dcm.addPatient("Cooper", "Marry", 1, 1);
		
		Disease d = dcm.addDisease("stroke", false);
		dcm.addDiseaseToPatient(p.getPatientId(), d.getDiseaseId());
			
	}
	
	@Test
	//  add Exposure To Patient
	public void testExposureToPatient() {
		DiseaseControlManager dcm= new DiseaseControlManagerImpl(1, 1);
		Patient p = dcm.addPatient("Cooper", "Marry", 1, 1);
		Exposures exp = new Exposures(p.getPatientId());
		dcm.addExposureToPatient(p.getPatientId(), exp);
//			
	}
	@Test
	// throws exception for over size
	// disease array is full
	public void testExceptionSize() {
		Exception exception = assertThrows(IllegalStateException.class, () -> {
			DiseaseControlManager dcm= new DiseaseControlManagerImpl(1, 1);
			dcm.addDisease("Hiv", true);
			dcm.addDisease("Heart Disease", false);
			
	    });
		String message ="disease array is full";
		assertEquals(message,exception.getMessage());
	}
	@Test
	// throws exception for over size
	// patient array is full
	public void test4() {
		Exception exception = assertThrows(IllegalStateException.class, () -> {
			DiseaseControlManager dcm= new DiseaseControlManagerImpl(1, 1);
			dcm.addPatient("cooper", "George", 1, 1);
			dcm.addPatient("cooper", "marry", 1, 1);
			
			
	    });
		String message ="patient array is full";
		assertEquals(message,exception.getMessage());
	}
	
	@Test
	// throws exception for value not found
	//Patient ID not found
	public void test5() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			DiseaseControlManager dcm= new DiseaseControlManagerImpl(1, 1);
			Patient p = dcm.addPatient("Cooper", "Marry", 1, 1);
			Exposures exp = new Exposures(p.getPatientId());
			dcm.addExposureToPatient(UUID.randomUUID(), exp);
			
	    });
		String message ="Patient ID not found";
		assertEquals(message,exception.getMessage());
	}
	
	@Test

	// throws exception for value not found
	// ID not found
	public void test6() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			DiseaseControlManager dcm= new DiseaseControlManagerImpl(1, 1);
			Patient p = dcm.addPatient("Cooper", "Marry", 1, 1);
			
			Disease d = dcm.addDisease("stroke", false);
			dcm.addDiseaseToPatient(p.getPatientId(), UUID.randomUUID());
			
	    });
		String message ="ID not found";
		assertEquals(message,exception.getMessage());
	}
	

}
