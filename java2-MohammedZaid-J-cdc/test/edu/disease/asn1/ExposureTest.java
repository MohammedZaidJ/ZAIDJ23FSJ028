package edu.disease.asn1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.junit.Test;
/*
* @author  Mohammed Zaid
* @version 1.0
* @since   2023-08-15
*/
public class ExposureTest {

	@Test
	/**
	 * in this test case we check
	 * we pass equals method to check fourth condition of the method
	 * flase scenarios*/
	public void testEquals4() {
		Exposures exp = new Exposures(UUID.randomUUID());
		exp.setExposureType("D");
		exp.setDateTime(LocalDateTime.of(2000, 8, 22, 20, 00));
		
		Exposures exp1 = new Exposures(exp.getPatientId());
		exp1.setExposureType("I");
		exp1.setDateTime(LocalDateTime.of(2000, 8, 22, 22, 00));
		boolean result = exp.equals(exp1);
		assertEquals(false, result);
		
		
	}
	@Test/**
	 * in this test case we check
	 * we pass equals method to check fourth condition of the method
	 * true scenarios*/
	public void testEquals() {
		Exposures exp = new Exposures(UUID.randomUUID());
		exp.setExposureType("D");
		exp.setDateTime(LocalDateTime.of(2000, 8, 22, 20, 00));
		
		Exposures exp1 = new Exposures(exp.getPatientId());
		exp1.setExposureType("D");
		exp1.setDateTime(LocalDateTime.of(2000, 8, 22, 20, 00));
		boolean result = exp.equals(exp1);
		assertEquals(true, result);
		
		
		
		
	}
	@Test/**
	 * in this test case we check
	 * we pass equals method to check first condition of the method
	 * two object are same
	 * true scenarios*/
	public void testTwoSameObjects() {
		Exposures exp = new Exposures(UUID.randomUUID());
		exp.setExposureType("D");
		exp.setDateTime(LocalDateTime.of(2000, 8, 22, 20, 00));
		
		Exposures exp1 = exp;
		assertEquals(true,exp.equals(exp1));
		
		
	}
	@Test/**
	 * in this test case we check
	 * we pass equals method to check second condition of the method
	 * we have null object
	 * flase scenarios*/
	public void testEqual2() {
		Exposures exp = new Exposures(UUID.randomUUID());
		exp.setExposureType("D");
		Exposures exp1 = null;
		assertEquals(false,exp.equals(exp1));
		
		
	}
	
	@Test
		/**
	 * in this test case we check
	 * we pass equals method to check third condition of the method
	 * not from the same class
	 * flase scenarios*/
	public void testEquals3() {
		Exposures exp = new Exposures(UUID.randomUUID());
		exp.setExposureType("D");
		assertEquals(false,exp.equals("Hello"));
		
		
	}
	@Test
	/**
	 * we check hash code are equal or not for the same object*/
	public void testHashCode() {
		Exposures exp = new Exposures(UUID.randomUUID());
		exp.setDateTime(LocalDateTime.of(2000, 8, 22, 20, 00));
		
		assertEquals(exp.hashCode(), Objects.hash(exp.getDateTime(), exp.getPatientId()));
		
	}
	@Test
	//here we pass there argument in the method 'D' or 'I'
	// true condition
	public void testExposureType() {
		Exposures exp = new Exposures(UUID.randomUUID());
		exp.setExposureType("D");
		assertEquals("D",exp.getExposureType());
		
		
	}
	@Test
	//here we pass there argument in the method 'D' or 'I'
	// passing different argument in method 
	// it throws exception
	// false condition
	public void testExposureType1() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Exposures exp = new Exposures(UUID.randomUUID());
			exp.setExposureType("A");
	    });
		String message ="Value should be ethier D or I ";
		assertEquals(message,exception.getMessage());
		
		
	}
	/// checking whether the string prints correct output or not
	@Test
	public void testToString() {
		UUID patientId = UUID.randomUUID();
		String exposureType = "D";
		LocalDateTime date = LocalDateTime.of(2000, 8, 22, 20, 00);
		Exposures exp = new Exposures(patientId);
		
		exp.setExposureType(exposureType);
		exp.setDateTime(date);
		String message ="Exposures [patientId=" + patientId + ", dateTime=" + date + ", exposureType=" + exposureType + "]\n";
		assertEquals(message,exp.toString());
		
		
	}
	
}

