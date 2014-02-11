
public class prob5 {
	public static void main(String [] args) {
		int res=20;
		for(int i = 19;i>0;i--) {
			res = lcm(res,i);
		}
		System.out.println(res);
	}
static int gcd(int a,int b) { 
		return b == 0 ? a : gcd(b,a % b);
}
static int lcm(int a,int b) {
	return (a*(b/gcd(a,b)));
}
}
/*
 * for smallest divisible number we can take lcm of all the numbers below 20
 * and that is the smallest possible number available
 */