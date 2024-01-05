package edu.disease.asn2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.junit.Test;

import edu.disease.asn1.Exposures;

public class PatientTest {



	@Test
	// here we sore the class array
	// calling compare method the created inside the class
	// we collection sort the array
	
	public void testSort() {

		List<Patient> patients = new ArrayList<>();
		Patient p = new Patient(1,1);
		p.setPatientId(UUID.randomUUID());
		p.setFirstName("Mohammed");
		p.setLastName("Abbas");
		patients.add(p);
		Patient p1 = new Patient(1,1);
		p1.setPatientId(UUID.randomUUID());
		p1.setFirstName("Mohammed");
		p1.setLastName("Zaid");
		patients.add(p1);
		Patient p2 = new Patient(1,1);
		p2.setPatientId(UUID.randomUUID());
		p2.setFirstName("Mohammed");
		p2.setLastName("Imaz");
		patients.add(p2);
		
		Patient p3 = new Patient(1,1);
		p3.setPatientId(UUID.randomUUID());
		p3.setLastName("Cooper");
		p3.setFirstName("Sheldon");
		patients.add(p3);
		Patient p4 = new Patient(1,1);
		p4.setPatientId(UUID.randomUUID());
		p4.setLastName("Cooper");
		p4.setFirstName("Marry");
		patients.add(p4);
		
		Collections.sort(patients);
		
		List<Patient> exppatients = new ArrayList<>();
		exppatients.add(p);
		exppatients.add(p4);
		exppatients.add(p3);
		exppatients.add(p2);
		exppatients.add(p1);
		
		assertEquals(true, check(patients,exppatients));
	}
	
	// checking the value of both array
	public boolean check(List<Patient> p, List<Patient> p1) {
		boolean set = true;
		for(int i=0;i<p.size();i++) {
			if(!p.get(i).getPatientId().equals(p1.get(i).getPatientId())) {
				set =false;
				
			}
		}
		return set;
	}

	@Test
	public void test() {
		Patient p = new Patient(2,2);
		p.setPatientId(UUID.randomUUID());
		assertEquals(false, p.equals(new String("retw")));
	}

	@Test
	public void test1() {
		Patient p = new Patient(2,2);
		p.addDiseaseld(UUID.randomUUID());
		p.addExposure(new Exposures(UUID.randomUUID()));
		Patient p1 = null;
		assertEquals(false, p.equals(p1));
	}
	
	@Test
	public void test2() {
		Patient p = new Patient(2,2);
		p.addDiseaseld(UUID.randomUUID());
		p.addExposure(new Exposures(UUID.randomUUID()));
		Patient p1 = p;
		assertEquals(true, p.equals(p1));
	}
	
	@Test
	public void test3() {
		
		UUID patientId = UUID.randomUUID();
		
		Patient p = new Patient(2,2);
		p.setPatientId(patientId);
		
		Patient p1 = new Patient(1,2);
		p1.setPatientId(patientId);
		
		assertEquals(true, p.equals(p1));
	}
	
	@Test
	public void test4() {
		UUID patientId = UUID.randomUUID();
		
		Patient p = new Patient(2,2);
		p.setPatientId(patientId);
		
		Patient p1 = new Patient(1,2);
		p1.setPatientId( UUID.randomUUID());
		
		assertEquals(false, p.equals(p1));
	}
	
	@Test
	public void test5() {
		UUID patientId = UUID.randomUUID();
		Patient p = new Patient(2,2);
		p.setPatientId(patientId);
		
		assertEquals(p.hashCode(), Objects.hash(patientId));
	}
	
	@Test
	public void test7() {
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
	public void testPatient() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Patient p = new Patient(1,0);
			p.setPatientId(UUID.randomUUID());
	    });
		String message ="Value should be greater than 0";
		assertEquals(message,exception.getMessage());
		
		
	}
	
	@Test
	public void testPatient1() {
		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			Patient p = new Patient(1,1);
			p.addDiseaseld(UUID.randomUUID());
			p.addDiseaseld(UUID.randomUUID());
	    });
		String message ="diseaselds array is full";
		assertEquals(message,exception.getMessage());
		
		
	}
	
	@Test
	public void testPatient2() {
		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			Patient p = new Patient(1,1);
			p.addExposure(new Exposures(UUID.randomUUID()));
			p.addExposure(new Exposures(UUID.randomUUID()));
	    });
		String message ="exposures array is full";
		assertEquals(message,exception.getMessage());
		
		
	}
	
}
