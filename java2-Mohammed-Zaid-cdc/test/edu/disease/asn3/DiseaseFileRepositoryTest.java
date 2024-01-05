package edu.disease.asn3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.File;
import java.util.UUID;

import org.junit.Test;

public class DiseaseFileRepositoryTest {
	
	// test save file
	// get the saved filed
	@Test
	public void testsave() throws Exception {
		DiseaseFileRepository dfr = new DiseaseFileRepository();
		
		Patient p = new Patient(1, 1);
		p.setFirstName("Harry");
		p.setLastName("Potter");
		p.setPatientId(UUID.randomUUID());
		
		Patient p1 = new Patient(1, 1);
		p1.setFirstName("tom");
		p1.setLastName("cruse");
		p1.setPatientId(UUID.randomUUID());
		
		Patient[] ps = new Patient[] {p,p1};
		
		Disease d1 = new NonInfectiousDisease();
		d1.setDiseaseId(UUID.randomUUID());
		d1.setName("cancer");
		
		Disease d2 = new NonInfectiousDisease();
		d2.setDiseaseId(UUID.randomUUID());
	
		d2.setName("cancer");
		
		Disease[] ds = new Disease[] {d1,d2};
		
		
		dfr.save(ps,ds);
		String path = "C:\\Users\\Zaid\\Downloads\\java2-Zaid-J-cdc\\java2-lastname-firstname-cdc\\";
		
		DiseaseAndPatient dp = dfr.init(path);
		System.out.println(path);
		assertArrayEquals(ps, dp.getPatients());
		
	}

	// passing null to folder path
	@Test
	public void testNullMessage() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			DiseaseFileRepository dfr = new DiseaseFileRepository();
			dfr.init(null);
	    });
		String message ="file not found";
		assertEquals(message,exception.getMessage());

	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
