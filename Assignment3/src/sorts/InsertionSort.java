package sorts;
import static sorts.Helper.less;
import static sorts.Helper.swap;

public class InsertionSort<X extends Comparable<X>> implements Sort<X>{
    
	@Override
    public void sort(X[] a, int lo, int hi) {
        // TODO implement insertionSort
    	for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                swap(a, j, j-1);
            }
        }
    	
    }
    
}

