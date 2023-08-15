package edu.disease.asn1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import org.junit.Test;
/*
* @author  Mohammed Zaid
* @version 1.0
* @since   2023-08-15
*/
public class PatientTest {

	@Test

	/**
 * in this test case we check
 * we pass equals method to check third condition of the method
 * not from the same class
 * flase scenarios*/
	public void testEquals3() {
		Patient p = new Patient(2,2);
		p.setPatientId(UUID.randomUUID());
		assertEquals(false, p.equals(new String("retw")));
	}

	
	@Test/**
	 * in this test case we check
	 * we pass equals method to check second condition of the method
	 * we have null object
	 * flase scenarios*/
	public void testEquals2() {
		Patient p = new Patient(2,2);
		p.addDiseaseld(UUID.randomUUID());
		p.addExposure(new Exposures(UUID.randomUUID()));
		Patient p1 = null;
		assertEquals(false, p.equals(p1));
	}
	
	@Test/**
	 * in this test case we check
	 * we pass equals method to check first condition of the method
	 * two object are same
	 * true scenarios*/
	public void testEquals1() {
		Patient p = new Patient(2,2);
		p.addDiseaseld(UUID.randomUUID());
		p.addExposure(new Exposures(UUID.randomUUID()));
		Patient p1 = p;
		assertEquals(true, p.equals(p1));
	}
	
	@Test/**
	 * in this test case we check
	 * we pass equals method to check fourth condition of the method
	 * true scenarios*/
	public void testEquals4() {
		
		UUID patientId = UUID.randomUUID();
		
		Patient p = new Patient(2,2);
		p.setPatientId(patientId);
		
		Patient p1 = new Patient(1,2);
		p1.setPatientId(patientId);
		
		assertEquals(true, p.equals(p1));
	}
	
	@Test
	/**
	 * in this test case we check
	 * we pass equals method to check fourth condition of the method
	 * flase scenarios*/
	public void testEquals41() {
		UUID patientId = UUID.randomUUID();
		
		Patient p = new Patient(2,2);
		p.setPatientId(patientId);
		
		Patient p1 = new Patient(1,2);
		p1.setPatientId( UUID.randomUUID());
		
		assertEquals(false, p.equals(p1));
	}
	
	@Test/**
	 * we check hash code are equal or not for the same object*/
	public void testHashcode() {
		UUID patientId = UUID.randomUUID();
		Patient p = new Patient(2,2);
		p.setPatientId(patientId);
		assertEquals(p.hashCode(), Objects.hash(patientId));
	}
	
	@Test
	/// checking whether the string prints correct output or not
	public void testToString() {
		UUID patientId = UUID.randomUUID();
		Patient p = new Patient(1,1);
		p.setPatientId(UUID.randomUUID());
		p.setFirstName("Mohammed");
		p.setLastName("Abbas");
		p.addDiseaseld(patientId);
		p.addExposure(new Exposures(patientId));
		String message = "Patient [patientId=" + p.getPatientId() + ", firstName=" + p.getFirstName() + ", lastName=" + p.getLastName()
		+ ", exposures=" + Arrays.toString(p.getExposures()) + ", diseaselds=" + Arrays.toString(p.getDiseaselds()) + "]";
		assertEquals(message, p.toString());
	}
	
	@Test
	//here we pass the argument for array size
	// always greater then 1
	// else it's throws the exception IllegalArgumentException
	// Value should be greater than 1
	public void testGettingSize() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Patient p = new Patient(1,0);
			p.setPatientId(UUID.randomUUID());
	    });
		String message ="Value should be greater than 0";
		assertEquals(message,exception.getMessage());
		
		
	}
	
	@Test
	// her Exception throws for index out of bounds
	// greater then array size
	public void testAddDiasease() {
		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			Patient p = new Patient(1,1);
			p.addDiseaseld(UUID.randomUUID());
			p.addDiseaseld(UUID.randomUUID());
	    });
		String message ="diseaselds array is full";
		assertEquals(message,exception.getMessage());
		
		
	}
	
	@Test
	// her Exception throws for index out of bounds
	// greater then array size
	public void testAddPatient() {
		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			Patient p = new Patient(1,1);
			p.addExposure(new Exposures(UUID.randomUUID()));
			p.addExposure(new Exposures(UUID.randomUUID()));
	    });
		String message ="exposures array is full";
		assertEquals(message,exception.getMessage());
		
		
	}
}
