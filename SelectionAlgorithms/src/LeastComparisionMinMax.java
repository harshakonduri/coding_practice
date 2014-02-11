public class LeastComparisionMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {2,1,3,5,6,7,4,9,11};
		minmax(a);
	}
	public static void minmax(int []a) {
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    int i = 0;
	    while(i<a.length) {
		if(i+1 < a.length) {
		    if(a[i]<a[i+1]) {
			    if(a[i] < min) {
				min = a[i];
			    }
			    if(a[i+1] > max) {
				max = a[i+1];
			    }
		    }//i < i+1
		    else {
			    if(a[i+1] < min) {
				min = a[i+1];
			    }
			    if(a[i] > max) {
				max = a[i];
			    }
		    }
		}//end of 2 pair 
		else {
			    if(a[i] < min) {
				min = a[i];
			    }
			    if(a[i] > max) {
				max = a[i];
			    }
		    }
		 i=i+2;   
	    }
	    System.out.println("min = "+min+" max = "+max);
	}

}
