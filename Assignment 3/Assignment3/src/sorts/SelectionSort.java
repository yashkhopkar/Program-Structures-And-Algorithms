package sorts;

import static sorts.Helper.less;
import static sorts.Helper.swap;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

    
    public void sort(X[] a, int lo, int hi) {
    	
    	for (int i = lo; i < hi; i++) {
            int min = i;
            for (int j = i+1; j < hi; j++) {
                if (less(a[j], a[min])) min = j;
            }
            swap(a, i, min);
            
        }
        
    }
}
