public class TestLL {
    public static void main(String []args) {
    	/* List Testing Set */
 	LinkedList list = new LinkedList();
 
	list.printList();
	list.insert(5);
	list.insert(7);
	list.insert(3);
	list.insert(4);
	list.insert(1);
	list.insert(2);
	list.printList();
	list.partition(3);
	System.out.println();
	list.printList();
/*	Node hit = list.search(1);
	System.out.println(list.delete(1));
	list.printList();
	Node hit1 = list.search(1);
	if(null == hit1) {
	    System.out.println("Null");
	}
	list.insert(1,3);
	list.printList();
	list.insertMid(5);
	System.out.println();
	list.printList(); */
	/*list.createCycle();
	System.out.println();
	System.out.println(list.isCyclePresent());
	if(list.isCyclePresent()) {
		Node p = list.removeCycle();
		System.out.println();
		System.out.println(p.data);
	}///
	list.iterativeReverse();
	list.printList();
	list.head = list.recursiveReverse(list.head);
	System.out.println();
	list.printList();
	*/
/* STACK TEST
 *     	Stacks s = new Stacks();
    	s.push(1);
    	s.push(2);
    	s.push(3);
    	s.printList();
    	s.pop();
    	s.peek();
    	s.printList();

 */
    }
}
