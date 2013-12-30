
public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapSort h = new HeapSort();
		h.insert(1);
		h.insert(3);
		h.insert(5);
		h.insert(2);
		h.insert(10);
		h.print();
		h.heapsort(0);
		System.out.println();
		h.print();
		System.out.println(h.extractMax());
		h.print();
	}

}
