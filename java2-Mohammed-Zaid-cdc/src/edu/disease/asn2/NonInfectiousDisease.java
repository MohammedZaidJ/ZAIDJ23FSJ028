package edu.disease.asn2;

public class NonInfectiousDisease extends Disease{

	@Override
	// it inherited by the Disease
		// here we pass some string values for array
		// return String
	public String[] getExamples() {
		// TODO Auto-generated method stub
		return new String[] {"heart disease", "stroke", "cancer", "diabetes "};
	}

}
