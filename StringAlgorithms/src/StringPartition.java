import java.util.ArrayList;
import java.util.HashSet;

public class StringPartition {
	static HashSet<String> dic = new HashSet<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dic.add("pea");
		dic.add("nut");
		dic.add("butter");
		dic.add("peanut");
		dic.add("peanutbutter");
		System.out.println(check("peanutbutter"));
	}
public static boolean check(String s,int i) {
	System.out.println(s);
	if(i>=s.length()) {
		return true;
	}
	boolean pre=false,post=false;
	for(int j = i+1	;j<=s.length();j++) {
		if(dic.contains(s.substring(i,j))) {
			System.out.println(s.substring(i,j));
			pre = true;
			if(j <= s.length())
				post = check(s.substring(j),0);
			//break;
		}
	}
	return (pre&post);
}
public static boolean check(String s) {
	ArrayList<String> ch = new ArrayList<String>();
	int i=0,j=1;
	while(j<=s.length()) {
		if(dic.contains(s.substring(i, j))) {
			ch.add(s.substring(i,j));
			//System.out.println(s.substring(i,j));
			//i = j;
			System.out.println(i+" i j "+j);
			if(ch.size() > 1) {
				System.out.println(ch.get(ch.size()-2)+s.substring(i,j));
				if(dic.contains(ch.get(ch.size()-2)+s.substring(i,j))){
					ch.add(ch.get(ch.size()-2)+s.substring(i,j));
				}
			}
			i = j;
		}
		j++;
	}
String ss = ch.get(ch.size()-1);
if(s.endsWith(ss)) {
	System.out.println(ch);
	return true;
}
else {
	System.out.println(ch);
	return false;
}
}
}
