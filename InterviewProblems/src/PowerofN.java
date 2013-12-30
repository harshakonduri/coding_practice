
public class PowerofN {

	public static void main(String[] args) {
		int i = 2,j=0;
		double d = 0.5;
		System.out.println(pown(d,j));
	}
	static double pown(double x,int n) {
		double temp=0.0;
	if(n == 0) {
		return 1.0;
	}
	temp = pown(x,n/2);
	System.out.println(n);
	if(n%2 == 0)
		return temp*temp;
	else
		return x*temp*temp;
	//return result;
	}
	
}
