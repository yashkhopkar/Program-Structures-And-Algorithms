package edu.neu.coe.info6205.sort.par;

import java.util.Random;

import javax.swing.text.html.MinimalHTMLWriter;

public class Main {

    public static void main(String[] args) {
    	
//    	int avgTime=0, avgThreadCount=0;
    	
    	
//        if (args.length>0) ParSort.cutoff = Integer.parseInt(args[0]);
    	
//        for(ParSort.cutoff=500000; ParSort.cutoff<5000000;ParSort.cutoff+=500000) {
        	
//        	
//        for(int k=0;k<10;k++) {
        	    	ParSort.cutoff=1000;
    	
    	
    	Random random = new Random(0L);
                
        int[] array = new int[8000];
        for (int i = 0; i < array.length; i++) array[i] = random.nextInt(20000000);
        
//        ParSort.cutoff= array.length *30/100;
        
//        ParSort.counThread = 1;
        double start = System.currentTimeMillis();
        
        ParSort.sort(array, 0, array.length-1);
        
        double end = System.currentTimeMillis();
               
//        for (int i : array) System.out.println(i);
        
        System.out.println("sorting time: "+ (end-start)+ " cut-off: "+ ParSort.cutoff+ "  Thread count: "+ ParSort.counThread);
//        if (array[0]==0) System.out.println("Success!");
//        System.out.println("Thread count: "+ ParSort.counThread);
//        avgTime += (end-start);
//        avgThreadCount += ParSort.counThread;
        
//        } 
//        System.out.println("sorting time: "+ avgTime/10+ " cut-off: "+ ParSort.cutoff+ "  Thread count: "+ avgThreadCount/10);
        
//    	}
        
        
    }
}
