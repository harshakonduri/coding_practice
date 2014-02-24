
public class LIS {
	public static void main(String[] args) {
    int [] a = {5,6,2,3,4,1,9,9,8,9,5};
	System.out.println(longest(a));
	System.out.println(lis(a));
	}
	/*
	 * a dynamic programming approach to LIS
	 */
    private static int lis(int []a) {
    	int [] storelongest = new int[a.length];
    	int [] fromIndex = new int[a.length];
    	int longest = 1;
    	//initialization step
    	for(int i=0; i < storelongest.length;i++) {
    		storelongest[i] = 1;
    		fromIndex[i] = i;
    	}
    	for(int i = 1;i < a.length;i++) {
    		for(int j = i-1;j>=0;j--) {
    			if(a[j] < a[i]) {
    				if(storelongest[j]+1 > storelongest[i]) {
    					storelongest[i] = storelongest[j]+1;
    					fromIndex[i] = j;
    					if(longest < storelongest[i]) {
    						longest = storelongest[i];
    					}
    				}
    			}
    		}
    	}
    	for(int i = 0;i<a.length;i++) {
    		System.out.println("longest here is "+storelongest[i]+" and came from "+fromIndex[i]);
    	}
    	return longest;
    }
    /*
     * an nlgn approach to finding longest increasing subsequence
     */
    private static int longest(int[]a) {
	int [] table = new int[a.length];
	table[0] = a[0];
	int l = 1;
	for(int i=1;i<a.length;i++) {
	    if(a[i] < table[0]) {
		table[0] = a[i];
	    }
	    else if(a[i] > table[l-1]) {
		table[l++] = a[i];
	    }
	    else {
		int k = ceilIndex(table,a[i],0,l-1);
		table[k] = a[i];
	    }
	}
	return l;
    }
    private static int ceilIndex(int [] a , int n,int lo, int hi) {
    	if(lo>hi) {
    	    return lo; 
    	}
    	int m = lo+(hi-lo)/2;
    	if(a[m] == n) {
    	    return m+1;
    	}
    	else if(a[m] < n) {
    	    return ceilIndex(a, n, m+1, hi);
    	}
    	else {
    	    return ceilIndex(a, n, lo, m-1);
    	}
        }
}
