package srm_practice;

public class BinaryCode {
	public static void main(String [] args) {
		for(String s : new BinaryCode().decode("3")) {
			System.out.println(s);
		}
	}
	public String [] decode(String message) {
		if(message.length() < 2) {
			if((message.charAt(0) - 48) == 0) {
				String [] ret =  new String[2];
				ret[0] = new String("0");
				ret[1] = new String("NONE");
				return ret;
			}
			else if((message.charAt(0) - 48) == 1) {
				String [] ret =  new String[2];
				ret[1] = new String("1");
				ret[0] = new String("NONE");
				return ret;
			}	
			else {
				String [] ret =  new String[2];
				ret[0] = new String("NONE");
				ret[1] = new String("NONE");
				return ret;
			}
 		}
		byte [] res = new byte[message.length()];
		byte [] res1 = new byte[message.length()];
		String [] retVal = new String[2];
		boolean op0 = false,op1=false;
		//assume the first location is 0 or 1
		res[0] = 0;
		res1[0] = 1;
		for(int i = 1; i < res.length; i++) {
			byte val = (byte)(message.charAt(i-1) - 48);
			if((i - 2) >= 0) {
				res[i] = (byte)(val - res[i-1] - res[i-2]);
				res1[i] = (byte)(val - res1[i-1] - res1[i-2]);
			}
			else {
				res[i] = (byte)(val - res[i-1]);
				res1[i] = (byte)(val - res1[i-1]);
			}
			if(res[i] > 1 || res[i] < 0) {
			 op0 = true;
			}
			if(res1[i] > 1 || res1[i] < 0) {
			op1 = true;
			}
		}
		int lastInd = message.length()-1;
		byte lastEnc = (byte)(message.charAt(lastInd) - 48);
		if(lastEnc != (res[lastInd] + res[lastInd-1])) {
			op0 = true;
		} 
		if(lastEnc != (res1[lastInd] + res1[lastInd-1])) {
			op1 = true;
		} 
		if(!op0) {
			StringBuffer sb = new StringBuffer();
			for(byte b : res) {
			sb.append(b);
			}
			retVal[0] = new String(sb);
		}
		else {
		retVal[0] = new String("NONE");
		}
		if(!op1) {
			StringBuffer sb = new StringBuffer();
			for(byte b : res1) {
				sb.append(b);
			}
			retVal[1] = new String(sb);
		}
		else {
			retVal[1] = new String("NONE");
		}
		return retVal;
	}
}
