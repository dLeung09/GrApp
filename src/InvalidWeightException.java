
@SuppressWarnings("serial")
public class InvalidWeightException extends Exception {

	public InvalidWeightException()
	{
		this("Error: Invalid value!");
	}
	
	public InvalidWeightException(String message)
	{
		super(message);
	}
}
