class HeapSort {
    int []a;
    int size;
    /*public static void main(String [] args) {
	int [] a = {1,2,3,4,5,6};
	buildMaxHeap(a);
	}*/
    public HeapSort() {
	super();
	a = new int[2];
    }
    public void insert(int i) {
	if(size == a.length) {
	    int [] temp = a;
	    int oldlen = a.length;
	    a = new int[oldlen*2];
	    for(int j=0;j<size;j++) {
		a[j] = temp[j];
	    }//copy to double array
	    a[size] = i;
	    size++;
	    percolateUp(size-1);
	}
	else {
	    a[size] = i;
	    size++;
	    percolateUp(size-1);
	}
    }
     void percolateUp(int index) {
	if(index == 0) {
	    return;
	}
	int parent = 0;
	if(0 == index%2) {
	    parent = index/2 - 1;
	}
	else {
	    parent = index/2;
	}
	if(a[index] > a[parent] ) {
	    a[index] = a[index] + a[parent];
	    a[parent] = a[index] - a[parent];
	    a[index]  = a[index] - a[parent];
	    percolateUp(parent);
	}
    }
    
    void heapsort(int type) {// 0 for ascending 1 for descending
    	//buildMaxHeap();
    	if(type == 1) { 
    	buildMinHeap();
    	for(int i = size-1; i > 0; i--) {
    	    a[0] = a[0] + a[i];
    	    a[i] = a[0] - a[i];
    	    a[0]  = a[0] - a[i];
    	    minHeapify(0, i);    		
    	}
    	}
    	else if(type == 0) {
        	buildMaxHeap();
        	for(int i = size-1; i > 0; i--) {
        	    a[0] = a[0] + a[i];
        	    a[i] = a[0] - a[i];
        	    a[0]  = a[0] - a[i];
        	    maxHeapify(0, i);    		
        	}    		
    	}
    	else {
    		System.out.println("Please enter 0 for ascending and 1 for descending orders");
    	}
    }
    void buildMinHeap() {
    	for(int i=size/2;i>=0;i--) {
	    minHeapify(i,size);
	}
    
    }
    void buildMaxHeap() {
	for(int i=size/2;i>=0;i--) {
	    maxHeapify(i,size);
	}
    }
    public void maxHeapify(int index,int heapsize) {
	int l = index*2+1;
	int r = index*2+2;
	int largest=index;
	if(l < heapsize && a[l] > a[index]) {
	    largest = l;
	} 
	if(r < heapsize && a[r] > a[largest]) {
	    largest = r;
	}
	if(largest != index) {
	    a[index] = a[index] + a[largest];
	    a[largest] = a[index] - a[largest];
	    a[index]  = a[index] - a[largest];
	    maxHeapify(largest,heapsize);
	}
    }
    public void minHeapify(int index,int heapsize) {
	int l = index*2+1;
	int r = index*2+2;
	int largest=index;
	if(l < heapsize && a[l] < a[index]) {
	    largest = l;
	} 
	if(r < heapsize && a[r] < a[largest]) {
	    largest = r;
	}
	if(largest != index) {
	    a[index] = a[index] + a[largest];
	    a[largest] = a[index] - a[largest];
	    a[index]  = a[index] - a[largest];
	    minHeapify(largest,heapsize);
	}
    }
    public int getMax() {
	if(size == 0) {
	    return -1;
	}
	return a[0];
    }
    public int extractMax() {
    	if(0 == size) {
    		return -1;
    	}
    	else if(1 == size) {
    		size--;
    		return a[0];
    	}
    	buildMaxHeap();
    	int result = a[0];
	    a[0] = a[0] + a[size-1];
	    a[size-1] = a[0] - a[size-1];
	    a[0]  = a[0] - a[size-1];
	    size--;
	    maxHeapify(0, size);
	    return result;
    }
    public void print() {
	for(int i = 0;i<size;i++) {
	    System.out.print(a[i]+" ");
	}
    }
}
