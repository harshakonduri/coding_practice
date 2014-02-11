import java.math.BigInteger;

public class problem16 {

public static void main(String [] args) {
	BigInteger b = new BigInteger("2");
	BigInteger a = b.pow(1000);
	String aa = a.toString();
	int result = 0;
	for(int i = 0; i < aa.length();i++) {
		result+=(((int)aa.charAt(i))-48);
	}
	System.out.println(result);
}
}
