
@SuppressWarnings("serial")
public class InvalidGradeException extends Exception {

	public InvalidGradeException()
	{
		this("Invalid Value!");
	}
	
	public InvalidGradeException(String message)
	{
		super(message);
	}
}
