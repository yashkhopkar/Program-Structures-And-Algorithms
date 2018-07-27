package BdayCoupon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CouponTest {
	
	@Test
    public void testFind0() {
		CouponCollector cc = new CouponCollector(4);
		cc.add(0, 0);
		cc.add(1, 1);
		cc.add(2, 2);
		cc.add(0, 3);
		cc.add(3, 4);
		cc.n=5;
		assertEquals(5, cc.coupon());
    }
 
 @Test
    public void testFind1() {
	 CouponCollector cc = new CouponCollector(6);
        assertEquals(0, cc.size);
    }
}
