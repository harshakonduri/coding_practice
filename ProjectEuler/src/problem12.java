import java.util.HashSet;

public class problem12 {

	public static void main(String [] args) {
		int i = 10;
		
		while(true) {
			if(getDivisors(getSum(i)).size() >=500) {
				System.out.println(getSum(i));
				return;
			}
			i++;
		}
	}
	static int getSum(int n) {
		return ((n*(n+1))/2);
	}
	static HashSet<Integer> getDivisors(int n) {
		HashSet<Integer> h = new HashSet<Integer>();
		double s = java.lang.Math.floor(java.lang.Math.sqrt((double)n));
		for(int i = 1;i<=(int)s;i++) {
			if(n%i == 0) {
				h.add(i);
				h.add(n/i);
			}
		}
		return h;
	}
}
