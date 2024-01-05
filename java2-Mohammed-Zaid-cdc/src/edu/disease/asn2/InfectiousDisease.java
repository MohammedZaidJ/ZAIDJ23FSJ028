package edu.disease.asn2;

public class InfectiousDisease extends Disease{
	
	// it inherited by the Disease
	// here we pass some string values for array
	// return String
	@Override
	public String[] getExamples() {
		// TODO Auto-generated method stub
		return new String[] {"Chickenpox", "Common cold", "Diphtheria", "HIV/AIDS"};
	}

}
