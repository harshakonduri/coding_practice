public class SubsetSum {
    public static void main(String[] args) {
	int [] a = {3,4,5,2,10,6};
	hasSum(a, 1);
    }
    static boolean hasSum(int [] a,int S) {
	boolean [][]dp = new boolean[a.length+1][S+1];
	int [][]store = new int[a.length+1][S+1];
	for(int i = 0;i<=a.length;i++) {
	    dp[i][0] = true;
	    store[i][0] = 0;
	}
	for(int i = 1;i<=S;i++) {
	    dp[0][i] = false;
	    store[0][i] = 0;
	}
	
	for(int i = 1;i<=a.length;i++) {
	    for(int j = 1;j<=S;j++) {
		if(a[i-1] <= j) {
		    dp[i][j] = dp[i-1][j] | dp[i-1][j-a[i-1]];
		    store[i][j] = (dp[i-1][j-a[i-1]])?2:((dp[i-1][j])?1:0);
		}
		else {
		    dp[i][j] = dp[i-1][j];
		    store[i][j] = 1;
		}
	    }
	}
	int p = S;
	int d = a.length;
	while(p>0 && d>0) {
	    if(store[d][p] == 2) {
		System.out.print(a[d-1]+" ");
		p = p - a[d-1];
		d = d-1;
	    }
	    else if(store[d][p] == 1) {
		d = d-1;
	    }
	    else if(store[d][p] == 0) {
		d = d-1;
	    }
	}
/*	for(int i = 0;i<=a.length;i++) {
	    for(int j = 0;j<=S;j++) {
	    	System.out.print(dp[i][j]+" ");
    	}
	    System.out.println();
	} */
	System.out.println(dp[a.length][S]);
	return dp[a.length][S];
    }
}
