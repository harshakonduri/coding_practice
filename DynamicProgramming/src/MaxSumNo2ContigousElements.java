public class MaxSumNo2ContigousElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {2,10,20,50,10,1,100};
		int k = findMaxSumWithNo2ContigousElements(A);
		System.out.println("Maximum sum such that 2 consecutive elements are not picked is "+k);
	}

	private static int findMaxSumWithNo2ContigousElements(int[] a) {
		// TODO Auto-generated method stub
		if(a.length == 0 || null == a) {
			System.out.println("NULL");
			return 0;
		}
		if(a.length < 2) {
			return a[0];
		}
		int [] sum = new int[a.length];
		sum[0] = a[0];
		sum[1] = Math.max(a[0],a[1]);
		for(int i = 2;i < a.length;i++) {
			sum[i] = Math.max(sum[i-1],a[i]+sum[i-2]);
		}
		return sum[sum.length-1];
	}

}
