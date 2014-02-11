public class problem14 {
	static final int RAN = 1000000;
public static void main(String []args) {
	int max = Integer.MIN_VALUE;
	int top = 0;	
	 int[] arr = new int[RAN];
	 arr[1] = 1;
	for(int i = 3; i < RAN;i++) {
		int c = getCount(arr,i);
		arr[i] = c;
		if(c > max) {
			max = c;
			top = i;
		}
	}
	System.out.println(max+" "+top);

}

static int getCount(int[] arr, long i) {
	if(i == 1) {
		return 1;
	}
	long next = 0;
	if(i%2 == 0) {
		next = i/2;
	}
	else {
		next = 3*i + 1;
	}
	if(next < arr.length) {
		if(arr[(int)next] == 0) {
			int t = getCount(arr,next);
			arr[(int)next] = t;
			return 1+t;
		}
		else {
			return 1+arr[(int)next];
		}
	}
	else {
		return 1+getCount(arr,next);
	}

}

}