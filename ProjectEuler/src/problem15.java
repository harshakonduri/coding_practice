public class problem15 {
public static void main(String []args) {
	long [][] a = new long[21][21];
	for(int i = 0;i<a.length;i++) {
		a[a.length-1][i] = 1;
		a[i][a.length-1] = 1;
	}

	for(int i = a.length-2; i >=0 ; i--) {
		for(int j = a.length-2; j >=0 ; j--) {
			
				a[i][j] = a[i+1][j] + a[i][j+1];
			
		}
	}
	print(a);
	//System.out.println(a[0][0]);
}
static void print(long [][] a) {

	for(int i = 0; i < a.length ; i++) {
		for(int j = 0; j < a.length ; j++) {
			System.out.print(a[i][j]+" ");
		}
		System.out.println();
	}
}
}
