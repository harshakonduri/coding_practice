import java.util.ArrayList;
import java.util.List;

public class WindowSum {
    public static void main(String [] args) {
	List<Integer> al = new ArrayList<Integer>();
	al.add(4);
	al.add(2);
	al.add(73);
	al.add(11);
	al.add(-5);
	System.out.println(calculateWindowSums(al, 3));
    }    
    public static List<Integer> calculateWindowSums(List<Integer> list, int windowSize) {

	ArrayList<Integer> windowSum = new ArrayList<Integer>(); // return this List
	int currentWindowSum = 0; // calculate the Sum of the current Window
	
	// the if condition ensures that if the window size is > list.size() it adds all the 
	// elements and returns a single element list.
	for(int i = 0;i < windowSize && i < list.size();i++) {
	    currentWindowSum += list.get(i);
	}
	windowSum.add(currentWindowSum); // add the first k sum
	
	// for every element starting from windowSize to the end, the first element of the
	// previous windowSize is removed and the current element is added. The rest of the 
	// sum is already calculated
	// So we subtract the element at currentElement - windowSize and
	// add the current element.
	// Update the list with the new Sum
	for(int i = windowSize; i < list.size();i++) {
	    currentWindowSum = currentWindowSum + list.get(i) - list.get(i - windowSize);
	    windowSum.add(currentWindowSum);
	}
	return windowSum;
    }
}
