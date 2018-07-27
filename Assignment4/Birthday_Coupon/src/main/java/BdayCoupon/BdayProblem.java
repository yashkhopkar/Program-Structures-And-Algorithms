package BdayCoupon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BdayProblem<K, V>  {
    
    ArrayList<HashNode<K, V>>bucket=new ArrayList<>();
    //for(int k=1;k<=500;k++)
    
	static int numBuckets;
    
	int size;
        static int count=0;
        static boolean flag=true;
	public BdayProblem(int n)
	{
            this.numBuckets=n;
		for(int i=0;i<numBuckets;i++)
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
		count=size;
		int index=getBucketIndex(key);
		//System.out.println(index);
		HashNode<K, V>head=bucket.get(index);
		HashNode<K, V>toAdd=new HashNode<>();
		toAdd.key=key;
		toAdd.value=value;
		if(head==null)
		{
			bucket.set(index, toAdd);
			size++;
			
		}
		else
		{
                flag=false;
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
       
	public int happyBirthday()
	{
            int avg=0;
            for(int j=1;j<=100;j++)
            {
		BdayProblem<String,Integer>map=new BdayProblem<>(numBuckets);
		
                
           Random r=new Random(0);
        int[] array=new int[numBuckets];
        for (int i = 0; i<array.length; i++) 
          {
           array[i] = r.nextInt(numBuckets); 
          }
            
        for (int i = 0; i<array.length; i++) 
        {
                    String key= String.valueOf(array[i]);
                    if(flag)
                    map.add(key, i);
                    else
                    {
                        flag=true;
                        break;
                    }
            
        }
//        System.out.println("count :" +count);
//         for (int i = 0; i<array.length; i++) 
//        {
//           String key= String.valueOf(array[i]);
//           System.out.println("keys " + map.getBucketIndex(key));
//        } 
        avg+=count;
        }
         System.out.println("number of hashes/throws before first Collision : " +avg/100);
         return avg/100;
    }
	
}


