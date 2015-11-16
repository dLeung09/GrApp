import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class AssignmentTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAssignment() {
		Assignment assgn = new Assignment();
		
		assertEquals(0, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}
	
	@Test
	public void testMarkShouldNotMarkUnassignedAssignment() throws UnassignedAssessmentException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		thrown.expect(UnassignedAssessmentException.class);
		
		assgn.mark(10);
	}

	@Test
	public void testAssignShouldPopulateWeight() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		
		assertEquals(0, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
		
		assgn.assign(10);
		
		assertEquals(10, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}
	
	@Test
	public void testAssignNegativeWeightShouldThrowException() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		
		thrown.expect(InvalidWeightException.class);
		
		assgn.assign(-10);
		
		assertEquals(0, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}
	
	@Test
	public void testAssignTooLargeWeightShouldThrowException() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		
		thrown.expect(InvalidWeightException.class);
		
		assgn.assign(110);
		
		assertEquals(0, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}
	
	@Test
	public void testAssignShouldOverwritePreviousAssign() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		
		assgn.assign(10);
		
		assertEquals(10, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
		
		assgn.assign(30);
		
		assertEquals(30, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}

	@Test
	public void testMarkShouldPopulateAndChangeMarked() throws InvalidWeightException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		assertEquals(0, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
		
		assgn.assign(10);
		assgn.mark(80);
		
		assertEquals(10, assgn.weight(), 0);
		assertEquals(80, assgn.grade(), 0);
		assertEquals(true, assgn.marked());
	}
	
	@Test
	public void testMarkShouldNotAcceptNegativeGrade() throws InvalidWeightException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		thrown.expect(InvalidGradeException.class);
		
		assgn.assign(10);
		assgn.mark(-80);
		
		assertEquals(10, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}
	
	@Test
	public void testMarkShouldNotAcceptTooLargeGrade() throws InvalidWeightException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		thrown.expect(InvalidGradeException.class);
		
		assgn.assign(10);
		assgn.mark(110);
		
		assertEquals(10, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}
	
	@Test
	public void testMarkShouldOverwritePreviousMark() throws InvalidWeightException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		assgn.assign(10);
		assgn.mark(80);
		
		assertEquals(10, assgn.weight(), 0);
		assertEquals(80, assgn.grade(), 0);
		assertEquals(true, assgn.marked());
		
		assgn.mark(90);
		
		assertEquals(90, assgn.grade(), 0);
	}

	@Test
	public void testWeightShouldNotReturnZeroWhenUnassigned() throws UnassignedAssessmentException {
		Assignment assgn = new Assignment();
		
		assertEquals(0, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
		
		thrown.expect(UnassignedAssessmentException.class);
		
		float weight = assgn.weight();
		
		System.out.println("Weight: " + weight);
	}

	@Test
	public void testGradeShouldNotReturnZeroWhenUnmarked() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		
		assgn.assign(10);
		
		//TODO
	}

	@Test
	public void testWeightedGradeShouldReturnWeightTimesGrade() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testWeightedGradeShouldNotReturnUnassigned() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testWeightedGradeShouldNotReturnUnmarked() {
		fail("Not yet implemented");
	}

	@Test
	public void testMarkedShouldReturnTrueWhenAssignmentHasMark() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMarkedShouldReturnFalseWhenAssignmentHasNoMark() {
		fail("Not yet implemented");
	}

}
