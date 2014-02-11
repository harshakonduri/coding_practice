/**
 * 
 * @author sreekonduri
 * sum of squares = n(n+1)(2n+1)/6
 * square of sum = (n(n+1)/2)*(n(n+1)/2)
 * this boils down to one calculation
 * let a = n(n+1)
 * a*a/4 gives square of sum
 * a*(2n+1)/6 gives sum of squares
 */
public class prob6 {
	public static void main(String []args) {
		int n = 100;
		int a = n*(n+1);
		long sumOfSquares = (a*(2*n + 1))/6;
		long squaresOfSum = (a*a)/4;
		System.out.println(squaresOfSum - sumOfSquares);
	}

}
