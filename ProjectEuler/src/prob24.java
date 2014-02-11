import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class prob24 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//combinations("abcd",new StringBuffer(),0);
		PriorityQueue<String> l = new PriorityQueue<String>();
		PriorityQueue<String> p = new PriorityQueue<String>(1000000,new Prob24Comparator());
		permutations(new StringBuffer("0123456789"), 0, 10,p);
		//ArrayList<String> t = l;
		//Collections.sort(t);
//		for(int i = 0; i < l.size()-2;i++) {
	//		System.out.print(l.get(i)+",");
	//	}
	//	System.out.print(l.get(l.size()-1));
		int cou = 0;
		
		//System.out.println(l.toArray();
	}
	public static PriorityQueue<String> permutations(StringBuffer s,int i,int n,PriorityQueue<String> l) {
		if(i == n) {			
			//if(l.size() <= 1000000) {
			//	System.out.println(s);

			l.add(new String(s));
		//	}
			//System.out.println(s);			
			return l;
		}
		//else {
			for(int j = i;j<n;j++) {
			// swap character at i,j
			char t = s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j,t);
			permutations(s, i+1, n,l);
			// set back char at i to j// swap them back to original
			t = s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j,t);
		}
		return l;
		//}
	}
}
