import java.util.Arrays;

public class ArraySum {

	public static void main(String[] args) {
		int []A = {1,2,3,4,5,6};
		int []B = {3,4,5,6,7,8};
		getSum(A,0,5,B,0,5,8);
	}

	private static void getSum(int[] a, int i, int j, int[] b, int k, int l,
			int m) {
			if(i==j || i == j+1) {
				if(i==j) {
					int ke = Arrays.binarySearch(b, m - a[i]);
					if(ke > 0){
						System.out.println("Pair is"+a[i]+" "+b[ke]);
					}
				}
					else {
						int k1 = Arrays.binarySearch(b, m - a[i]);
						int k2 = Arrays.binarySearch(b, m - a[i+1]);
						if(k1 > 0){
							System.out.println("Pair is"+a[i]+" "+b[k1]);
						}
						if(k2 > 0){
							System.out.println("Pair is"+a[i+1]+" "+b[k2]);
						}	
					}
				
				return;
			}
		if(k==l || k == l+1) {
			if(k == l) {
				int ke = Arrays.binarySearch(a, m - b[k]);
				if(ke > 0){
					System.out.println("Pair is"+a[ke]+" "+b[k]);				
			}
				else {
				int k1 = Arrays.binarySearch(a, m - b[k]);
				int k2 = Arrays.binarySearch(a, m - b[k+1]);
				if(k1 > 0){
					System.out.println("Pair is"+a[k1]+" "+b[k]);
				}
				if(k2 > 0){
					System.out.println("Pair is"+a[k2]+" "+b[k+1]);
				}
				}
		}
			return;
	}
	int m1 = i + (j-i)/2;
	int m2 = k + (l-k)/2;
	if(a[m1]+b[m2] < m) {
		getSum(a, m1+1, j, b, m2+1, l, m);
	}
	else if(a[m1]+b[m2] == m) {
		System.out.println("Pair is"+a[m1]+" "+b[m2]);
		getSum(a, 0, m1-1, b, m2+1, l, m);
		getSum(a, m1+1, j, b, 0, m2-1, m);
	}
	else if(a[m1]+b[m2] > m) {
		getSum(a, 0, m1-1, b, 0, m2-1, m);
	}
}
}
