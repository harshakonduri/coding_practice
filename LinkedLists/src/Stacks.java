public class Stacks {
    Node head;
    Node tail;
    public Stacks() {
    
    }
    public Node push(int i) {
	Node t = new Node(null,i);
	if(null == head) {
	    head = t;
	    tail = t;
	    return head;
	}
	t.next = head;
	head = t;
	return t;
    }
    public Node pop() {
	if(head == null) {
	    return null;
	}
	Node temp = head;
	head = head.next;
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
