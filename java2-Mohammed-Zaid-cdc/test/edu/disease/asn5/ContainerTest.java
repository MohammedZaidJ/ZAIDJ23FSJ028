package edu.disease.asn5;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.Test;

import edu.disease.asn3.DiseaseControlManagerImpl;
import edu.disease.asn3.Patient;

public class ContainerTest {
	

	@Test
	public void testConstructorZeroArguments() {

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Container container = new Container<Patient>();
	    });

		String message ="Argument not supplied";
		assertEquals(message,exception.getMessage());
	}

	@Test
	public void testSizeMethod() {
		Container container;
		
		
		DiseaseControlManagerImpl diseaseControlManagerImpl = new DiseaseControlManagerImpl(3,1 );
		UUID patientId1 = UUID.randomUUID();
		UUID patientId2 = UUID.randomUUID();

		//patient 1
		Patient pt1  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 2);
		pt1.setPatientId(patientId1);
		
		//patient 2
		Patient pt2  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 2);
		pt2.setPatientId(patientId2);
		
		container = new Container<Patient>(pt1,pt2);
		
		int size = container.size();
		
		assertEquals(2, size);
		
	}
	@Test
	public void testgetMethod() {
		Container container;
		
		
		DiseaseControlManagerImpl diseaseControlManagerImpl = new DiseaseControlManagerImpl(3,1 );
		UUID patientId1 = UUID.randomUUID();
		UUID patientId2 = UUID.randomUUID();

		//patient 1
		Patient pt1  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 2);
		pt1.setPatientId(patientId1);
		
		//patient 2
		Patient pt2  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 2);
		pt2.setPatientId(patientId2);
		
		container = new Container<Patient>(pt1,pt2);
		
		
		Object pt = container.get(1);
		assertEquals(pt2, pt);
		
	}
	@Test
	public void testgetMethodIndex() {
		Container container;
		
		
		DiseaseControlManagerImpl diseaseControlManagerImpl = new DiseaseControlManagerImpl(3,1 );
		UUID patientId1 = UUID.randomUUID();
		UUID patientId2 = UUID.randomUUID();

		//patient 1
		Patient pt1  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 2);
		pt1.setPatientId(patientId1);
		
		//patient 2
		Patient pt2  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 2);
		pt2.setPatientId(patientId2);
		
		container = new Container<Patient>(pt1,pt2);
		
		
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			container.get(100);
	    });

		String message ="Invalid index";
		assertEquals(message,exception.getMessage());
		
	}
}
