public class problem3 {
public static void main(String [] args) {
	long n = 600851475143l;//13195;
	//long l = 600851475143;
	double s = java.lang.Math.floor(java.lang.Math.sqrt((double)n));
	System.out.println(s);
	int [] ar = new int[(int)s];
	ar[2] = 0;
	for(int l = 3;l<(int)s;l++) {
		if(ar[l] == 1) 
			continue;
		//if((n%l) == 0)
		int tem = 2;
		while((tem*l) < (int)s) {
			ar[tem*l] = 1;
			tem++;
		}
	}
	for(int l = (int)s-1;l>=0;l--) {
		if(ar[l] == 0) {
		if(n%l == 0) {
			System.out.println(l);
			break;
		}
		}
	}
}
}
