package sorts;

//import java.util.Arrays;
//import java.util.Collections;
import java.util.Random;
import java.util.function.Function;

public class Benchmark<T> {
	
	public Benchmark(Function<T, Void> f) {
      this.f = f;
  }

  public double run(T t, int m) {
      
  	double average=0;
  	for(int i=0;i<m;i++)
  	{
      double start = System.nanoTime(); 
  	f.apply(t);    	
  	double end = System.nanoTime(); 
  	double elapsedTime = end - start;
  	average+=elapsedTime;
  	}
  	return ((average/m)/1000000);
  }

  private final Function<T, Void> f;

  public static void main(String[] args) {
      int m = 1000; // This is the number of repetitions: sufficient to give a good mean value of timing
      Random r = new Random();
      Integer[] arrayOrdered = new Integer[20000];
      Integer[] arrayReverse = new Integer[20000];
      Integer[] arrayRandom = new Integer[20000];
      Integer[] arrayPartial = new Integer[20000];
      for (int i = 0; i<20000; i++) arrayOrdered[i] = i;
      for (int i = 19999; i>=0; i--) arrayReverse[i] = i; // TODO populate the array with real random data
      for (int i = 0; i<20000; i++) arrayRandom[i] = r.nextInt(20000); 
      for (int i = 0; i<9999; i++) 
      	arrayPartial[i] = r.nextInt(9999);
      for (int i = 10000; i<2000; i++) 
      	arrayPartial[i] = i;
      int n =16000;
      //for (int n = 500; i<=20000; i=i*2) 
      System.out.println("--------------Ordered Array----------------");
      benchmarkSort(arrayOrdered, n, "SelectionSort", new SelectionSort<>(), m);
      benchmarkSort(arrayOrdered, n, "InsertionSort", new InsertionSort<>(), m);
      System.out.println("--------------Reverse-Ordered Array----------------");
      benchmarkSort(arrayReverse, n, "SelectionSort", new SelectionSort<>(), m);
      benchmarkSort(arrayReverse, n, "InsertionSort", new InsertionSort<>(), m);
      System.out.println("--------------Random Array----------------");
      benchmarkSort(arrayRandom, n, "SelectionSort", new SelectionSort<>(), m);
      benchmarkSort(arrayRandom, n, "InsertionSort", new InsertionSort<>(), m);
      System.out.println("--------------Partially-Sorted Array----------------");
      benchmarkSort(arrayPartial, n, "SelectionSort", new SelectionSort<>(), m);
      benchmarkSort(arrayPartial, n, "InsertionSort", new InsertionSort<>(), m);
      
  }

  private static void benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
      Function<Integer, Void> sortFunction = (x) -> {
          sorter.sort(xs.clone(), 0, x);
          //Collections.shuffle(Arrays.asList(xs));
          return null;
      };
      
      // Warm up 
      for (int i = 0; i < 100; i++)
      	sortFunction.apply(n);
      
      Benchmark<Integer> bm = new Benchmark<>(sortFunction);
      double x = bm.run(n, m);
      System.out.println(name + ": " +(float)x + " milisecs for n=" + n);
  }
}
