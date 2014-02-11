public class Stacks {
    Node head;
    Node tail;
    private int size;
    public Stacks() {
	size = 0;
    }
    public Node push(int i) {
	Node t = new Node(null,i);
	if(null == head) {
	    head = t;
	    tail = t;
	    size++;
	    return head;
	}
	t.next = head;
	head = t;
	size++;
	return t;
    }
    public int getSize() {
	return size;
    }
    public Node pop() {
	if(head == null) {
	    return null;
	}
	Node temp = head;
	head = head.next;
	size--;
	return temp;
    }
    public Node peek() {
	if(null == head) {
	    System.out.println("empty Stack");
	    return null;
	}
	System.out.println("Top of the stack is value "+head.data);
	return head;
    }
    public void printList() {
	Node temp = head;
	if(head == null) {
	    System.out.println("Empty Stack");
	    return;
	}
	while(temp != null) {
	    System.out.print("---"+temp.data+"---");
	    temp = temp.next;
	}
    System.out.println();
    }

}
