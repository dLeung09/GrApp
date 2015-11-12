
public class Assignment implements Assessment {

	private float weight;
	private float grade;
	private boolean marked;
	
	public Assignment()
	{
		this.weight = 0;
		this.grade = 0;
		this.marked = false;
	}
	
	public void assign(float wt) throws InvalidWeightException
	{
		// Assign a weight to the assignment
		if (wt < 0)
		{
			throw new InvalidWeightException("Error: Assignment.weight cannot be negative!");
		}
		else if (wt > 100)
		{
			throw new InvalidWeightException("Error: Assignment.weight cannot be greater than 100%!");
		}
		
		this.weight = wt;
	}
	
	public void mark(float gr) throws InvalidGradeException
	{
		// Assign a grade to the assignment
		if (gr < 0)
		{
			throw new InvalidGradeException("Error: Assignment.grade cannot be negative!");
		}
		else if (gr > 100)
		{
			// Accept bonus marks?
			throw new InvalidGradeException("Error: Assignment.grade cannot be greater than 100%!");
		}
		
		this.grade = gr;
		this.marked = true;
	}
	
	public float weight()
	{
		// Returns the weight of the assignment
		return this.weight;
	}
	
	public float grade()
	{
		// Returns the grade of the assignment
		return this.grade;
	}
	
	public float weightedGrade()
	{
		// Returns (grade * weight) / 100
		return (this.grade * this.weight) / 100;		
	}
	
	public boolean marked()
	{
		// Returns true if the assignment has been given a mark
		return this.marked;
	}
}
