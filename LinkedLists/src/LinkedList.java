public class LinkedList {
    Node head;
    Node tail;
    public LinkedList() {
    
    }
    public Node insert(int i) {
	Node t = new Node(null,i);
	if(null == head) {
	    head = t;
	    tail = t;
	    return head;
	}
	//Node temp=head;
	/*while(temp.next != null) {
	    temp = temp.next;
	}*/
	tail.next = t;
	tail = t;
	return t;
    }
    public void createCycle() {
	Node t = insertMid(9);
	tail.next = t;
    }
    public Node removeCycle() {
	Node slow,fast;
	if(null == head || null == head.next) {
	    return null;
	}
	slow = head;
	fast = head.next;
	while(fast!=null) {
	    fast = fast.next;
	    if(null == fast.next) {
		return null;
	    }
	    fast = fast.next;
	    slow = slow.next;
	    if(slow == fast) {
		slow = head;
		while(true) {
		    if(fast.next == slow) {
			fast.next = null;
			printList();
			return slow;
		    }
		    fast = fast.next;
		    slow = slow.next;
		}
	    }
	}
	return null;
    }    
    public void partition(int x) {
	if(null == search(x)) {
	    return;
	}
	Node i = null,j=head;
	while(null != j) {
	    if(j.data < x) {
		if(null == i) 
		    i = head;
		else 
		    i = i.next;
		
		int t = j.data;
		j.data = i.data;
		i.data = t;
	    }
	    j = j.next;
	}
    }
    public boolean isCyclePresent() {
	Node slow,fast;
	if(null == head || null == head.next) {
	    return false;
	}
	slow = head;
	fast = head.next;
	while(fast!=null) {
	    fast = fast.next;
	    if(null == fast.next) {
		return false;
	    }
	    fast = fast.next;
	    slow = slow.next;
	    if(slow == fast) {
		return true;
	    }
	}
	return false;
    }
    public void iterativeReverse() {
	if(null == head || null == head.next) {
	    return;
	}
	Node p = null,c=head,n = null;
	while(c!=null) {
	    n = c.next;
	    c.next = p;
	    p = c;
	    c = n;
	}
	head = p;
	System.out.println(p.data);
    }
    public Node recursiveReverse(Node h) {
	if(null == h) {
	    return null;
	}
	if(h.next == null) {
		return h;
	}
	Node second = h.next;
	h.next = null;
	Node rest = recursiveReverse(second);
	second.next = h;
	return rest;
    }
    public boolean insert(int i,int pos) {
	if(head == null) {
	    return false;
	}
	int count = 1;
	Node temp = head;
	while(temp.next != null && ++count < pos) {
	    temp = temp.next;
	}
	if(pos > count) {
	    return false;
	}
	Node temp1 = temp.next;
	Node t = new Node(null,i);
	temp.next = t;
	t.next = temp1;
	return true;
    }
    public Node insertMid(int i) {
	Node t = new Node(head,i);
	if(null == head) {
	    
	    return insert(i);
	}
	if(null == head.next) {
	    //Node t = new Node(head,i);
	    head = t;
	    return t;
	}
	Node slow=head,fast=head.next;
        while(null != fast) {
	    fast = fast.next;
	    if(null != fast) {
		fast = fast.next;
		if(null != fast) {
		    slow = slow.next;
		}
		else {
		Node temp = slow.next;
		slow.next = t;
		t.next = temp;
		return t;
	    }
	    }
	    else {
		Node temp = slow.next;
		slow.next = t;
		t.next = temp;
		return t;
	    }
	}
		return null;
	
    }
    public Node search(int i){
	if(head == null) {
	    return null;
	}
	Node temp = head;
	while(temp.next != null) {
	    if(temp.data == i) {
		return temp;
	    }
	    temp = temp.next;
	}
	return null;
    }
    public Node getHead() {
	if(null == head) {
	    return null;
	}
	Node temp = head;
	head = head.next;
	return temp;
    }
    public Node getTail() {
	if(null == head) {
	    return null;
	}
	Node temp = head;
	if(head == tail) {
		head = null;
		return temp;
	}
 	while(temp.next != tail) {
	    temp = temp.next;
	}
	Node last = tail;
	temp.next = null;
	tail = temp;
	return last;
    }
    public boolean delete(int i) {
	if(head == null) {
	    return false;
	}
	if(i == head.data) {
	    Node temp = head.next;
	    head = null;
	    temp = head;
	    return true;
	}
	Node temp = head.next,prev=head;
	while(temp != null) {
	    if(temp.data == i) {
		Node hit = temp;
		prev.next = temp.next;
		hit = null;
		return true;
	    }
	    temp = temp.next;
	    prev = prev.next;
	}
	return false;

    }
    public void printList() {
	Node temp = head;
	if(head == null) {
	    System.out.println("Empty List");
	    return;
	}
	while(temp != null) {
	    System.out.print("---"+temp.data+"---");
	    temp = temp.next;
	}
    System.out.println();
    }
}
