package edu.disease.asn4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;

import edu.disease.asn3.DiseaseControlManagerImpl;
import edu.disease.asn3.Exposures;
import edu.disease.asn3.Patient;

public class ContactTraceTest {
	
	@Test
	public void passNullPatient() {
		DiseaseControlManagerImpl diseaseControlManagerImpl = new DiseaseControlManagerImpl(1,1 );
		Patient pt1  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 1);
		//patient 1
		pt1=null;	
		ContactTrace contactTrace = new ContactTrace(diseaseControlManagerImpl);
		contactTrace.FindPatientZero(pt1);
	}
	
	@Test
	public void passNullExposure() {
		DiseaseControlManagerImpl diseaseControlManagerImpl = new DiseaseControlManagerImpl(1,1 );
		UUID patientId1 = UUID.randomUUID();
		Patient pt1  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 1);
		pt1.setPatientId(patientId1);
		pt1.addExposure(new Exposures(patientId1));

		ContactTrace contactTrace = new ContactTrace(diseaseControlManagerImpl);
		PatientZero pz= contactTrace.FindPatientZero(pt1);
	}
	
	
	@Test
	public void findPatientZero() {
		DiseaseControlManagerImpl diseaseControlManagerImpl = new DiseaseControlManagerImpl(3,1 );
		

		UUID patientId1 = UUID.randomUUID();
		UUID patientId2 = UUID.randomUUID();
		UUID patientId3 = UUID.randomUUID();
		UUID patientId4 = UUID.randomUUID();
		
		
		Patient pt1  = diseaseControlManagerImpl.addPatient("Harry", "Potter", 1, 2);
		//patient 1
		pt1.setPatientId(patientId1);
		Exposures exposuresPt1 = new Exposures(patientId2);
		LocalDateTime dtp1 = LocalDateTime.of(2018, 12, 12, 20, 10);
		exposuresPt1.setDateTime(dtp1);
		exposuresPt1.setExposureType("D");
		pt1.addExposure(exposuresPt1);

		Exposures exposuresPt2 = new Exposures(patientId4);
		LocalDateTime dtPt2 = LocalDateTime.of(2019, 12, 12, 20, 10);
		exposuresPt2.setDateTime(dtPt2);
		exposuresPt2.setExposureType("I");
		pt1.addExposure(exposuresPt2);
		
//		Exposures exposuresPt3 = new Exposures(patientId1);
//		LocalDateTime dtPt3 = LocalDateTime.of(2020, 12, 12,8, 10);
//		exposuresPt3.setDateTime(dtPt3);
//		exposuresPt3.setExposureType("D");
//		pt1.addExposure(exposuresPt3);
//		
//		Exposures exposuresPt32 = new Exposures(UUID.randomUUID());
//		LocalDateTime dtPt32 = LocalDateTime.of(2020, 12, 12,8, 10);
//		exposuresPt32.setDateTime(dtPt32);
//		exposuresPt32.setExposureType("I");
//		pt1.addExposure(exposuresPt32);
		
		
		
		//patient 2
		
		Patient pt2  = diseaseControlManagerImpl.addPatient("Tom", "Cruse", 1, 2);
	
		pt2.setPatientId(patientId2);
		Exposures exposures2 = new Exposures(patientId3);
		LocalDateTime dtp2 = LocalDateTime.of(2010, 12, 12, 10, 10);
		exposures2.setDateTime(dtp2);
		exposures2.setExposureType("D");
		pt2.addExposure(exposures2);
		
		Exposures exposures3 = new Exposures(patientId4);
		LocalDateTime dtp201 = LocalDateTime.of(2023, 2, 6, 1, 10);
		exposures3.setDateTime(dtp201);
		exposures3.setExposureType("I");
		pt2.addExposure(exposures3);
//		
//		Exposures exposures31 = new Exposures(UUID.randomUUID());
//		LocalDateTime dtp2011 = LocalDateTime.of(2011, 2, 6, 1, 10);
//		exposures31.setDateTime(dtp2011);
//		exposures31.setExposureType("I");
//		pt2.addExposure(exposures31);
//		
		//patient 3
		Patient pt3  = diseaseControlManagerImpl.addPatient("Peter", "Parker", 1, 1);
		
		pt3.setPatientId(patientId3);
		Exposures exposures4 = new Exposures(patientId2);
		LocalDateTime dtp3 = LocalDateTime.of(2019, 12, 12, 20, 10);
		exposures4.setDateTime(dtp3);
		exposures4.setExposureType("I");
		pt3.addExposure(exposures4);
//		
//		Exposures exposures5 = new Exposures(patientId);
//		LocalDateTime dtp4 = LocalDateTime.of(2020, 12, 12, 20, 10);
//		exposures5.setDateTime(dtp4);
//		exposures5.setExposureType("D");
//		pt3.addExposure(exposures5);
////		
//		Exposures exposures6 = new Exposures(pa);
//		LocalDateTime dtp301 = LocalDateTime.of(2013, 12, 12, 20, 10);
//		exposures6.setDateTime(dtp301);
//		exposures6.setExposureType("D");
//		pt3.addExposure(exposures6);
		ContactTrace contactTrace = new ContactTrace(diseaseControlManagerImpl);
		
//		Patient[] patients = diseaseControlManagerImpl.getPatients();
//
		PatientZero patientZero = contactTrace.FindPatientZero(pt1);
//		for(Patient p: patients) {
//			PatientZero pz = contactTrace.FindPatientZero(p);
//			if(pz!=null){
//				if(patientZero==null ) {
//					patientZero = pz;
//				}
//				if(pz.getLocalDateTime().isBefore(patientZero.getLocalDateTime())) {
//					patientZero = pz;
//				}
//			}
//		}
		Patient pResult = patientZero.getPatient();
		assertEquals(pt3.getFirstName(), pResult.getFirstName());
	
		
	}
}
