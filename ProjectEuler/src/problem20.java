import java.math.BigInteger;

public class problem20 {
public static void main(String [] args) {
	BigInteger b = new BigInteger("100");
	for(int i = 99;i > 1;i--) {
		b = b.multiply(new BigInteger(i+""));
	}
	String s = b.toString();
	int result = 0;
	for(int i = 0;i < s.length();i++) {
		int vi = s.charAt(i) - 48;
		result += vi;
	}
	System.out.println(result);
}
}
