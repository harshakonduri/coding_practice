public class SquareRootApproach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={2,4,-3,1,6,7,8,9,-1,-7};
		int root = (int)Math.sqrt(a.length);
		//System.out.println(a.length%root);
		int mod = a.length%root;
//		System.out.println(root);
		int []ranges = new int[root+1];
		for(int t = 0;t<=root;t++) {
			int k = t*root;
			int min = Integer.MAX_VALUE;
			//System.out.println(k);
			while(k < (root*t+root) && k<a.length) {
				if(a[k] < min) {
					min = a[k];
				}
				k++;
			}
			ranges[t] = min;
		}
		System.out.println(minVal(0, a.length, ranges, a, root));
	}
static int minVal(int i,int j,int []range,int[]orig,int root) {
	int result = Integer.MAX_VALUE;
	int start = (int)i/root;
	int end = (int)j/root;
	for(int t = start;t<=end;t++) {
		if(range[t] < result) {
			result = range[t];
		}
	}
	return result;
}
}
