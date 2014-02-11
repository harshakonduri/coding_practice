import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

class Palindrome {
	static BigInteger []odd = new BigInteger[500000000];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		odd[0] = new BigInteger("26");
		odd[1] = new BigInteger("728");
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int testcases = Integer.parseInt(s);
		for(int t = 0;t < testcases;t++) {
		s = br.readLine();
		int n = Integer.parseInt(s);
		if(n%2 == 0) {
			getPal(n/2);
			
		}
		else {
			getPal((int)Math.floor(n/2)+1);
		}
		}
		}
		catch(IOException iue) {
			System.out.println("hi");
		}
	}

	private static BigInteger getPal(int i) {
		java.math.BigInteger b = new BigInteger("26");
		if(odd[i].toString().length()>0) {
			b = odd[i];
			 return (b.add(b.pow(i-1)));
		}
		else {
			BigInteger p = getPal(i-1);
		}
		return b;
		
	}

}
