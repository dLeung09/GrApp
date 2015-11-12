
public interface Assessment {

	/*
	 * Assessments should contain the following private member variables:
	 * 	-> weight (float)   - the percentage the assessment is worth; between 0 and 100
	 * 	-> grade  (float)   - the grade that was given for the assessment; between 0 and 100
	 * 	-> marked (boolean) - an indicator of whether the assessment has been given a mark
	 */

	void assign(float wt) throws InvalidWeightException;	// Sets the private member variable 'weight'
	
	void mark(float gr) throws InvalidGradeException;	// Sets the private member variable 'grade'; sets 'marked' to 'true'
	
	float weight();			// Gets the private member variable 'weight'
	
	float grade();			// Gets the private member variable 'grade'
	
	float weightedGrade();	// (grade * weight) / 100
	
	boolean marked();		// Gets the private member variable 'marked'
}
