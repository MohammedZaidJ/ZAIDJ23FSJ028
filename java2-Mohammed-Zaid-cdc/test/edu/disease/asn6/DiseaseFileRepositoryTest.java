package edu.disease.asn6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import edu.disease.asn3.Disease;
import edu.disease.asn3.NonInfectiousDisease;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

public class DiseaseFileRepositoryTest {
	
	// test save file
	// get the saved filed
	@Test
	public void testsave() throws Exception {
		DiseaseFileRepository dfr = new DiseaseFileRepository();
		//patient1
		Patient p = new Patient(1, 1);
		p.setFirstName("Harry"); 
		p.setLastName("Potter");
		p.setPatientId(UUID.randomUUID());
		//patient2
		Patient p1 = new Patient(1, 1);
		p1.setFirstName("tom");
		p1.setLastName("cruse");
		p1.setPatientId(UUID.randomUUID());
		// add patients to list
		List<Patient> ps = new ArrayList<>(2);
		ps.add(p);
		ps.add(p1);
		
		//disease1
		Disease d1 = new NonInfectiousDisease();
		d1.setDiseaseId(UUID.randomUUID());
		d1.setName("cancer");
		//disease12
		Disease d2 = new NonInfectiousDisease();
		d2.setDiseaseId(UUID.randomUUID());
		d2.setName("headAce");
		// add diseases to list
		List<Disease> ds = new ArrayList<>(2);
		ds.add(d1);
		ds.add(d2);
		
		dfr.save(ps,ds);
		String path = "C:\\Users\\Zaid\\Downloads\\java2-Zaid-J-cdc\\java2-lastname-firstname-cdc\\";
		
		DiseaseAndPatient dp = dfr.init(path);
		System.out.println(path);
		assertEquals(ps, dp.getPatients());
		
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
