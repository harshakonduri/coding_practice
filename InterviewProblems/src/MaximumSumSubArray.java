
public class MaximumSumSubArray {

	public static void main(String[] args) {
	int A[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	int max = A[0],sum = A[0], start =0,end=0,temp=0;
	for(int k = 1;k<A.length;k++) {
		if(sum > 0) {
			sum = sum + A[k];
		}
		else {
			sum = A[k];
			temp = k;
		}
		if(sum > max) {
			max = sum;
			start = temp;
			end = k;
		}
	}
	System.out.println("Maximum Sum is :"+max);
	System.out.println("Array Locations start:"+start+" Ends at:"+end);
	}

}
