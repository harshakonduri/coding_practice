import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CombinationsofString {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//combinations("abcd",new StringBuffer(),0);
		ArrayList<String> l = new ArrayList<String>();
		l = permutations(new StringBuffer("ab"), 0, 2,l);
		Collections.sort(l);
		for(int i = 0; i < l.size()-2;i++) {
			System.out.print(l.get(i)+",");
		}
		System.out.print(l.get(l.size()-1));
	}
	
	public static void combinations(String ip,StringBuffer op,int index) {
		if(ip.length()==0) {
			return;
		}
		for(int localindex = index; localindex<ip.length();localindex++) {
			op.append(ip.charAt(localindex));
			System.out.println(op);
			combinations(ip, op, localindex+1);
			op.deleteCharAt(op.length()-1);
		}
	}
	public static void kcombinations(String ip,StringBuffer op,int index,int k) {
		if(ip.length()==0) {
			return;
		}
		if(op.length()==k)  {
			System.out.println(op);
		}
		for(int localindex = index; localindex<ip.length();localindex++) {
			op.append(ip.charAt(localindex));
			//System.out.println(op);
			kcombinations(ip, op, localindex+1,k);
			op.deleteCharAt(op.length()-1);
		}
	}

	public static ArrayList<String> permutations(StringBuffer s,int i,int n,ArrayList<String> l) {
		if(i == n) {
			l.add(new String(s));
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
	public static ArrayList<String> getPerms(String s) {
		 ArrayList<String> permutations = new ArrayList<String>();//store the permutations
		 if (s == null) { // error case
		 return null;
		 } else if (s.length() == 0) { // base case
		 permutations.add("");
		 return permutations;
		 }
		
		 char first = s.charAt(0); // get the first character
		 String remainder = s.substring(1); // remove the first character
		 ArrayList<String> words = getPerms(remainder);//recurse on the rest of characters
		 System.out.println(words);
		 for (String word : words) { // for all the words in the list
		 for (int j = 0; j <= word.length(); j++) { // at each position in each word
		 permutations.add(insertCharAt(word, first, j)); // insert the first character at all positions
		 }
		 }
		 return permutations;
		 }
		
		 public static String insertCharAt(String word, char c, int i) {
		 String start = word.substring(0, i);
		String end = word.substring(i);
		System.out.println(start + c + end);
		 return start + c + end;
		 }
}
