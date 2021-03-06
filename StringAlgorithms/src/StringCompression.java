public class StringCompression {
    public static void main(String []args) {
	java.util.Scanner s = new java.util.Scanner(System.in);
	while(true) {
	String str = s.nextLine();
	System.out.println(compress(str));
	}
    }
    static String compress(String s) {
	StringBuffer sb = new StringBuffer();
	int count = 1;
	for(int i=s.length()-1; i>0; i--) {
	    if(s.charAt(i) == s.charAt(i-1)) {
		count++;
	    }
	    else {
		sb.append(""+s.charAt(i)+":"+count+" ");
		count = 1;
	    }

	}
	if(count > 1) { // it means that all characters or atleast the first 3 characters are same.
	
			sb.append(""+s.charAt(1)+":"+count+" ");
			count = 1;
		    
	}
	if(s.charAt(0) == s.charAt(1)) {
	}
	else { // this condition checks if the first char is unique
	    sb.append(s.charAt(0)+":"+1+" ");
	}
	return new String(sb.reverse());
    }
}
