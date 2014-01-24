
public class ModifiedBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {4,5,6,7,8,1,2,3};
		int low = lowerbinarySearch(a, 4, 0, a.length-1);
		int upper = upperbinarySearch(a, 4, 0, a.length-1);
		int k = modbinSearch(a, 4, 0, a.length-1);
		System.out.println(k+" "+a[k]);
	}
	static int modbinSearch(int[]a,int key,int low,int high) {
		if(low>high) {
			return -1;
		}
		int mid = (low+high)/2;
		
		//System.out.println(low+" "+mid+" "+high);
		if(a[mid] == key) {
			return mid;
		}
		if(a[low] > a[high]) {
		if(a[low] > a[mid]) {
			if(key > a[mid]) {
				if(key >= a[low])
					return modbinSearch(a, key, low, mid-1);
				else if(key <= a[high])
					return modbinSearch(a, key, mid+1, high);
			}
			else {
				return modbinSearch(a, key, low, mid-1);
			}
		}
		else if(a[high] < a[mid]) {
		
			if(key > a[mid]) {
				return modbinSearch(a, key, mid+1, high);
			}
			else if(key <= a[high]) {
				return modbinSearch(a, key, mid+1, high);
			}
			else {
				return modbinSearch(a, key, low, mid-1);
			}
		
		}
		}
		else {
			if(key < a[mid]) {
				return modbinSearch(a, key, low,mid-1);				
			}
			else {
				return modbinSearch(a, key, mid+1, high);
			}
		}
		return -1;
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
