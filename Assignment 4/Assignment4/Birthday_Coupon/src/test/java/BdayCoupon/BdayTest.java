package BdayCoupon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class BdayTest {

	
	 @Test
	    public void testFind0() {
	        BdayProblem bp = new BdayProblem(10);
	        assertEquals(7, bp.happyBirthday());
	    }
	 
	 @Test
	    public void testFind1() {
	        BdayProblem bp = new BdayProblem(20);
	        assertEquals(6, bp.happyBirthday());
	    }
	 
	 @Test
	    public void testFind2() {
	        BdayProblem bp = new BdayProblem(100);
	        assertEquals(11, bp.happyBirthday());
	    }
}
