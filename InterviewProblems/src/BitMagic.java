
public class BitMagic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static boolean detectOpposites(int i,int j) {
		return ((i ^ j) < 0);
	}
	public static int reverseNumber(int i) {
	int result=0;
	while(i > 0) {
	result =(result*10) + i%10;
	i = i/10;
	}
	return result;
}
	public static int countSetBits(int i) {
	int count = 0;
	while(i > 0) {
		if((i & 1) > 0) {
			count++;
		}
		i = i >> 1;
	}
	return count;
}
}
