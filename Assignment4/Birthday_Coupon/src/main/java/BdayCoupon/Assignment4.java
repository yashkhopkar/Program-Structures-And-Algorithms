package BdayCoupon;

public class Assignment4 {
    
    public static void main(String[] args)
	{
            System.out.println("Birthday Problem");
            //for(int i=100;i<=10000;i+=100)
            //{
            //System.out.println(i);
            BdayProblem sc = new BdayProblem(20);
            sc.happyBirthday();
            //}
            System.out.println("Coupon Collector");
           // for(int i=100;i<=10000;i+=100)
            //{
            //System.out.println(i);
            CouponCollector cc = new CouponCollector(4);
            cc.coupon();
            //}
        }
    
}
