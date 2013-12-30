import java.util.*;
class SlidingWindowCharacters {
    public static void main(String [] args) {
	String ch = "abbcbaa";
	String text = "abc";
	findMinWindow(ch,text);
    }
    static void findMinWindow(String c,String t) {
	HashMap<Character,Integer> inphash = new HashMap<Character,Integer>();
	HashMap<Character,Integer> copy = new HashMap<Character,Integer>();
	int st=0,end=c.length()-1;
	int result = Integer.MAX_VALUE;
	for(int i=0;i<t.length();i++) {
	    if(inphash.containsKey((Character)t.charAt(i))) {
		Integer ii = inphash.get(t.charAt(i));
		ii++;
		inphash.remove(t.charAt(i));
		inphash.put(t.charAt(i),ii);
	    }//end if
	    else {
		inphash.put(t.charAt(i),1);
		copy.put(t.charAt(i),0);
	    }//end else
	}//end for
	int target = inphash.size();
	for(int i=0,j=0;i<c.length();) {
	    if(target == 0) {
		int temp = j-i+1;
		if(result > temp) {
		    result = temp;
		    st = i;
		    end = j;
		}
	    }
	    System.out.println(target+" "+i+" "+j+" "+c.length() + copy);
	   if(target > 0 && j<c.length()) {
	    if(copy.containsKey(c.charAt(j))) {
		Integer ii = copy.get(c.charAt(j));
		Integer jj = inphash.get(c.charAt(j));
		ii++;
		copy.remove(c.charAt(j));
		copy.put(c.charAt(j),ii);
		if(ii == jj) {
			target--;
		}
		
		/*
		if(ii < 0) {
		    
		} else {
		    inphash.put(c.charAt(j),0);
		    target = target - 1;
		}
*/
	    }//end if
	    j++;
	   }//end outer if
	   else {
	    if(copy.containsKey(c.charAt(i))) {
		Integer ii = copy.get(c.charAt(i));
		Integer jj = inphash.get(c.charAt(i));
		ii--;
		copy.remove(c.charAt(i));
		copy.put(c.charAt(i),ii);
		if(ii < jj) {
		target++;
		}
/*		if(ii > 0) {
			copy.put(c.charAt(i),ii);
		} else {
		    inphash.put(c.charAt(i),ii);
		    target = target + 1;
		}
*/
	    }//end if
	       i++;
	   }
	}
	System.out.println(""+st+" "+end);
	System.out.println(c.substring(st,end));
    }
}
