import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class AssignmentTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAssignmentShouldInitializeEmpty() {
		Assignment assgn = new Assignment();
		
		assertEquals(0, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}
	
	@Test
	public void testMarkShouldThrowExceptionOnUnassignedAssignment() throws UnassignedAssessmentException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		thrown.expect(UnassignedAssessmentException.class);
		
		assgn.mark(10);
	}

	@Test
	public void testAssignShouldPopulateWeight() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		assgn.assign(10);
		
		assertEquals(10, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
	}
	
	@Test
	public void testAssignShouldThrowExceptionOnNegativeWeight() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		
		thrown.expect(InvalidWeightException.class);
		assgn.assign(-10);
	}
	
	@Test
	public void testAssignShouldThrowExceptionOnTooLargeWeight() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		
		thrown.expect(InvalidWeightException.class);
		assgn.assign(110);
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
		
		assgn.assign(10);
		assgn.mark(80);
		
		assertEquals(10, assgn.weight(), 0);
		assertEquals(80, assgn.grade(), 0);
		assertEquals(true, assgn.marked());
	}
	
	@Test
	public void testMarkShouldThrowExceptionOnNegativeGrade() throws InvalidWeightException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		assgn.assign(10);
		
		thrown.expect(InvalidGradeException.class);
		assgn.mark(-80);
	}
	
	@Test
	public void testMarkShouldThrowExceptionOnTooLargeGrade() throws InvalidWeightException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		assgn.assign(10);
		
		thrown.expect(InvalidGradeException.class);
		assgn.mark(110);
	}
	
	@Test
	public void testMarkShouldOverwritePreviousMark() throws InvalidWeightException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		assgn.assign(10);
		assgn.mark(80);
		
		assertEquals(80, assgn.grade(), 0);
		
		assgn.mark(90);
		
		assertEquals(90, assgn.grade(), 0);
	}

	@Test
	public void testWeightShouldThrowExceptionWhenUnassigned() throws UnassignedAssessmentException {
		Assignment assgn = new Assignment();
		
		thrown.expect(UnassignedAssessmentException.class);
		
		assertEquals(0, assgn.weight(), 0);
	}

	@Test
	public void testGradeShouldThrowExceptionWhenUnmarked() throws InvalidWeightException {
		Assignment assgn = new Assignment();
		
		assgn.assign(10);
		
		thrown.expect(UnmarkedAssessmentException.class);
		
		assertEquals(0, assgn.grade(), 0);
	}

	@Test
	public void testWeightedGradeShouldReturnWeightTimesGrade() throws InvalidWeightException, InvalidGradeException {
		Assignment assgn = new Assignment();
		
		assgn.assign(10);
		assgn.mark(81);
		
		float weightedGrade = assgn.weightedGrade();
		assertEquals(8.1, weightedGrade, 0);
	}
	
	@Test
	public void testWeightedGradeShouldNotReturnUnassigned() {
		Assignment assgn = new Assignment();
		
		thrown.expect(UnassignedAssessmentException.class);
		
		assertEquals(0, assgn.weightedGrade(), 0);
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
