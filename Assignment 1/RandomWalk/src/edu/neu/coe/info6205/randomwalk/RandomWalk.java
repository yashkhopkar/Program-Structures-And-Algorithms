/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.randomwalk;

import java.util.Random;
import java.lang.Math;
import java.util.Scanner;

public class RandomWalk {
    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    public void move(int dx, int dy) {
        // TODO you need to implement this
    	this.x = this.x+dx;
    	this.y = this.y+dy;
    	
    	//System.out.println(this.x+","+this.y);
    }

    private void randomWalk(int n) {
        for (int i = 0; i < n; i++)
            randomMove();
    }

    private void randomMove() {
        // The length of the step is taken as 'l' = 1
    	int dir = this.random.nextInt(4)+1;
    	//System.out.println(dir);
    	if(dir==1)
    		this.move(0, 3);
    	else if(dir==2)
    		this.move(3, 0);
    	else if(dir==3)
    		this.move(0, -3);
    	else if(dir==4)
    		this.move(-3,0);
    	else
    		System.out.println("incorrect input for movement");
    	
    }

    public double distance() {
    	
    	//double displacement = 0.0;
    	double xx = (double) this.x;
    	double yy = (double) this.y;
    	
    	//System.out.println("from distnce: "+xx+","+yy);
    	
    	double displacement = Math.sqrt(Math.abs((xx*xx)+(yy*yy)));
    	//System.out.println(displacement);
    	
        return displacement; // TODO you need to implement this
    }

    public static void main(String[] args) {
    	

//    	int n = 190000;
		double sum = 0.0;
		double avg = 0.0;
		for(int n=0; n<310000;n=n+35000)
		{
			for(int iterate=0; iterate <10; iterate++)
			{
    		

				RandomWalk walk = new RandomWalk();
				walk.randomWalk(n);
//				System.out.println(n + " steps: " + walk.distance());
				sum = sum + walk.distance();
			}
			
			avg = sum/10;
			sum = 0;
//    		System.out.println(avg);
//			System.out.println(n + " steps " + avg + " average distance");
			System.out.println(n + ",  " + avg);
			
		}
    }
}
