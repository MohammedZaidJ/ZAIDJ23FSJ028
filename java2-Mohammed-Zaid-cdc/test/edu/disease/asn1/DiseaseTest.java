package edu.disease.asn1;

import static org.junit.Assert.*;

import java.util.Objects;
import java.util.UUID;

import org.junit.Test;

public class DiseaseTest {

	@Test/**
	 * in this test case we check
	 * we pass equals method to check third condition of the method
	 * not from the same class
	 * flase scenarios*/
	public void testEquals301() {
		Disease disease = new Disease();
		disease.setDiseaseId(UUID.randomUUID());
		assertEquals(false,disease.equals(new String("hello")));
		
	}
	@Test
	public void testEquals302() {
		Disease disease = new Disease();
		disease.setDiseaseId(UUID.randomUUID());
		assertEquals(true,disease.equals(disease));
		
	}
	@Test
	public void testEquals303() {
		Disease disease = new Disease();
		disease.setDiseaseId(UUID.randomUUID());
		assertEquals(false,disease.equals(null));
		
	}
	@Test/**
	 * in this test case we check
	 * we pass equals method to check fourth condition of the method
	 * true scenarios*/
	public void testEquals4() {
		Disease disease = new Disease();
		disease.setDiseaseId(UUID.randomUUID());

		Disease disease1 = new Disease();
		disease1.setDiseaseId(UUID.randomUUID());
		assertEquals(false,disease.equals(disease1));
		
	}
	@Test/**
	 * we check hash code are equal or not for the same object passing same address*/
	public void testHashCode() {
		Disease disease = new Disease();
		disease.setDiseaseId(UUID.randomUUID());

		int result = Objects.hash(disease.getDiseaseId());
		assertEquals(result,disease.hashCode());
		
	}
	@Test
	//checking whether the string prints correct output or not
	public void testTOString() {
		Disease disease = new Disease();
		disease.setDiseaseId(UUID.randomUUID());
		disease.setName("Stroke");

		String message = "Disease [diseaseId=" + disease.getDiseaseId() + ", name=" + disease.getName() + "]";
		assertEquals(message,disease.toString());
		
	}

	
}
