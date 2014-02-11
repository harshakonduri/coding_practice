import java.math.BigInteger;

public class problem25 {
public static void main(String [] args) {
	
BigInteger a = new BigInteger("89");
BigInteger b = new BigInteger("144");
long l = 12;
while(true) {
	BigInteger c = a.add(b);
	l++;
	a = b;
	b = c;
	if(c.toString().length() == 1000) {
		System.out.println(l);
		break;
	}
}

}
}
