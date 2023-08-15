package edu.disease.asn2;
/*
* @author  Mohammed Zaid
* @version 1.0
* @since   2023-08-15
*/
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
