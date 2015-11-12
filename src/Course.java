import java.util.HashMap;

public class Course {

	private String courseName;
	public HashMap<String, Assessment> syllabus;
	
	public Course()
	{
		this("Unnamed_Course");
	}
	
	public Course(String course)
	{
		this.courseName = course;
	}
	
	public void assignTest(String name, float wt) throws InvalidWeightException
	{
		Test tst = new Test();
		tst.assign(wt);
		assign(name, tst);
	}
	
	public void assignAssignment(String name, float wt) throws InvalidWeightException
	{
		Assignment assgnmnt = new Assignment();
		assgnmnt.assign(wt);
		assign(name, assgnmnt);
	}
	
	private void assign(String name, Assessment assmnt)
	{
		if (this.syllabus.containsKey(name))
		{
			System.out.println("    WARNING: " + name + " already exists, and was not"
					+ "assigned to the syllabus.");
			// TODO/FIXME: Throw an exception?
		}
		else
		{
			this.syllabus.put(name, assmnt);
			System.out.println(name + " was successfully added to the syllabus.");
		}
	}
	
	public void mark(String name, float gr) throws InvalidGradeException
	{
		if (this.syllabus.containsKey(name))
		{
			Assessment assmnt = this.syllabus.remove(name);
			assmnt.mark(gr);
			this.syllabus.put(name, assmnt);
			System.out.println(name + " was successfully assigned a grade of: " + gr + ".");
		}
		else
		{
			System.out.println("    WARNING: " + name + " has not been assigned in the syllabus.");
			System.out.println("        All assessments must be assigned to the syllabus before"
					+ " grading.");
			// TODO/FIXME: Throw an exception?
		}
	}
	
	public float avgGrade()
	{
		// Returns grade for course that only takes into account marked assessments.
		Assessment assmnt;
		float grade = 0;
		
		for (String key : this.syllabus.keySet())
		{
			assmnt = this.syllabus.get(key);
			
			if (assmnt.marked())
			{
				grade += assmnt.weightedGrade();
			}
		}
		
		return grade;
	}
	
	public float finalGrade()
	{
		// Returns grade for course including all assessments (marked and unmarked)
		Assessment assmnt;
		float grade = 0;
		
		for (String key : this.syllabus.keySet())
		{
			assmnt = this.syllabus.get(key);
			
			grade += assmnt.weightedGrade();
		}
		
		return grade;
	}
	
	public float percentUnassigned()
	{
		// Returns percentage of grade that is not assigned in the syllabus
		Assessment assmnt;
		float unassigned = 100;
		
		for (String key : this.syllabus.keySet())
		{
			assmnt = this.syllabus.get(key);
			
			unassigned -= assmnt.weight();
		}
		
		return unassigned;
	}
	
	public void printSyllabus()
	{
		// Prints the weights for all assessments in the syllabus
		Assessment assmnt;
		
		System.out.println("Syllabus for " + this.courseName + ":");
		System.out.println("Assessment:\tWeight:");
		
		for (String key : this.syllabus.keySet())
		{
			assmnt = this.syllabus.get(key);
			
			System.out.println(key + " ->\t" + assmnt.weight());
		}
	}
	
	public void printGrades()
	{
		// Prints the grades for all assessments in the syllabus
		Assessment assmnt;
		
		System.out.println("Grades for " + this.courseName + ":");
		System.out.println("Assessment:\tGrade:");
		
		for (String key : this.syllabus.keySet())
		{
			assmnt = this.syllabus.get(key);
			
			System.out.println(key + " ->\t" + assmnt.grade());
		}
	}
}
