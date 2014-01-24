
public class HeapSort {
	
	public static void main(String ars[])
	{
		int []a={1,24,10,8,17,9,3,3,2,4,16};
		//heapsort(a);
		build_max_heap(a);
			//max_heapify(a,0,a.length);
		System.out.println(a[0]);
		a[0] = 1;
		
	}

	static void heapsort(int[] a) {
		int heapsize=a.length-1,temp=0;
	build_max_heap(a);
	for(int i=a.length-1;i>0;i--){
		System.out.println(i+"---");
		temp = a[i];
		a[i]=a[0];
		a[0]=temp;
		heapsize--;
		for(int x:a){
			System.out.print(x+"->");
		}
		System.out.println("");
		max_heapify(a, 0,heapsize);
		for(int x:a){
			System.out.print(x+"->");
		}
		System.out.println("");
	}
	}

	static void build_max_heap(int[] a) {
		int size=a.length-1;
	for(int i=size/2;i>=0;i--)
	{
		max_heapify(a, i,size);
	}
		
	}

	static void max_heapify(int[] a, int i,int size) {
	int l=(2*i)+1;
	int r=(2*i)+2;
	int largest=0,temp=0;
	System.out.println(" ");
	if(l<=size && a[l]>a[i]){
		largest=l;
	}
	else{
		largest=i;
	}
	if(r<=size && a[r]>a[largest]){
		largest=r;
	}
	if(largest!=i){
		temp=a[largest];
		a[largest]=a[i];
		a[i]=temp;
		max_heapify(a, largest,size);
	}
	}
}