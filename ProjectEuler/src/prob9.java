public class prob9 {
public static void main(String [] args) {
	for(int c = 334;c<500;c++){
		for(int b = 251;b<c;b++){
			int a = 1000-(b+c);
			if(java.lang.Math.pow(a, 2)+java.lang.Math.pow(b, 2) == java.lang.Math.pow(c, 2)){
				System.out.println(a+" "+b+" "+c);
			}
		}
	}
}}
/*
 * a= 2mn; b= m^2 -n^2; c= m^2 + n^2;
a + b + c = 1000;

2mn + (m^2 -n^2) + (m^2 + n^2) = 1000;
2mn + 2m^2 = 1000;
2m(m+n) = 1000;
m(m+n) = 500;

m>n;

m= 20; n= 5;

a= 200; b= 375; c= 425;
 */