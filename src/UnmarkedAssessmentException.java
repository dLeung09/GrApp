
@SuppressWarnings("serial")
public class UnmarkedAssessmentException extends Exception {
	
	public UnmarkedAssessmentException()
	{
		this("Error: Assessment has not been marked!");
	}
	
	public UnmarkedAssessmentException(String message)
	{
		super(message);
	}

}
