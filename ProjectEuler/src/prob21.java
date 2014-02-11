import java.util.HashSet;

public class prob21 {
	public static void main(String [] args) {
		int res = 0;
		HashSet<Integer> val = new HashSet<Integer>();
		for(int i = 2;i < 10000;i++) {
			if(!val.contains(i)){
			int k = div(i);
			int p = div(k);
			if(p == i) {
				System.out.println(k+" "+i);
				if(i < 10000) { 
					if(val.add(i)) {
						res+= i;
					}
				}
				if(k < 10000) {
					if(val.add(k)){
						res+=k;
					}
				}
			}
			}
		}
		int temp = 0;
		for(int i : val) {
			temp+=i;
		}
		System.out.println(val+" "+res+" "+temp);
	}
	public static int div(int i) {
		int result = 1;
		//System.out.println((int)Math.sqrt(i));
		for(int l = 2;l < (int)Math.sqrt(i) ; l++) {
			if(i%l == 0) {
				//System.out.println(l+" "+(int)i/l);
				int k = (int)i/l;
				result = result+l+k;
			}
		}
		//System.out.println(result);
		return result;
	}
}
