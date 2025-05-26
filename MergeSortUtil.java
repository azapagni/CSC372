import java.util.ArrayList;
import java.util.Comparator;

public class MergeSortUtil {
    
    // merge sort implementation
    public static <T> void mergeSort(ArrayList<T> list, Comparator<T> comparator) {
        if (list.size() <= 1) {
            return;
        }
        
        mergeSortHelper(list, 0, list.size() - 1, comparator);
    }
    
    // helper method
    private static <T> void mergeSortHelper(ArrayList<T> list, int left, int right, Comparator<T> comparator) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // recursive sorting by halves
            mergeSortHelper(list, left, mid, comparator);
            mergeSortHelper(list, mid + 1, right, comparator);
            
            // merging sorted halves
            merge(list, left, mid, right, comparator);
        }
    }
    
    // merging subarrays
    private static <T> void merge(ArrayList<T> list, int left, int mid, int right, Comparator<T> comparator) {
        // temporary left and right subarrays
        ArrayList<T> leftArray = new ArrayList<>();
        ArrayList<T> rightArray = new ArrayList<>();
        
        // copying data
        for (int i = left; i <= mid; i++) {
            leftArray.add(list.get(i));
        }
        for (int i = mid + 1; i <= right; i++) {
            rightArray.add(list.get(i));
        }
        
        // merging temp arrays back to original
        int i = 0, j = 0, k = left;
        
        while (i < leftArray.size() && j < rightArray.size()) {
            if (comparator.compare(leftArray.get(i), rightArray.get(j)) <= 0) {
                list.set(k, leftArray.get(i));
                i++;
            } else {
                list.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }
        
        // copy remaining elements of leftArray, if any
        while (i < leftArray.size()) {
            list.set(k, leftArray.get(i));
            i++;
            k++;
        }
        
        // copy remaining elements of rightArray, if any
        while (j < rightArray.size()) {
            list.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
}