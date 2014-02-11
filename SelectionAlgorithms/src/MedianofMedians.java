public class MedianofMedians {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] a = {5,4,1,6,9,7,11,2,3,10};
	    int piv = medOfMed(a);
	    System.out.println("piv ="+piv);
	    for(int i = 0;i<a.length;i++) {
		if(a[i] == piv) {
		    int temp = a[i];
		    a[i] = a[a.length-1];
		    a[a.length-1] = temp;
		    break;
		}
	    }
	    for(int i=0;i<a.length;i++)
	    	System.out.print(a[i]+" ");
	    int k = partition(a,0,a.length-1);
	    System.out.println("k = "+k);
	    for(int i=0;i<a.length;i++)
	    	System.out.print(a[i]+" ");
	}
    static int medOfMed(int []a) {
	int k = 5;
	int loops = (int) Math.ceil(a.length/k);
	int [] med = new int[loops];
	for(int i = 0;i<loops;i++) {
	int [] temp = new int[5];
	for(int j = 0;j<temp.length;j++) {
	    temp[j] = a[(i*k)+j];
	}
	java.util.Arrays.sort(temp);
	med[i] = temp[(int)Math.ceil((temp.length)/2)];
	}
	
	return med[(med.length-1)/2];
    }
    static int partition(int [] a,int l,int h) {
	if(l==h) {
	    return l;
	}
	int piv = a[h];
	int i = l-1;
	for(int j=l;j<h;j++) {
	    if(a[j] < piv) {
		i++;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	    }
	}
	int temp = a[i+1];
	a[i+1] = a[h];
	a[h] = temp;
	
	return i+1;
    }
}
