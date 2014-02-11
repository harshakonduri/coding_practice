import java.util.ArrayList;
import java.util.HashSet;

public class prob23 {
public static void main(String []args) {
	ArrayList<Integer> al = new ArrayList<Integer>();
	long res = 0;
	for(int i = 2;i < 28124;i++) {
		if(div(i) > i) {
			al.add(i);
		}
	}

	
	boolean []a = new boolean[28124];
	for(int i = 0;i<al.size();i++) {
		for(int j = i;j<al.size();j++) {
			int k = al.get(i)+al.get(j);
			if(k < a.length) {
				a[k] = true;
			}
		}
	}
	for(int i = 0;i<28124;i++) {
		//int nat = i;
		if(!a[i]) {
			res+=i;
		}
		else {
			//res+=i;
		}
	}
	System.out.println(res);
}
static boolean canSum(int sum,ArrayList<Integer> a) {
	int i = 0,j=a.size()-1;
	if(sum < a.get(i)) {
		return false;
	}
	while(i < j) {
		if(a.get(i)+a.get(j) == sum) {
			return true;
		}
		else if(a.get(i)+a.get(j) < sum) {
			i++;
		}
		else if(a.get(i)+a.get(j) > sum) {
			j--;
		}
	}
	return false;
}
public static int div(int i) {
	int result = 1;
	HashSet<Integer> hs = new HashSet<Integer>();
	//System.out.println((int)Math.sqrt(i));
	for(int l = 2;l <= (int)Math.sqrt(i) ; l++) {
		if(i%l == 0) {
			if(hs.add(l))
				result = result+l;
			int k = (int)i/l;
			if(hs.add(k))
				result = result+k;
			
		}
	}
	//System.out.println(result);
	return result;
}

}
