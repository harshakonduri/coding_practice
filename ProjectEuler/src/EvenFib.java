
public class EvenFib {

	public static void main(String[] args) {
int result = 0;
int []fib = new int[10000];
fib[0] = 0;
fib[1] = 1;
		for(int i=2;i<fib.length;i++) {
			fib[i] = fib[i-1]+fib[i-2];
			if(fib[i] >= 4000000) {
				break;
			}
			if(fib[i]%2 == 0) {
				System.out.println(fib[i]);
				result+=fib[i];
			}
		}
		System.out.println(result);
	}

}
