package edu.disease.asn2;

import static org.junit.Assert.*;

import java.util.Objects;
import java.util.UUID;

import org.junit.Test;

public class DiseaseTest {

	@Test
	//here we pass some string in sub class called Infectious Disease
	// checking method having same string or not 
	public void testGettingMethodString() {
		Disease disease = new InfectiousDisease();
		assertArrayEquals(disease.getExamples(), new String[] {"Chickenpox", "Common cold", "Diphtheria", "HIV/AIDS"});
		
	}

	@Test
	//here we pass some string in sub class called Non Infectious Disease
	// checking method having same string or not 
	public void testGettingMethodString1() {
		Disease disease = new NonInfectiousDisease();
		assertArrayEquals(disease.getExamples(), new String[] {"heart disease", "stroke", "cancer", "diabetes "});
		
	}
	@Test/**
	 * in this test case we check
	 * we pass equals method to check third condition of the method
	 * not from the same class
	 * flase scenarios*/
	public void testEquals3() {
		Disease disease = new NonInfectiousDisease();
		disease.setDiseaseId(UUID.randomUUID());
		assertEquals(false,disease.equals(new String("hello")));
		
	}
	@Test/**
	 * in this test case we check
	 * we pass equals method to check fourth condition of the method
	 * true scenarios*/
	public void testEquals4() {
		Disease disease = new NonInfectiousDisease();
		disease.setDiseaseId(UUID.randomUUID());

		Disease disease1 = new NonInfectiousDisease();
		disease1.setDiseaseId(UUID.randomUUID());
		assertEquals(false,disease.equals(disease1));
		
	}
	@Test/**
	 * in this test case we check
	 * we pass equals method to check second condition of the method
	 * we have null object
	 * flase scenarios*/
	public void testEquals2() {
		Disease disease = new NonInfectiousDisease();
		disease.setDiseaseId(UUID.randomUUID());

		Disease disease1 = null;
		assertEquals(false,disease.equals(disease1));
		
	}

	@Test/**
	 * in this test case we check
	 * we pass equals method to check first condition of the method
	 * two object are same
	 * true scenarios*/
	public void testEquals1() {
		Disease disease = new NonInfectiousDisease();
		disease.setDiseaseId(UUID.randomUUID());

		Disease disease1 = disease;
		assertEquals(true,disease.equals(disease1));
		
	}
	
	@Test/**
	 * we check hash code are equal or not for the same object passing same address*/
	public void testHashCode() {
		Disease disease = new NonInfectiousDisease();
		disease.setDiseaseId(UUID.randomUUID());

		int result = Objects.hash(disease.getDiseaseId());
		assertEquals(result,disease.hashCode());
		
	}
	@Test
	//checking whether the string prints correct output or not
	public void testTOString() {
		Disease disease = new NonInfectiousDisease();
		disease.setDiseaseId(UUID.randomUUID());
		disease.setName("Stroke");

		String message = "Disease [diseaseId=" + disease.getDiseaseId() + ", name=" + disease.getName() + "]";
		assertEquals(message,disease.toString());
		
	}

	
}
