public class BalancingParanthesis {
    public static void main(String [] args) {
	String input = "()";
	System.out.println(checkSingleParan(input));
    }
    static boolean checkSingleParan(String inp) {
    	if(inp.length() <=0) {
    		return false;
    	}
    	if(inp.charAt(0) != '(') {
	    return false;
	}
	int i=0;
	Stacks paran = new Stacks();
	while(i<inp.length()) {
	    char c = inp.charAt(i);
	    switch(c) {
		case '(':
		    paran.push((int)c);
		break;
		case ')':
		    if(null != paran.peek()) {
			paran.pop();
		    }
		    else {
			return false;
		    }
		break;
		default:
		    return false;
	    }
	    i++;
	}//end while
	if(null != paran.peek()) {
		return false;
	}
	return true;
    }
}
