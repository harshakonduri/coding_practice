import java.util.HashMap; 
import java.util.HashSet;
import java.util.Map; 


public class Isomorphic { 


public static boolean isIsomorphic1(String s1, String s2){ 
if(s1.length() != s2.length()) 
return false; 
else if(s1.length()==1) 
return true; 
else 
{ 
Map<Character,Integer> map1 = new HashMap<Character, Integer>(); 
StringBuffer encodingString1 = new StringBuffer(); 
Map<Character,Integer> map2 = new HashMap<Character, Integer>(); 
StringBuffer encodingString2 = new StringBuffer(); 
for(int i=0;i<s1.length();i++){ 
if(!map1.containsKey(s1.charAt(i))){ 
map1.put(s1.charAt(i), i); 
} 
encodingString1.append(map1.get(s1.charAt(i))); 
System.out.println(map1.get(s1.charAt(i)));

if(!map2.containsKey(s2.charAt(i))){ 
map2.put(s2.charAt(i), i); 
} 
encodingString2.append(map2.get(s2.charAt(i))); 
System.out.println(map2.get(s2.charAt(i)));
} 
return encodingString1.toString().equals(encodingString2.toString()); 
} 
}
public static boolean isomorph(String s1,String s2) {
	if(s1.length() != s2.length()) {
		return false;
	}
	else if(s1.length() == 1) {
		return true;
	}
	else {
		HashSet<Character> h1 = new HashSet<Character>();
		HashSet<Character> h2 = new HashSet<Character>();
		for(int i=0;i<s1.length();i++) {
			h1.add(s1.charAt(i));
			h2.add(s2.charAt(i));
		}
		if(h1.size() == h2.size()) {
			return true;
		}
	}
	return false;
}
public static void main(String[] args) { 

String s1 = "aba"; 
String s2 = "dcx"; 
System.out.println(isIsomorphic1(s1, s2)); 
System.out.println(isomorph(s1, s2));
} 

}