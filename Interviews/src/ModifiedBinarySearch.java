
public class ModifiedBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,3,4,4,5,6,7};
		int low = lowerbinarySearch(a, 4, 0, a.length-1);
		int upper = upperbinarySearch(a, 4, 0, a.length-1);
		System.out.println(upper-low -1);
	}
	static int upperbinarySearch(int []a,int key,int low,int high) {
		if(low > high) {
			return low;
		}
		int mid = (low+high)/2;
		if(key < a[mid]) {
			return upperbinarySearch(a, key, low, mid-1);
		}
		else {
			return upperbinarySearch(a, key, mid+1, high);
		}
	}
	static int lowerbinarySearch(int []a,int key,int low,int high) {
		if(low > high) {
			return high;
		}
		int mid = (low+high)/2;
		if(key <= a[mid]) {
			return lowerbinarySearch(a, key, low, mid-1);
		}
		else {
			return lowerbinarySearch(a, key, mid+1, high);
		}
	}

}
