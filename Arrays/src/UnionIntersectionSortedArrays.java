public class UnionIntersectionSortedArrays {
    public static void main(String [] a) {
	int [] A = {1,3,5,7};
	int [] B = {1,2,3,4};
	union(A,B);
	intersection(A,B);
    }
    static void union(int []a,int []b) {
	int indexi=0,indexj=0;
	while((indexi < a.length) && (indexj < b.length)) {
	    if(a[indexi] == b[indexj]) {
		System.out.print(a[indexi]+" ");
		indexi++;
		indexj++;
	    }
	    else if(a[indexi] < b[indexj]) {
		System.out.print(a[indexi]+" ");
		indexi++;
	    }
	    else {
		System.out.print(b[indexj]+" ");
		indexj++;
	    }
	    System.out.println();
	}
	while(indexi <= a.length-1) {
		System.out.println(a[indexi++]);
	}
	while(indexj <= b.length-1) {
		System.out.println(b[indexj++]);
	}
    }
    static void intersection(int []a,int []b) {
	int indexi=0,indexj=0;
	while((indexi < a.length) && (indexj < b.length)) {
	    if(a[indexi] == b[indexj]) {
		System.out.print(a[indexi]+" ");
		indexi++;
		indexj++;
	    }
	    else if(a[indexi] < b[indexj]) {
		//	System.out.print(a[indexi]+" ");
		indexi++;
	    }
	    else {
		//		System.out.print(b[indexj]+" ");
		indexj++;
	    }
	}

    }
}
