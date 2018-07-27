package BdayCoupon;

import java.util.ArrayList;
import java.util.Random;
    
public class CouponCollector<K, V>  {
    
    ArrayList<HashNode<K, V>>bucket=new ArrayList<>();
    
    
	static int numBuckets;
        static int n=0;
	int size;
        static int count=0;
        static boolean flag=true;
       
	public CouponCollector(int n)
	{
            this.numBuckets=n;
		for(int i=0;i<n;i++)
		{
			bucket.add(null);
		}
	}
	public int getSize()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	private int getBucketIndex(K key)
	{
		int hashCod=key.hashCode();
		return hashCod%numBuckets;
	}
	public V get(K key)
	{
		int index=getBucketIndex(key);
		HashNode<K, V> head=bucket.get(index);
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				return head.value;
			}
			head=head.next;
		}
		return null;	
	}
	
	public void add(K key,V value)
	{
		
             if(count==numBuckets)
             {
                 flag=false;
             }
		int index=getBucketIndex(key);
		//System.out.println(index);
		HashNode<K, V>head=bucket.get(index);
		HashNode<K, V>toAdd=new HashNode<>();
		toAdd.key=key;
		toAdd.value=value;
		if(head==null)
		{
                     count++;
			bucket.set(index, toAdd);
                       
                        
		}
		else
		{
//                flag=false;
		while(head!=null)
		{
                   
			if(head.key.equals(key))
			{
				head.value=value;
				size++;
				break;
			}
			head=head.next;
		}
		if(head==null)
		{
		head=bucket.get(index);
		toAdd.next=head;
		bucket.set(index, toAdd);
		size++;
		}
		}
		
	}
       
	public int coupon()
	{
//            int avg=0;
//            for(int j=1;j<=100;j++)
//            {
		CouponCollector<String,Integer>map=new CouponCollector<>(numBuckets);
	
        int i=0;
        while(flag==true && count<=numBuckets)
        {
            Random r=new Random();
            int ran = r.nextInt(numBuckets);
            String key= String.valueOf(ran);
            n++;
            map.add(key, i);
            if(!flag)
                    {
                        
                        flag=true;
                        break;
                    }
            i++;
            
        }
//        System.out.println("count :" +count);
//         for (int i = 0; i<array.length; i++) 
//        {
//           String key= String.valueOf(array[i]);
//           System.out.println("keys " + map.getBucketIndex(key));
//        } 
//        avg+=count;
//        }
         System.out.println("Number of hashes/throws before all bins/slots are filled :  " + --n);
         
         return n;
    }
	
}
