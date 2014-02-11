public class DuplicateArray {
    public static void main(String [] args) {
	int [] a = {1,2,3,4,5,1,1,1,2,2,3,4,4,5,5,5,6,5,7,7,8};
	removeUnsortedDuplicates(a);
    }
    static void removeSortedDuplicates(int []a) {
	int i=0;
	for(int j=i+1;j<a.length;j++) {
	    if(a[j] != a[i]) {
		i = i+1;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	    }
	}
	for(int j = i+1;j<a.length;j++) {
	    a[j] = 0;
	}
	for(int k:a) {
	    System.out.print(k+" ");
	}
    }
    static void removeUnsortedDuplicates(int []a) {
	int i = 0;
	java.util.HashSet<Integer> hs = new java.util.HashSet<Integer>();
	hs.add(a[0]);
	for(int j = i+1;j<a.length;j++) {
	    if(hs.add(a[j])) {
		i = i+1;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	   }		
	}
	for(int j = i+1;j<a.length;j++) {
	    a[j] = 0;
	}
	for(int k:a) {
	    System.out.print(k+" ");
	}

    }
}

