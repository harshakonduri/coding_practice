import java.util.ArrayList;

public class WaysforNSteps {
	
	public static void main(String []args) {
	int n = 12;
	int [] options = {1,2,3};
	findWays(n,options,0,new ArrayList<Integer>());
}

private static void findWays(int n,int []options,int opt,ArrayList<Integer> res) {
	int result = 0;
	if(n == 0) {
		System.out.println(res);
	}
	if(n < 0 || opt >= options.length) {
		return;
	}
	
	for(int i=0;i < options.length;i++) {
		result = n - options[i];
		if(result >= 0) {
		res.add(options[i]);
		findWays(result, options, i, res);
		res.remove(res.size()-1);
	}
	else {
		findWays(result, options, i+1, res);
	}
	}
}
/**
 *
 * param n input
 * this is a dynamic programming solution to solve this exponential problem
 * runs in O(n) time.
 */
private static void dynamicSolution(int n) {
	
	java.math.BigInteger a = new java.math.BigInteger("1");
    	java.math.BigInteger b = new java.math.BigInteger("2");
	java.math.BigInteger r = new java.math.BigInteger("0");
    	for(int i = 2;i < n ; i++) {
	r = a.add(b);
	a = b;
	b = r;   	
	}
	System.out.println(r);
}
}
