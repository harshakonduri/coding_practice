import java.util.Scanner;
import java.util.HashMap;
public class FirstNonRepeatedChar {
    public static void main(String []args) {
	Scanner s = new Scanner(System.in);
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	String str = "";
	int globalTime = 0;
	String leastRecentlyRepeated = "";
	int lru = Integer.MAX_VALUE;
	while(true) {
	    str = s.nextLine();
	    if(hm.containsKey(str)) { // char already present
		int time = hm.get(str); // get time of insert
		if(time < lru) {
		    lru = time;
		    leastRecentlyRepeated = str;
		    System.out.println("Repeated "+leastRecentlyRepeated);
		}
	    }
	    else {
		hm.put(str,globalTime);
		globalTime++;
	    }
	} 
    }
}
