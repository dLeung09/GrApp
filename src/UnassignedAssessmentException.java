
@SuppressWarnings("serial")
public class UnassignedAssessmentException extends Exception {

	public UnassignedAssessmentException()
	{
		this("Error: Assessment has not been assigned a weight!");
	}
	
	public UnassignedAssessmentException(String message)
	{
		super(message);
	}
}
