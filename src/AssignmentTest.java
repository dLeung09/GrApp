import static org.junit.Assert.*;
import org.junit.Test;


public class AssignmentTest {

	@Test
	public void testAssignment() {
		Assignment assgn = new Assignment();
		
		assertEquals(0, assgn.weight(), 0);
		assertEquals(0, assgn.grade(), 0);
		assertEquals(false, assgn.marked());
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
	public void testAssignShouldNotAssignMarkedAssignment() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAssignShouldNotAcceptNegativeWeight() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAssignShouldNotAcceptTooLargeWeight() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAssignShouldOverwritePreviousAssign() {
		fail("Not yet implemented");
	}

	@Test
	public void testMarkShouldPopulateAndChangeMarked() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMarkShouldNotMarkUnassignedAssignment() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMarkShouldNotAcceptNegativeGrade() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMarkShouldNotAcceptTooLargeGrade() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMarkShouldOverwritePreviousMark() {
		fail("Not yet implemented");
	}

	@Test
	public void testWeightShouldReturnAssignedWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testWeightShouldNotReturnZeroWhenUnassigned() {
		fail("Not yet implemented");
	}

	@Test
	public void testGradeShouldReturnMarkedWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGradeShouldNotReturnZeroWhenUnmarked() {
		fail("Not yet implemented");
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
	public void testMarkedShouldReturnTrue() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMarkedShouldReturnFalse() {
		fail("Not yet implemented");
	}

}
