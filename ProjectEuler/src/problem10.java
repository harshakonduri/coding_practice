public class problem10 {
public static void main(String [] args) {
	long n = 2000000l;//13195;
	//long l = 600851475143;
	double s = 2000000;//java.lang.Math.floor(java.lang.Math.sqrt((double)n));
	System.out.println(s);
	int [] ar = new int[(int)s];
	ar[1] = 1;
	ar[2] = 0;
	for(int l = 2;l<(int)s;l++) {
		if(ar[l] == 1) 
			continue;
		//if((n%l) == 0)
		int tem = 2;
		while((tem*l) < (int)s) {
			ar[tem*l] = 1;
			tem++;
		}
	}
	long res = 0;
	for(int l = (int)s-1;l>=0;l--) {
		if(ar[l] == 0) {
			//System.out.print(l+" ");
		res+=l;
		}
	}
	System.out.println(res);
}
}
