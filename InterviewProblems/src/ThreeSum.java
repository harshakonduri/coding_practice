
public class ThreeSum {
	/**
	 * This problem solves the three sum problem in O(n2) time
	 * in an array A find 3 integers i,j,k which sum to S
	 * A[i]+A[j]+A[k] = S
	 * @param args
	 */
	public static void main(String[] args) {
		int []a = {1,2,4,5,6,7,9,10,11,12,15,20,40,60,100};
		int sum = 31,count=0;
		for(int i=0;i<a.length-2;i++) {
			int first=a[i];
			int second = a[i+1];
			int third = a[a.length-1];
			int rem = sum - first;
			while(second<third) {
				if(first+second+third == sum) {
					System.out.println("Sum is "+sum+"values are "+first+" "+second+" "+third);
					count++;
					second++;
					third--;
				}
				else if(second+third > rem) {
					third--;
				}
				else if(second+third < rem) {
					second++;
				}
			}
		}
		if(count > 0){
			System.out.println("variations are "+count);
		}
		else {
			System.out.println("no such combinations");
		}
	}

}
