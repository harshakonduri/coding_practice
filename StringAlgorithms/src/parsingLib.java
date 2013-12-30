import java.util.*;
class parsingLib {
    static final int MAX = Integer.MAX_VALUE;
    static HashMap<Integer,String>STRING_CONVERTERS;
    static HashMap<Integer,String>DEC;
    static {
    	STRING_CONVERTERS = new HashMap<Integer,String>();
    	DEC = new HashMap<Integer,String>();
    	DEC.put(2," hundred");
    	DEC.put(3," thousand");
    	DEC.put(6," million");
    	DEC.put(9," billion");
		STRING_CONVERTERS.put(0,"");
		STRING_CONVERTERS.put(1," one");
		STRING_CONVERTERS.put(2," two");
		STRING_CONVERTERS.put(3," three");
		STRING_CONVERTERS.put(4," four");
		STRING_CONVERTERS.put(5," five");
		STRING_CONVERTERS.put(6," six");
		STRING_CONVERTERS.put(7," seven");
		STRING_CONVERTERS.put(8," eight");
		STRING_CONVERTERS.put(9," nine");
		STRING_CONVERTERS.put(10," ten");
		STRING_CONVERTERS.put(11," eleven");
		STRING_CONVERTERS.put(12," twelve");
		STRING_CONVERTERS.put(13," thirteen");
		STRING_CONVERTERS.put(14," fourteen");
		STRING_CONVERTERS.put(15," fifteen");
		STRING_CONVERTERS.put(16," sixteen");
		STRING_CONVERTERS.put(17," seventeen");
		STRING_CONVERTERS.put(18," eighteen");
		STRING_CONVERTERS.put(19," ninteen");
		STRING_CONVERTERS.put(20," twenty");
		STRING_CONVERTERS.put(30," thirty");
		STRING_CONVERTERS.put(40," forty");
		STRING_CONVERTERS.put(50," fifty");
		STRING_CONVERTERS.put(60," sixty");
		STRING_CONVERTERS.put(70," seventy");
		STRING_CONVERTERS.put(80," eighty");
		STRING_CONVERTERS.put(90," ninty");
    }
    public static void main(String []args){
	String inp = "1";
	int input = 2100100232;
	//System.out.println(Integer.parseInt(inp));
	//System.out.println(intparse(inp));
	System.out.println(100%1000);
		System.out.println(toS(input));
    }
    public static int intparse(String input) throws RuntimeException {
	int result = 0,i=0,remain = MAX;
	boolean neg = false;

	while(i < input.length()) {
	    int c = (int)input.charAt(i);
	    if(c == '-'){
		neg = true;
		i++;
		c = (int) input.charAt(i);
	    }//end neg if

	    if((remain - c) < 0) {
	    	throw new NumberFormatException();
		//		return -1;
	    }//inner if

	    if(c > 47 && c <58) {
	    result = (result*10)+(c-48) ;
	    remain = remain - result*10;
	    }//outer if
	    else {
		throw new NumberFormatException();
		//		break;		
	    }//else
	    i++;
	}//end while
	if(neg) {
		return result*-1;
	}	
	return result;
    }
    public static int getLength(int i) {
	int res = 0;
	while(i > 0) {
	    i = i/10;
	    res++;
	}
	return res;
    }
    public static int getThree(int i,int ii) {
    int result = 0;
    int len = ii;
    for(int l=0;l<len;l++) {
    	int k = i/10;
    	System.out.println(k);
    	result = (result*10)+k;
    	System.out.println(result);
    	i=i/10;
    }
    //System.out.println(result);
    return result;
    }
    public static StringBuffer toS(int input) {
    	StringBuffer s = new StringBuffer();
    	int length = getLength(input);
    	int temp = input;
    	int loop = length/3;
    	for(int i = 0;i<loop;i++) {
    		int x = temp%1000;
    		int l3 = getLength(x);
    		System.out.println(x);
    		int t = 1;//getThree(x,l3);
    		if(t!=0) {
    		StringBuffer getS = toStr(x,l3);
    		temp = temp/1000;
    		//s.insert(0, getS);
    		if(i>=1){
    			  String con = DEC.get(3*i);
    			  s.insert(0,con);
    		}
    		s.insert(0, getS);
    		}
    	}
    	return s;
    }
public static StringBuffer toStr(int input,int length) {
	StringBuffer sb = new StringBuffer();
	int first = 0,rest=0;
	if(length <= 2 && STRING_CONVERTERS.containsKey(input)) {
	    String s = STRING_CONVERTERS.get(input);
	    return sb.append(s);
	}
	else{	    
	    first =  (input / (int)(java.lang.Math.pow(10,length-1)));
	    rest = input % (int)(java.lang.Math.pow(10,length-1));
	    System.out.println(first+" "+rest);
	    StringBuffer s = toStr(rest,length-1);
	    String f = STRING_CONVERTERS.get(first);
	    String con = DEC.get(length-1);
	    
	    if(con != null)
	    {
	    	sb.append(f);
	    	sb.append(con);
	    }
	    if(length == 2) {
	    	String multiple = STRING_CONVERTERS.get(first*10);
	    	sb.append(multiple);
	    }else {
	    
	    }
	    sb.append(s);
	}
	return sb;
    }
    
    
}
