import java.util.Collections;
import java.util.PriorityQueue;

public class SmallestK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int []a = {7,4,5,6,1,8,3,10,11,2,13};
	    smallest(a, 3);
	    for(int i: findSmallest(a,3)) {
		System.out.print(i+" ");
	    }
	}
   static PriorityQueue<Integer> findSmallest(int []a,int k) {
	java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>(k,Collections.reverseOrder());
	for(int i:a) {
	    if(pq.size() >= k) {
		int kk = pq.peek();
		if(kk > i) {
		    pq.remove(kk);
		    pq.add(i);
		}//k > i
	    }//pq == k
	    else {
		pq.add(i);
	    }//end else
	}//for
	return pq;
    }//method
    static void smallest(int []a,int k) {
	int lo = 0,high = a.length-1;
	int kk = partition(a,lo,high);
	System.out.println(kk);
	while(true) {
		System.out.println(kk);
	if(kk == k) {
	    for(int i=0;i<3;i++) {
		System.out.print(a[i]+" ");
	    }//for
	    System.exit(0);
	}//if
	else if(kk > k) {
	    kk = partition(a,lo,kk-1);
	}
	else if(kk < k) {
	    kk = partition(a,kk+1,high);
	}
	}
    }
    static int partition(int []a,int l,int h) {
	if(l==h) 
	    return l;
	int i=l-1;
	for(int j=l;j<h;j++) {
	    if(a[j]<a[h]) {
		i++;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	    }//end if
	}//end for
       	int temp = a[i+1];
       	a[i+1] = a[h];
       	a[h] = temp;
	return i+1;
    }
}
